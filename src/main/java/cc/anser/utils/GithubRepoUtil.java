package cc.anser.utils;

import cc.anser.entity.RepoEntity;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GithubRepoUtil {

    public static void getRepo(String repoName, String repoPath) throws IOException, GitAPIException {
        GitHub github = new GitHubBuilder().withPassword("Donnie518","Zfr2150483").build();
        GHRepository repo = github.getRepository(repoName);
        System.out.println("repo.getGitTransportUrl() = " + repo.getGitTransportUrl());
        System.out.println("repo.getHtmlUrl() = " + repo.getHtmlUrl());
        System.out.println("repo.getHttpTransportUrl() = " + repo.getHttpTransportUrl());

        File file = new File(repoPath, repoName);
        if(file.mkdirs()) {
            System.out.println("文件夹创建成功！");
        } else {
            System.out.println("文件夹创建失败！");
        }
        Git git = Git.cloneRepository()
                .setURI(repo.getHttpTransportUrl())
                .setDirectory(file)
                .call();

        GithubRepoUtil.repoEntityList.add(new RepoEntity(id++,id,repo.getFullName(),"master","GITHUB"));
    }
    public static String removePrefixAndSuffix(String url) {
        String prefix = "https://github.com/";
        String suffix = ".git";

        if (url.startsWith(prefix)) {
            url = url.substring(prefix.length());
        }

        if (url.endsWith(suffix)) {
            url = url.substring(0, url.length() - suffix.length());
        }

        return url;
    }

    public static List<RepoEntity> repoEntityList = new ArrayList<>();
    public static int id = 0;

    public static void main(String[] args) throws GitAPIException, IOException {
        GithubRepoUtil.getRepo("bearslyricattack/Andulir","");
    }
}
