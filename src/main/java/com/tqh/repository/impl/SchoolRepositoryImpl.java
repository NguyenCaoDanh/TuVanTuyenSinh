/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.repository.impl;


import com.tqh.pojo.School;
import com.tqh.repository.SchoolRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class SchoolRepositoryImpl implements SchoolRepository{
 @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;
    @Override
    public List<School> getSchool(Map<String, String> params) {
         Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<School> q = b.createQuery(School.class);
        Root root = q.from(School.class);
        q.select(root);

        Query query = session.createQuery(q);
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
    public Long countSchool() {
       Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT Count(*) FROM Banner");
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public boolean addOrUpdateSChool(School b) {
        Session s = this.factory.getObject().getCurrentSession();
        
        try {
            if (b.getIdschool()== null) {
                b.setDescription(b.getDescription().replace("\n", "</br>"));
                s.save(b);
            } else {
                b.setDescription(b.getDescription().replace("\n", "</br>"));
                s.update(b);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteSchool(int id) {
         Session session = this.factory.getObject().getCurrentSession();
         School b = this.getSchoolById(id);
        try {
            session.delete(b);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public School getSchoolById(int id) {
       Session session = this.factory.getObject().getCurrentSession();
        return session.get(School.class, id);
    }
    
}
