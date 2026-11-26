package crm.preset.auth;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class AuthClient {

    private final ConcurrentHashMap<Long, String> tokens = new ConcurrentHashMap<>();

    private String urlCheck() {
        String baseUrl = System.getProperty("api.base_url");

        if (baseUrl == null || baseUrl.isBlank()) {
            throw new IllegalStateException("Системное свойство 'api.base_url' не задано");
        }
        return baseUrl;
    }


    public String signIn(long accountId, String login, String password) {

        if (accountId <= 0) {
            throw new IllegalArgumentException("accountId должен быть больше 0");
        }

        if (login == null || login.isBlank()) {
            throw new IllegalArgumentException("Логин не должен быть null или пустым");
        }

        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Пароль не должен быть null или пустым");
        }

        return tokens.computeIfAbsent(accountId, id -> doSignIn(login, password));
    }

    public String getToken(long accountId) {
        return tokens.get(accountId);
    }

    private String doSignIn(String login, String password) {

        Map<String, String> requestBody = Map.of("login", login, "password", password);

        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri(urlCheck())
                .setContentType(ContentType.JSON)
                .build();

        String token = RestAssured
                .given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post("/v1/auth/sign_in")
                .then()
                .statusCode(200)
                .body("code", equalTo(1))
                .body("access_token", notNullValue())
                .extract()
                .path("access_token");

        if (token == null || token.isBlank()) {
            throw new IllegalStateException("Для учетной записи access_token имеет значение null или является пустым. ");
        }

        return token;
    }

}