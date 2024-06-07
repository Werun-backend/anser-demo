package cc.anser;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Main {
    private static final String testNumber = "2022212005";
    private static final String testPassword = "2022212005";
    public static void main(String[] args) {
        RestAssured.baseURI = "http://localhost:8080";
//        RestAssured.baseURI = DEFAULT_URI + DEFAULT_PORT;
        try {
            Map<String, Object> jsonAsMap = new HashMap<>();
            jsonAsMap.put("number", testNumber);
            jsonAsMap.put("password", testPassword);

            Response response = given().
                    contentType(ContentType.JSON).
                    body(jsonAsMap).
                    when().
                    post("/user/login").
                    then().statusCode(200)
                    .body("data.userInformationVo.number", equalTo(testNumber))
                    .extract().response();
            System.out.println("response = " + response.path("data.token"));

            String token = response.path("data.token");

            response = given()
                    .header("satoken", token)
                    .when()
                    .get("/user/information")
                    .then()
                    .statusCode(200)
                    .body("data.username", equalTo("张沣睿")).extract().response();
            System.out.println("response = " + response.path(""));
        } catch (AssertionError e) {
            System.out.println("测试失败！");
            e.printStackTrace();
            return;
        }
        System.out.println("测试完成！");
    }
}

