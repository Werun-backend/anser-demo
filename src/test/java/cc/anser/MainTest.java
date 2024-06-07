package cc.anser;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class MainTest {
    @Test
    void test() {
        RestAssured.baseURI = "https://www.baidu.com";
        given()
                .when()
                .get("/")
                .then()
                .statusCode(200);
//                .body("username", equalTo("testuser"));
    }
}