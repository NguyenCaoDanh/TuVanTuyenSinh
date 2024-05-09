/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.controllers;

import com.tqh.pojo.Faculty;
import com.tqh.pojo.Post;
import com.tqh.pojo.Users;
import com.tqh.service.AdmissionService;
import com.tqh.service.FacultyService;
import com.tqh.service.PostService;
import java.security.Principal;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Admin
 */
@RequestMapping("/admin")
@Controller
@PropertySource("classpath:configs.properties")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private AdmissionService admissionService;
    @Autowired
    private Environment env;

    @GetMapping("/posts")
    public String list(Model model, Principal p) {
        model.addAttribute("post", new Post());
        return "posts";
    }

    @GetMapping("/posts/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("post", this.postService.getPostById(id));
        return "posts";
    }

    @PostMapping("/posts")
    public String add(@ModelAttribute(value = "post") @Valid Post p,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            if (postService.addOrUpdatePost(p) == true) {
                return "redirect:/";
            }
        }
        return "posts";
    }

    @RequestMapping("/posts")
    public String listpost(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("dspost", this.postService.getPosts(params));
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        long count = this.postService.countPost();
        model.addAttribute("counter", Math.ceil(count * 1.0 / pageSize));
        return "posts";
    }

}
