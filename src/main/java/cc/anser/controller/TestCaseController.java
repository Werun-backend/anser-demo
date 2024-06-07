package cc.anser.controller;

import cc.anser.utils.GithubRepoUtil;
import cc.anser.utils.TestCaseUtil;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestCaseController {
    @PostMapping("/testCase")
    public ResponseEntity<?> testCase(@RequestBody Map<String,Object> request) {
        Integer index = (Integer) request.get("testCaseIndex");
        TestCaseUtil.runTestCase(TestCaseUtil.getTestCase(index));
        // 返回一个响应
        return ResponseEntity.ok().body(new HashMap<>().put("message", "Test Case: " + index));
    }
}
