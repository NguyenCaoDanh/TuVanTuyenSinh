/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "majors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Majors.findAll", query = "SELECT m FROM Majors m"),
    @NamedQuery(name = "Majors.findByIdmajors", query = "SELECT m FROM Majors m WHERE m.idmajors = :idmajors")})
public class Majors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmajors")
    private Integer idmajors;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "majorname")
    private String majorname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "majorsIdmajors")
    @JsonIgnore
    private Set<Benmarks> benmarksSet;
    @JoinColumn(name = "faculty_idfaculty", referencedColumnName = "idfaculty")
    @ManyToOne(optional = false)
    private Faculty facultyIdfaculty;

    public Majors() {
    }

    public Majors(Integer idmajors) {
        this.idmajors = idmajors;
    }

    public Integer getIdmajors() {
        return idmajors;
    }

    public void setIdmajors(Integer idmajors) {
        this.idmajors = idmajors;
    }

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname;
    }

    @XmlTransient
    public Set<Benmarks> getBenmarksSet() {
        return benmarksSet;
    }

    public void setBenmarksSet(Set<Benmarks> benmarksSet) {
        this.benmarksSet = benmarksSet;
    }

    public Faculty getFacultyIdfaculty() {
        return facultyIdfaculty;
    }

    public void setFacultyIdfaculty(Faculty facultyIdfaculty) {
        this.facultyIdfaculty = facultyIdfaculty;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmajors != null ? idmajors.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Majors)) {
            return false;
        }
        Majors other = (Majors) object;
        if ((this.idmajors == null && other.idmajors != null) || (this.idmajors != null && !this.idmajors.equals(other.idmajors))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tqh.pojo.Majors[ idmajors=" + idmajors + " ]";
    }
    
}
