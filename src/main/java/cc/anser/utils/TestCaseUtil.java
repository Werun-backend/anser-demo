package cc.anser.utils;

import cc.anser.entity.TestCaseEntity;

import java.util.Map;

public class TestCaseUtil {
    public static TestCaseEntity getTestCase(Integer testCaseIndex) {
        TestCaseEntity testCaseEntity = null;
        for (TestCaseEntity item : TestCaseInitializer.testCases) {
            if (item.getTestCaseIndex().equals(testCaseIndex)) {
                testCaseEntity = item; break;
            }
        }
        return testCaseEntity;
    }

    public static void runTestCase(TestCaseEntity testCaseEntity){
        RestAssuredTestTool.executeTestCase(testCaseEntity);
    }

}
