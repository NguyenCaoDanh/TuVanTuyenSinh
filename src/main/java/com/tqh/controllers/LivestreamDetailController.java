/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.controllers;

import com.tqh.pojo.Comment;
import com.tqh.pojo.Livestreams;
import com.tqh.service.CommentService;
import com.tqh.service.LivestreamService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author HP
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:configs.properties")
public class LivestreamDetailController {
    @Autowired
    private LivestreamService livestreamService;
    @Autowired
    private CommentService commentService;


    @GetMapping("/livestreamdetail/{id}")
    public String update(Model model, @PathVariable(value = "id") int id, Map<String, String> params) {
        model.addAttribute("comment", this.commentService.getComments(params));
        model.addAttribute("livestream", this.livestreamService.getLivestreamsById(id));
        model.addAttribute("comments", new Comment());
        return "livestreamdetail";
    }

    @PostMapping("/livestreamdetail/{id}/comment/")
    public String add(@PathVariable(value = "id") int id,
            @ModelAttribute(value = "comments") @Valid Comment c,
            BindingResult rs) {
        Livestreams p = this.livestreamService.getLivestreamsById(id);
        if (!rs.hasErrors()) {
            if (commentService.addCommentLivestream(c, p) == true) {
                return "redirect:/livestreamdetail/" + id;
            }
        }
        return "livestreamdetail";
    } 
}
