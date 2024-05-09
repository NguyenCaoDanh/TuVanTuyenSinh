/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.repository.impl;

import com.tqh.pojo.RoleUser;
import com.tqh.repository.RoleUserRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class RoleUserRepositoryImpl implements RoleUserRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<RoleUser> getRoleUser() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM RoleUser");
        return q.getResultList();
    }

    @Override
    public RoleUser getRoleUserById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(RoleUser.class, id);
    }

}
