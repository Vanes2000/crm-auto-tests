package crm.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class TokenProvider {

    public static String URL_API = "https://crm-4.api.stand.personal-crm.ru";

    public static String LOGIN_PATH = "/v1/auth/sign_in";

    String login = "root";
    String password = "root";

    public String login() {

        Response response = RestAssured.given ( )
                .contentType ( ContentType.JSON )
                .body ( """
                    {"login":"%s","password":"%s"}
                    """.formatted(login, password))
                .when ( )
                .post ( URL_API + LOGIN_PATH );

        int statusCode = response.getStatusCode ();
        if (statusCode != 200) {
            throw new RuntimeException ( "Ошибка авторизации. Ожидался status_code: 200. Ответ сервера : " + response.asString());
        }

        int code = response.jsonPath().getInt("code");
        if (code != 1 ){
            throw new RuntimeException ( "Ошибка авторизации. Ожидался код 1 в ответе : " + response.asString());
        }

        String access_token = response.jsonPath().getString( "access_token" );
        if ( access_token == null || access_token.isBlank()) {
            throw new RuntimeException ( "Ошибка авторизации. access_token отсутствует:" + response.asString());
        }
        return access_token;
    }

}