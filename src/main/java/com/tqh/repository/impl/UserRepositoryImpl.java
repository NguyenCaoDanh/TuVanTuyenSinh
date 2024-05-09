/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.repository.impl;

import com.tqh.controllers.IndexController;
import com.tqh.pojo.Users;
import com.tqh.repository.RoleUserRepository;
import com.tqh.repository.UserRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private BCryptPasswordEncoder passEncoder;
    @Autowired
    private Environment env;
    @Autowired
    private RoleUserRepository roleRepo;

    @Override
    public Users getUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Users WHERE username=:un");
        q.setParameter("un", username);

        return (Users) q.getSingleResult();
    }

    @Override
    public boolean authUser(String username, String password) {
        Users u = this.getUserByUsername(username);

        return this.passEncoder.matches(password, u.getPassword());
    }

    @Override
    public Users addUser(Users u) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(u);

        return u;
    }

    @Override
    public boolean addOrUpdateUser(Users user) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (user.getIdusers() == null) {
                if (checkLoginUser(user.getUsername())) {
                    return false;
                } else {
                    user.setRoleUserIdRoleuser(this.roleRepo.getRoleUserById(2));
                    user.setPassword(this.passEncoder.encode(user.getPassword()));
                    s.save(user);
                }
            } else {
                user.setPassword(this.passEncoder.encode(user.getPassword()));
                s.update(user);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean checkLoginUser(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        javax.persistence.Query q = s.createQuery("SELECT Count(*) FROM Users WHERE username=:un");
        q.setParameter("un", username);

        if (Integer.parseInt(q.getSingleResult().toString()) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Users> getUsers(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Users> q = b.createQuery(Users.class);
        Root root = q.from(Users.class);
        q.select(root);

        javax.persistence.Query query = session.createQuery(q);
        if (params != null) {
            String page = params.get("page");
            if (page != null && !page.isEmpty()) {
                int p = Integer.parseInt(page);
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
                query.setMaxResults(pageSize);
                query.setFirstResult((p - 1) * pageSize);
            }
        }
        return query.getResultList();
    }

    @Override
    public Users getUserByLogin(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Users.class, id);
    }
}
