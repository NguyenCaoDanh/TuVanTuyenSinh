/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "comment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c"),
    @NamedQuery(name = "Comment.findByIdcomment", query = "SELECT c FROM Comment c WHERE c.idcomment = :idcomment"),
    @NamedQuery(name = "Comment.findByCommentinformation", query = "SELECT c FROM Comment c WHERE c.commentinformation = :commentinformation"),
    @NamedQuery(name = "Comment.findByCreatedDate", query = "SELECT c FROM Comment c WHERE c.createdDate = :createdDate")})
public class Comment implements Serializable {

    @JoinColumn(name = "comment_idcommentReply", referencedColumnName = "idcomment")
    @ManyToOne
    private Comment commentidcommentReply;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcomment")
    private Integer idcomment;
    @Size(max = 255)
    @Column(name = "commentinformation")
    private String commentinformation;
    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @OneToMany(mappedBy = "commentIdcomment")
    @JsonIgnore
    private Set<Comment> commentSet;
    @JoinColumn(name = "comment_idcomment", referencedColumnName = "idcomment")
    @ManyToOne
    private Comment commentIdcomment;
    @JoinColumn(name = "livestreams_idlivestreams", referencedColumnName = "idlivestreams")
    @ManyToOne
    private Livestreams livestreamsIdlivestreams;
    @JoinColumn(name = "post_idpost", referencedColumnName = "idpost")
    @ManyToOne
    private Post postIdpost;
    @JoinColumn(name = "users_idusers", referencedColumnName = "idusers")
    @ManyToOne(optional = false)
    private Users usersIdusers;


    public Comment() {
    }

    public Comment(Integer idcomment) {
        this.idcomment = idcomment;
    }

    public Integer getIdcomment() {
        return idcomment;
    }

    public void setIdcomment(Integer idcomment) {
        this.idcomment = idcomment;
    }

    public String getCommentinformation() {
        return commentinformation;
    }

    public void setCommentinformation(String commentinformation) {
        this.commentinformation = commentinformation;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @XmlTransient
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }

    public Comment getCommentIdcomment() {
        return commentIdcomment;
    }

    public void setCommentIdcomment(Comment commentIdcomment) {
        this.commentIdcomment = commentIdcomment;
    }

    public Livestreams getLivestreamsIdlivestreams() {
        return livestreamsIdlivestreams;
    }

    public void setLivestreamsIdlivestreams(Livestreams livestreamsIdlivestreams) {
        this.livestreamsIdlivestreams = livestreamsIdlivestreams;
    }

    public Post getPostIdpost() {
        return postIdpost;
    }

    public void setPostIdpost(Post postIdpost) {
        this.postIdpost = postIdpost;
    }

    public Users getUsersIdusers() {
        return usersIdusers;
    }

    public void setUsersIdusers(Users usersIdusers) {
        this.usersIdusers = usersIdusers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcomment != null ? idcomment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.idcomment == null && other.idcomment != null) || (this.idcomment != null && !this.idcomment.equals(other.idcomment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tqh.pojo.Comment[ idcomment=" + idcomment + " ]";
    }

    public Comment getCommentidcommentReply() {
        return commentidcommentReply;
    }

    public void setCommentidcommentReply(Comment commentidcommentReply) {
        this.commentidcommentReply = commentidcommentReply;
    }

}
