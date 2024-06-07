package cc.anser.utils;


import cc.anser.entity.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
//import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class RestAssuredTestTool {

    /**
     * 初始化RestAssured的基础URI。
     * @param baseURI 基础URI，例如 "http://localhost:8080"
     */
    public static void initRestAssured(String baseURI) {
        RestAssured.baseURI = baseURI;
    }

    /**
     * 发送HTTP请求并返回响应。
     * @param apiRequest API请求实体
     * @return RestAssured的响应对象
     */
    public static Response sendRequest(ApiRequestEntity apiRequest) {
        RequestSpecification request = RestAssured.given();
        request = request.contentType(ContentType.JSON);
        Response response;

        // 设置请求方法
        switch (apiRequest.getMethod()) {
            case "GET":
                response = request.get(apiRequest.getUrl());
                break;
            case "POST":
                response =  request.body(apiRequest.getRequestBody())
                        .post(apiRequest.getUrl());
                break;
            // 可以继续添加其他HTTP方法的处理
            default:
                throw new IllegalArgumentException("Unsupported HTTP method: " + apiRequest.getMethod());
        }

        // 返回响应
        Response response1 = response.then().extract().response();
        return response1;
    }

    /**
     * 验证响应体中的变量。
     * @param responseBody 期望的响应体变量
     * @param response RestAssured的响应对象
     */
    public static void verifyResponseBody(ResponseBodyEntity responseBody, Response response) {
        // 根据responseBody中的var属性来提取响应中的值
        String extractedValue = response.jsonPath().getString(responseBody.getValue());
        String s = "Response body verification failed for var: " + responseBody.getVar();
        Assert.assertEquals( responseBody.getValue(), extractedValue);
    }

    /**
     * 执行测试用例。
     * @param testCase 测试用例实体
     */
    public static void executeTestCase(TestCaseEntity testCase) {
        // 设置初始化变量
        for (VariableEntity variable : testCase.getInitVariables()) {
            System.getProperties().put(variable.getName(), variable.getValue());
        }

        // 发送API请求并存储响应结果
        for (ApiRequestEntity apiRequest : testCase.getApiRequests()) {
            Response response = sendRequest(apiRequest);
            apiRequest.setResponseResult(response.getStatusCode() + "");

            // 验证响应体
            for (ResponseBodyEntity responseBody : apiRequest.getResponseBody()) {
                verifyResponseBody(responseBody, response);
            }
        }

        // 执行断言
        for (AssertionEntity assertion : testCase.getAssertions()) {
//            boolean result = switch (assertion.getVar()) {
//                // 根据变量名进行匹配，这里只是一个示例，您需要根据实际情况来编写case
//                case "#code" -> Integer.parseInt(System.getProperty(assertion.getVar())) == Integer.parseInt(assertion.getMatch());
//                default -> false;
//            };
//            Assert.assertEquals(assertion.getResult(), result);
        }
    }
}