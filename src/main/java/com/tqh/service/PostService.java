/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tqh.service;

import com.tqh.pojo.Post;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface PostService {
    List<Post> getPosts(Map<String, String> params);
    List<Post> getPostsByAdmission(Map<String, String> params,int id);
    Long countPost(int id);
    Long countPost();
    boolean addOrUpdatePost(Post p);
    Post getPostById(int id);
    boolean deletePost(int id);
}
