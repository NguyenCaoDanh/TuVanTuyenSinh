/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p"),
    @NamedQuery(name = "Post.findByIdpost", query = "SELECT p FROM Post p WHERE p.idpost = :idpost"),
    @NamedQuery(name = "Post.findByPostImg", query = "SELECT p FROM Post p WHERE p.postImg = :postImg"),
    @NamedQuery(name = "Post.findByCreatedDate", query = "SELECT p FROM Post p WHERE p.createdDate = :createdDate")})
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpost")
    private Integer idpost;
    @Basic(optional = false)
    @NotNull(message = "{post.name.notNull}")
    @Lob
    @Size(min = 1, max = 2147483647, message = "{post.name.lenErr}")
    @Column(name = "postName")
    private String postName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647, message = "{post.desc.lenErr}")
    @Column(name = "postinformation")
    private String postinformation;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "posttype")
    private String posttype;
    @Size(max = 255)
    @Column(name = "postImg")
    private String postImg;
    @Column(name = "createdDate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @JoinColumn(name = "admission_idadmission", referencedColumnName = "idadmission")
    @ManyToOne   
    private Admission admissionIdadmission;
    @JoinColumn(name = "faculty_idfaculty", referencedColumnName = "idfaculty")
    @ManyToOne
    private Faculty facultyIdfaculty;
    @JoinColumn(name = "users_idusers", referencedColumnName = "idusers")
    @ManyToOne
    private Users usersIdusers;
    @OneToMany(mappedBy = "postIdpost")
    @JsonIgnore
    private Set<Comment> commentSet;
    @Transient
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Post() {
    }

    public Post(Integer idpost) {
        this.idpost = idpost;
    }

    public Post(Integer idpost, String postName, String postinformation) {
        this.idpost = idpost;
        this.postName = postName;
        this.postinformation = postinformation;
    }

    public Integer getIdpost() {
        return idpost;
    }

    public void setIdpost(Integer idpost) {
        this.idpost = idpost;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostinformation() {
        return postinformation;
    }

    public void setPostinformation(String postinformation) {
        this.postinformation = postinformation;
    }

    public String getPosttype() {
        return posttype;
    }

    public void setPosttype(String posttype) {
        this.posttype = posttype;
    }

    public String getPostImg() {
        return postImg;
    }

    public void setPostImg(String postImg) {
        this.postImg = postImg;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Admission getAdmissionIdadmission() {
        return admissionIdadmission;
    }

    public void setAdmissionIdadmission(Admission admissionIdadmission) {
        this.admissionIdadmission = admissionIdadmission;
    }

    public Faculty getFacultyIdfaculty() {
        return facultyIdfaculty;
    }

    public void setFacultyIdfaculty(Faculty facultyIdfaculty) {
        this.facultyIdfaculty = facultyIdfaculty;
    }

    public Users getUsersIdusers() {
        return usersIdusers;
    }

    public void setUsersIdusers(Users usersIdusers) {
        this.usersIdusers = usersIdusers;
    }

    @XmlTransient
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpost != null ? idpost.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.idpost == null && other.idpost != null) || (this.idpost != null && !this.idpost.equals(other.idpost))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tqh.pojo.Post[ idpost=" + idpost + " ]";
    }

}
