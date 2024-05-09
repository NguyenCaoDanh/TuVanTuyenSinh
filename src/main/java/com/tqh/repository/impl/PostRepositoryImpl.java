/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.repository.impl;

import com.tqh.pojo.Post;
import com.tqh.pojo.RoleUser;
import com.tqh.pojo.StaticClass;
import com.tqh.pojo.Users;
import com.tqh.repository.PostRepository;
import com.tqh.service.MailService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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
public class PostRepositoryImpl implements PostRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;
    @Autowired
    private MailService mailService;

    @Override
    public List<Post> getPosts(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Post> q = b.createQuery(Post.class);
        Root root = q.from(Post.class);
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
    public Long countPost(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Post> q = b.createQuery(Post.class);
        Root root = q.from(Post.class);
        q.select(root);
        q.where(b.equal(root.get("admissionIdadmission"), id));
        Query query = session.createQuery(q);

        return Long.valueOf(query.getResultList().size());
    }

    @Override
    public boolean addOrUpdatePost(Post p) {
        Session s = this.factory.getObject().getCurrentSession();
        p.setPostinformation(p.getPostinformation().replace("\n", "</br>"));
        try {
            if (p.getIdpost() == null) {
                p.setUsersIdusers(StaticClass.users);
                s.save(p);
            } else {
                p.setUsersIdusers(StaticClass.users);
                s.update(p);
            }
            if (StaticClass.users.getRoleUserIdRoleuser().getName().equals("ROLE_ADMIN")) {
                ArrayList<String> emails = new ArrayList<String>();
                for (Users u : getU()) {
                    emails.add(u.getEmail());
                }
                InternetAddress dests[] = new InternetAddress[emails.size()];
                for (int i = 0; i < emails.size(); i++) {

                    try {
                        dests[i] = new InternetAddress(emails.get(i).trim().toLowerCase());
                    } catch (AddressException ex) {
                        Logger.getLogger(CommentRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                this.mailService.sendHtmlMessage(dests, "HELLO", "<p>Đây là Đại Học Mở Thành Phố Hồ Chí Minh"
                        + "<br/>" + p.getPostName() + "</p>");
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Post getPostById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Post.class, id);
    }

    @Override
    public boolean deletePost(int idpost) {
        Session session = this.factory.getObject().getCurrentSession();
        Post p = this.getPostById(idpost);
        try {
            session.delete(p);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Long countPost() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT Count(*) FROM Post");
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public List<Post> getPostsByAdmission(Map<String, String> params, int id) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Post> q = b.createQuery(Post.class);
        Root root = q.from(Post.class);
        q.select(root);
        q.where(b.equal(root.get("admissionIdadmission"), id));
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
    public List<Users> getU() {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Users> q = b.createQuery(Users.class);
        Root root = q.from(Users.class);
        Root root1 = q.from(RoleUser.class);
        q.select(root);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(root.get("roleUserIdRoleuser"), root1.get("idRoleuser")));
        predicates.add(b.equal(root1.get("name"), "ROLE_USER"));
//        q.where(b.equal(root.get("roleUserIdRoleuser"), root1.get("idRoleuser")));
//        q.where(b.equal(root1.get("name"), "ROLE_TUVAN"));
        q.where(predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);

        return query.getResultList();
    }
}
