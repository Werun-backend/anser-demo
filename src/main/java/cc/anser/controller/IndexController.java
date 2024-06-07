package cc.anser.controller;

import cc.anser.utils.GithubRepoUtil;
import cc.anser.utils.TestCaseInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/test")
    public String home(Model model)   {
        model.addAttribute(GithubRepoUtil.repoEntityList);
        Object variables = TestCaseInitializer.variables;
        Object testCases = TestCaseInitializer.testCases;
        model.addAttribute(variables);
        model.addAttribute(testCases);
        return "index";
    }

    @RequestMapping("/")
    public String redirect(){
        return "redirect:/test";
    }
}

