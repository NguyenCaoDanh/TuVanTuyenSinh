package com.tqh.controllers;

import com.tqh.service.AdmissionService;
import com.tqh.service.PostService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:configs.properties")
public class PostListController {

    @Autowired
    private AdmissionService admissionService;
    @Autowired
    private PostService postService;
    @Autowired
    private Environment env;

    @GetMapping("/postlist/{id}/")
    public String update(Model model, @PathVariable(value = "id") int id, @RequestParam Map<String, String> params) {
        model.addAttribute("admissions", this.admissionService.getAdmissionById(id));
        model.addAttribute("posts", this.postService.getPostsByAdmission(params, id));

        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        long count = this.postService.countPost(id);
        model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));
        return "postlist";
    }
}
