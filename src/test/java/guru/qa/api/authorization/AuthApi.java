package guru.qa.api.authorization;

import static guru.qa.helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.given;

public class AuthApi {

    public static String authCookieKey = "NOPCOMMERCE.AUTH";

    public String getAuthCookie(String login, String password) {

        return given()
                .filter(withCustomTemplates())
                .contentType("application/x-www-form-urlencoded")
                .formParam("Email", login)
                .formParam("Password", password)
                .when()
                .post("/login")
                .then()
                .log().all()
                .statusCode(302)
                .extract()
                .cookie(authCookieKey);
    }
}
