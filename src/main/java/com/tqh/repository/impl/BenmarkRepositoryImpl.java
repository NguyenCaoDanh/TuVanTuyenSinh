/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.repository.impl;

import com.tqh.pojo.Benmarks;
import com.tqh.pojo.StaticClass;
import com.tqh.repository.BenmarkRepository;
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
public class BenmarkRepositoryImpl implements BenmarkRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public List<Benmarks> getBenMarks(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Benmarks> q = b.createQuery(Benmarks.class);
        Root root = q.from(Benmarks.class);
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
    public Long countBenmarks() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT Count(*) FROM Post");
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public boolean addOrUpdateBenmarks(Benmarks p) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (p.getIdbenmarks() == null) {
                s.save(p);
            } else {
                s.update(p);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Benmarks getBenmarksById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Benmarks.class, id);
    }

    @Override
    public boolean deleteBenmarks(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Benmarks p = this.getBenmarksById(id);
        try {
            session.delete(p);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
