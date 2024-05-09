/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tqh.service;

import com.tqh.pojo.Users;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
public interface UserService extends UserDetailsService{
    List<Users> getUsers(Map<String, String> params);
    Users getUserByUn(String username);
    Users getUserByLogin(int id);
    boolean authUser(String username, String password);
    Users addUser(Map<String, String> params, MultipartFile avatar);
    boolean addOrUpdateUser(Users user);
}
