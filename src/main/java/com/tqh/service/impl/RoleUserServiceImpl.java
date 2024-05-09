/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.service.impl;

import com.tqh.pojo.RoleUser;
import com.tqh.repository.RoleUserRepository;
import com.tqh.service.RoleUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class RoleUserServiceImpl implements RoleUserService{
        @Autowired
    private RoleUserRepository roleRepo;

    @Override
    public List<RoleUser> getRoleUser() {
       return this.roleRepo.getRoleUser();
    }

    @Override
    public RoleUser getRoleUserById(int id) {
        return this.roleRepo.getRoleUserById(id);
    }
    
}
