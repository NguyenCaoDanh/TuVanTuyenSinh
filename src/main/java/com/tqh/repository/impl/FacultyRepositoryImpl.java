/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.repository.impl;

import com.tqh.pojo.Faculty;
import com.tqh.repository.FacultyRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class FacultyRepositoryImpl implements FacultyRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public List<Faculty> getFalcuties(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Faculty");
        return q.getResultList();
    }

    @Override
    public Faculty getFacultyById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Faculty.class, id);
    }

    @Override
    public Long countFaculty() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT Count(*) FROM Faculty");
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public boolean addOrUpdateFaculty(Faculty f) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (f.getIdfaculty() == null) {
                s.save(f);
            } else {
                s.update(f);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteFalcuty(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Faculty p = this.getFacultyById(id);
        try {
            session.delete(p);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Faculty> getFalcuties() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Faculty");
        return q.getResultList();
    }
}
