/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tqh.pojo.Post;
import com.tqh.repository.PostRepository;
import com.tqh.service.PostService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class PostServiceImpl implements PostService{
    
    @Autowired
    private PostRepository postRepo;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Post> getPosts(Map<String, String> params) {
        return this.postRepo.getPosts(params);
    }

    @Override
    public Long countPost(int id) {
        return this.postRepo.countPost(id);
    }

    @Override
    public boolean addOrUpdatePost(Post p) {
         if (!p.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(p.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                p.setPostImg(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.postRepo.addOrUpdatePost(p);
    }

    @Override
    public Post getPostById(int id) {
        return this.postRepo.getPostById(id);
    }

    @Override
    public boolean deletePost(int idpost) {
        return this.postRepo.deletePost(idpost);
    }

    @Override
    public Long countPost() {
        return this.postRepo.countPost();
    }

    @Override
    public List<Post> getPostsByAdmission(Map<String, String> params, int id) {
        return this.postRepo.getPostsByAdmission(params,id);
    }
    
}
