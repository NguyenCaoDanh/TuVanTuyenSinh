/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tqh.repository;

import com.tqh.pojo.RoleUser;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface RoleUserRepository {
    List<RoleUser> getRoleUser();
    RoleUser getRoleUserById(int id);
}
