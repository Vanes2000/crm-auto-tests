package crm.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import okhttp3.Response;

public class TokenProvider {

    public static String URL_API = "https://crm-4.api.stand.personal-crm.ru/v1/auth/sign_in";

    Response response = RestAssured.given ()
            .baseUri ( URL_API )
            .contentType ( ContentType.JSON )
            .body ( """
                    {"login":"%s","password":"%s"}
                    """.formatted(LOGIN, password))
            .post(LOGIN_PATH); )


}
