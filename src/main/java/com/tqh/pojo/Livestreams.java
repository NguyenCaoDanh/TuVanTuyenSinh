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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "livestreams")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livestreams.findAll", query = "SELECT l FROM Livestreams l"),
    @NamedQuery(name = "Livestreams.findByIdlivestreams", query = "SELECT l FROM Livestreams l WHERE l.idlivestreams = :idlivestreams"),
    @NamedQuery(name = "Livestreams.findByStartTime", query = "SELECT l FROM Livestreams l WHERE l.startTime = :startTime"),
    @NamedQuery(name = "Livestreams.findByEndTime", query = "SELECT l FROM Livestreams l WHERE l.endTime = :endTime"),
    @NamedQuery(name = "Livestreams.findByCreatedDate", query = "SELECT l FROM Livestreams l WHERE l.createdDate = :createdDate")})
public class Livestreams implements Serializable {

    @Size(max = 255)
    @Column(name = "startTime")
    private String startTime;
    @Size(max = 255)
    @Column(name = "endTime")
    private String endTime;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlivestreams")
    private Integer idlivestreams;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "title")
    private String title;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "livestreaminfomation")
    private String livestreaminfomation;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "picture")
    private String picture;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "linkstream")
    private String linkstream;
    @Column(name = "createdDate")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @JoinColumn(name = "users_idusers", referencedColumnName = "idusers")
    @ManyToOne(optional = false)
    private Users usersIdusers;
    @OneToMany(mappedBy = "livestreamsIdlivestreams")
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

    public Livestreams() {
    }

    public Livestreams(Integer idlivestreams) {
        this.idlivestreams = idlivestreams;
    }

    public Integer getIdlivestreams() {
        return idlivestreams;
    }

    public void setIdlivestreams(Integer idlivestreams) {
        this.idlivestreams = idlivestreams;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLivestreaminfomation() {
        return livestreaminfomation;
    }

    public void setLivestreaminfomation(String livestreaminfomation) {
        this.livestreaminfomation = livestreaminfomation;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLinkstream() {
        return linkstream;
    }

    public void setLinkstream(String linkstream) {
        this.linkstream = linkstream;
    }


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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
        hash += (idlivestreams != null ? idlivestreams.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livestreams)) {
            return false;
        }
        Livestreams other = (Livestreams) object;
        if ((this.idlivestreams == null && other.idlivestreams != null) || (this.idlivestreams != null && !this.idlivestreams.equals(other.idlivestreams))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tqh.pojo.Livestreams[ idlivestreams=" + idlivestreams + " ]";
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

}
