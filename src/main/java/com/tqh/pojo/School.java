/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.pojo;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "school")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "School.findAll", query = "SELECT s FROM School s"),
    @NamedQuery(name = "School.findByIdschool", query = "SELECT s FROM School s WHERE s.idschool = :idschool"),
    @NamedQuery(name = "School.findByImageSchool", query = "SELECT s FROM School s WHERE s.imageSchool = :imageSchool")})
public class School implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idschool")
    private Integer idschool;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "description")
    private String description;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "tieuDe")
    private String tieuDe;
    @Size(max = 255)
    @Column(name = "imageSchool")
    private String imageSchool;
    @JoinColumn(name = "users_idusers", referencedColumnName = "idusers")
    @ManyToOne(optional = false)
    private Users usersIdusers;
    @Transient
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public School() {
    }

    public School(Integer idschool) {
        this.idschool = idschool;
    }

    public School(Integer idschool, String description) {
        this.idschool = idschool;
        this.description = description;
    }

    public Integer getIdschool() {
        return idschool;
    }

    public void setIdschool(Integer idschool) {
        this.idschool = idschool;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getImageSchool() {
        return imageSchool;
    }

    public void setImageSchool(String imageSchool) {
        this.imageSchool = imageSchool;
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
        hash += (idschool != null ? idschool.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof School)) {
            return false;
        }
        School other = (School) object;
        if ((this.idschool == null && other.idschool != null) || (this.idschool != null && !this.idschool.equals(other.idschool))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tqh.pojo.School[ idschool=" + idschool + " ]";
    }

}
