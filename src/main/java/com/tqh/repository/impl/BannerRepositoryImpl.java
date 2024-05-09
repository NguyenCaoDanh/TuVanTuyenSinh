/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.repository.impl;

import com.tqh.pojo.Banner;
import com.tqh.pojo.StaticClass;
import com.tqh.repository.BannerRepository;
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
 * @author Admin
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class BannerRepositoryImpl implements BannerRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public List<Banner> getBanners(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Banner> q = b.createQuery(Banner.class);
        Root root = q.from(Banner.class);
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
    public Long countBanner() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT Count(*) FROM Banner");
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public boolean addOrUpdateBanner(Banner b) {
        Session s = this.factory.getObject().getCurrentSession();
        b.setUsersIdusers(StaticClass.users);
        try {
            if (b.getIdbanner() == null) {
                s.save(b);
            } else {
                s.update(b);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteBanner(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Banner b = this.getBannerById(id);
        try {
            session.delete(b);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Banner getBannerById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Banner.class, id);
    }

}
