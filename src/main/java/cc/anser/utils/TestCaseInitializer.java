package cc.anser.utils;

import cc.anser.entity.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCaseInitializer {

    public static List<TestCaseEntity> testCases;
    // 创建变量列表
    public static List<VariableEntity> variables;
    public static void init() {
        // 创建测试用例1的初始化变量列表
        List<VariableEntity> initVariables1 = Arrays.asList(
                new VariableEntity("#inputUsername", "jinyong"),
                new VariableEntity("#inputPassword", "123456"),
                new VariableEntity("#code200", "200")
        );

        // 创建测试用例1的请求体列表
        List<RequestBodyEntity> requestBody1 = Arrays.asList(
                new RequestBodyEntity("number", "#inputUsername"),
                new RequestBodyEntity("password", "#inputPassword")
        );

        // 创建测试用例1的响应体列表
        List<ResponseBodyEntity> responseBody1 = Arrays.asList(
                new ResponseBodyEntity("#outputUsername", "data.empVo.username")
        );

        // 创建测试用例1的断言列表
        List<AssertionEntity> assertions1 = Arrays.asList(
                new AssertionEntity("#outputUsername", "#inputUsername", "通过")
        );

        // 创建测试用例1
        TestCaseEntity testCase1 = new TestCaseEntity(
                1,
                "测试登录注册接口连通性",
                "接口通过",
                initVariables1,
                Arrays.asList(
                        new ApiRequestEntity("/user/login", "POST", requestBody1, responseBody1, "未测试")
                ),
                assertions1
        );

        // 创建测试用例2的初始化变量列表
        List<VariableEntity> initVariables2 = Arrays.asList(
                new VariableEntity("#inputUsername", "2022212005"),
                new VariableEntity("#inputPassword", "2022212005"),
                new VariableEntity("#code200", "200")
        );

        // 创建测试用例2的请求体列表和响应体列表
        List<RequestBodyEntity> requestBody2 = Arrays.asList(
                new RequestBodyEntity("number", "#inputUsername"),
                new RequestBodyEntity("password", "#inputPassword")
        );
        List<ResponseBodyEntity> responseBody2 = Arrays.asList(
                new ResponseBodyEntity("#token", "data.token")
        );
        List<RequestBodyEntity> requestBody3 = Collections.emptyList(); // GET请求通常没有请求体
        List<ResponseBodyEntity> responseBody3 = Arrays.asList(
                new ResponseBodyEntity("#name", "data.username"),
                new ResponseBodyEntity("#code", "code")
        );

        // 创建测试用例2的断言列表
        List<AssertionEntity> assertions2 = Arrays.asList(
                new AssertionEntity("#name", "#assertName", "不通过"), // 注意：这里的#assertName变量未定义，需要替换为实际变量名
                new AssertionEntity("#code", "#code200", "通过")
        );

        // 创建测试用例2的API请求列表
        List<ApiRequestEntity> apiRequests2 = Arrays.asList(
                new ApiRequestEntity("/login", "POST", requestBody2, responseBody2, "未测试"),
                new ApiRequestEntity("/user/information", "GET",requestBody3, responseBody3, "未测试")
        );

        // 创建测试用例2
        TestCaseEntity testCase2 = new TestCaseEntity(
                2,
                "测试登录账号并获得个人信息 比对登录信息和获得的个人信息",
                "未测试",
                initVariables2,
                apiRequests2,
                assertions2
        );

        // 将测试用例添加到静态列表中
        testCases = Arrays.asList(testCase1, testCase2);

        variables = Arrays.asList(
                new VariableEntity("#inputUsername", ""),
                new VariableEntity("#inputPassword", ""),
                new VariableEntity("#outputUsername", ""),
                new VariableEntity("#token", ""),
                new VariableEntity("#code", ""),
                new VariableEntity("#code200", "")
        );
    }

    public static void main(String[] args) {
        TestCaseInitializer.init();
        System.out.println("testCases = " + testCases);
    }
}