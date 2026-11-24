package crm.preset.auth;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AuthClient {

    public String signIn(long accountId, String login, String password) {

        ConcurrentHashMap<Long, String> tokens = new ConcurrentHashMap<>();


        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("login", login);
        requestBody.put("password", password);

        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri(System.getProperty("api.base_uri"))
                .setContentType(ContentType.JSON)
                .build();

        Response response = RestAssured
                .given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post("/v1/auth/sign_in")
                .then()
                .statusCode(200)
                .extract()
                .response();

        String token = response.jsonPath().getString("token");

        if (token == null || token.isBlank()) {
            throw new IllegalStateException("токен не должен быть null, получено " + tokens);
        }
        return token;

    }

}
