/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.service.impl;

import com.tqh.pojo.Comment;
import com.tqh.pojo.Livestreams;
import com.tqh.pojo.Post;
import com.tqh.pojo.Users;
import com.tqh.repository.CommentRepository;
import com.tqh.repository.UserRepository;
import com.tqh.service.CommentService;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepo;
    @Autowired
    private UserRepository userRepo;

    @Override
    public List<Comment> getComments(Map<String, String> params) {
       return this.commentRepo.getComments(params);
    }

    @Override
    public boolean addComment(Comment c,Post p, Principal a) {
//        c.setCreatedDate(new Date());
//        
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Users u = this.userRepo.getUserByUsername(authentication.getName());
//        c.setUsersIdusers(u);
        
        return this.commentRepo.addComment(c,p,a);
    }

    @Override
    public Comment getCommentById(int id) {
        return this.commentRepo.getCommentById(id);
    }

    @Override
    public Long countComment(int id) {
        return this.commentRepo.countComment(id);
    }

    @Override
    public boolean addCommentLivestream(Comment c, Livestreams l) {
        return this.commentRepo.addCommentLivestream(c, l);
    }

    @Override
    public boolean addComment1(Comment c, Post p, Principal a, Comment c1, Comment c2) {
       return this.commentRepo.addComment1(c,p,a,c1,c2);
    }
}
