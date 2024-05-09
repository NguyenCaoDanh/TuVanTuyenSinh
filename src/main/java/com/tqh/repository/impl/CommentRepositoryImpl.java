/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.repository.impl;

import com.tqh.pojo.Comment;
import com.tqh.pojo.Livestreams;
import com.tqh.pojo.Post;
import com.tqh.pojo.RoleUser;
import com.tqh.pojo.StaticClass;
import com.tqh.pojo.Users;
import com.tqh.repository.CommentRepository;
import com.tqh.service.MailService;
import com.tqh.service.UserService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
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
public class CommentRepositoryImpl implements CommentRepository {

    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;
    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public List<Comment> getComments(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Comment> q = b.createQuery(Comment.class);
        Root root = q.from(Comment.class);
        q.select(root);

        Query query = session.createQuery(q);

        if (params != null) {
            String page = params.get("page2");
            if (page != null && !page.isEmpty()) {
                int p = Integer.parseInt(page);
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE_2"));

                query.setMaxResults(pageSize);
                query.setFirstResult((p - 1) * pageSize);
            }
        }
        return query.getResultList();

    }

    @Override
    public boolean addComment(Comment c, Post p, Principal a) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            c.setUsersIdusers(this.userService.getUserByUn(a.getName()));
            c.setPostIdpost(p);
            c.setCreatedDate(new Date());
            s.save(c);

            if (StaticClass.users.getRoleUserIdRoleuser().getName().equals("ROLE_USER")) {
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
                this.mailService.sendHtmlMessage(dests, "HELLO", "<p>Có câu hỏi mới"
                        + " của bài viết: " + p.getPostName() + " <br/>Có mã: " + p.getIdpost()
                        + "<br/>Nội dung câu hỏi: " + c.getCommentinformation() + " <br/>Của người dùng: " + StaticClass.users.getUsername()
                        + "<br/>Vào lúc: " + c.getCreatedDate() + "</p>");
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Comment getCommentById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Comment.class, id);
    }

    @Override
    public Long countComment(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Comment> q = b.createQuery(Comment.class);
        Root root = q.from(Comment.class);
        q.select(root);
        q.where(b.equal(root.get("postIdpost"), id));
        Query query = session.createQuery(q);

        return Long.valueOf(query.getResultList().size());
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
        predicates.add(b.equal(root1.get("name"), "ROLE_TUVAN"));
//        q.where(b.equal(root.get("roleUserIdRoleuser"), root1.get("idRoleuser")));
//        q.where(b.equal(root1.get("name"), "ROLE_TUVAN"));
        q.where(predicates.toArray(Predicate[]::new));
        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public boolean addCommentLivestream(Comment c, Livestreams l) {
        Session s = this.factory.getObject().getCurrentSession();
        try {

            c.setUsersIdusers(StaticClass.users);
            c.setLivestreamsIdlivestreams(l);
            c.setCreatedDate(new Date());
            s.save(c);

            if (StaticClass.users.getRoleUserIdRoleuser().getName().equals("ROLE_USER")) {
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
                this.mailService.sendHtmlMessage(dests, "HELLO", "<p>Có câu hỏi mới"
                        + " của bài viết: " + l.getTitle() + " <br/>Có mã: " + l.getIdlivestreams()
                        + "<br/>Nội dung câu hỏi: " + c.getCommentinformation() + " <br/>Của người dùng: " + StaticClass.users.getUsername()
                        + "<br/>Vào lúc: " + c.getCreatedDate() + "</p>");
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addComment1(Comment c, Post p, Principal a, Comment c1, Comment c2) {
         Session s = this.factory.getObject().getCurrentSession();
        try {
            c.setUsersIdusers(this.userService.getUserByUn(a.getName()));
            c.setPostIdpost(p);
            c.setCreatedDate(new Date());
            c.setCommentIdcomment(c1);
            c.setCommentidcommentReply(c2);
            s.save(c);

            if (StaticClass.users.getRoleUserIdRoleuser().getName().equals("ROLE_USER")) {
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
                this.mailService.sendHtmlMessage(dests, "HELLO", "<p>Có câu hỏi mới"
                        + " của bài viết: " + p.getPostName() + " <br/>Có mã: " + p.getIdpost()
                        + "<br/>Nội dung câu hỏi: " + c.getCommentinformation() + " <br/>Của người dùng: " + StaticClass.users.getUsername()
                        + "<br/>Vào lúc: " + c.getCreatedDate() + "</p>");
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
