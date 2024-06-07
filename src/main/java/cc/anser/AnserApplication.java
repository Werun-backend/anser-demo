package cc.anser;

import cc.anser.entity.RepoEntity;
import cc.anser.utils.GithubRepoUtil;
import cc.anser.utils.TestCaseInitializer;
import cn.dev33.satoken.quick.SaQuickManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnserApplication {
    public static void main(String[] args) {
//        System.setProperty("http.proxyHost", "127.0.0.1");
//        System.setProperty("http.proxyPort", "7890");
//        GithubRepoUtil.repoEntityList.add(new RepoEntity(GithubRepoUtil.id++,GithubRepoUtil.id,"\t\n" +
//                "bearslyricattack/Andulir","master","GITHUB"));
        TestCaseInitializer.init();
        SpringApplication.run(AnserApplication.class,args);
        System.out.println("\n------ 启动成功 ------");
        System.out.println("name: " + SaQuickManager.getConfig().getName());
        System.out.println("pwd:  " + SaQuickManager.getConfig().getPwd());
    }
}
