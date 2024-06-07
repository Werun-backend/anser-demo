package cc.anser.controller;


import cc.anser.utils.GithubRepoUtil;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GithubRepoController {
    @Value("${anser.repoPath}")
    private String repoPath ;
    @PostMapping("/fetch-repo")
    public ResponseEntity<?> fetchRepo(@RequestBody Map<String, String> request) throws GitAPIException, IOException {
        String githubUrl = request.get("url");
        // 处理 GitHub URL
        String repoName = GithubRepoUtil.removePrefixAndSuffix(githubUrl);
        // 例如，克隆仓库，获取仓库信息等
        System.out.println("repoPath = " + repoPath);
        GithubRepoUtil.getRepo(repoName,repoPath);
        // 返回一个响应
        return ResponseEntity.ok().body(new HashMap<>().put("message", "URL received: " + githubUrl));
    }


}
