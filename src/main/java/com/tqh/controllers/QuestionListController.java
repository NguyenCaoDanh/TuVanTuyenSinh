/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.controllers;

import com.tqh.service.CommentService;
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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HP
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:configs.properties")
public class QuestionListController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private PostService postService;
    @Autowired
    private Environment env;
    
    @GetMapping("/questionlist/{id}/")
    public String update(Model model, @PathVariable(value = "id") int id, @RequestParam Map<String, String> params) {
        model.addAttribute("comments", this.commentService.getComments(params));
        model.addAttribute("post2",this.postService.getPostById(id));
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE_2"));
        long count = this.commentService.countComment(id);
        model.addAttribute("counter2", Math.ceil(count * 1.0 / pageSize));
        return "questionlist";
    }    
}
