/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tqh.repository;

import com.tqh.pojo.Post;
import com.tqh.pojo.Users;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public interface PostRepository {
    List<Post> getPosts(Map<String, String> params);
    List<Post> getPostsByAdmission(Map<String, String> params,int id);
    Long countPost(int id);
    Long countPost();
    boolean addOrUpdatePost(Post p);
    Post getPostById(int id);
    boolean deletePost(int id);
        List<Users> getU();
}
