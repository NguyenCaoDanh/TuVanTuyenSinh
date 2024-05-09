/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqh.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "admission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admission.findAll", query = "SELECT a FROM Admission a"),
    @NamedQuery(name = "Admission.findByIdadmission", query = "SELECT a FROM Admission a WHERE a.idadmission = :idadmission"),
    @NamedQuery(name = "Admission.findByTypeoftraining", query = "SELECT a FROM Admission a WHERE a.typeoftraining = :typeoftraining")})
public class Admission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idadmission")
    private Integer idadmission;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "typeoftraining")
    private String typeoftraining;
    @OneToMany(mappedBy = "admissionIdadmission")
    @JsonIgnore
    private Set<Post> postSet;

    public Admission() {
    }

    public Admission(Integer idadmission) {
        this.idadmission = idadmission;
    }

    public Admission(Integer idadmission, String typeoftraining) {
        this.idadmission = idadmission;
        this.typeoftraining = typeoftraining;
    }

    public Integer getIdadmission() {
        return idadmission;
    }

    public void setIdadmission(Integer idadmission) {
        this.idadmission = idadmission;
    }

    public String getTypeoftraining() {
        return typeoftraining;
    }

    public void setTypeoftraining(String typeoftraining) {
        this.typeoftraining = typeoftraining;
    }

    @XmlTransient
    public Set<Post> getPostSet() {
        return postSet;
    }

    public void setPostSet(Set<Post> postSet) {
        this.postSet = postSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadmission != null ? idadmission.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admission)) {
            return false;
        }
        Admission other = (Admission) object;
        if ((this.idadmission == null && other.idadmission != null) || (this.idadmission != null && !this.idadmission.equals(other.idadmission))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tqh.pojo.Admission[ idadmission=" + idadmission + " ]";
    }
    
}
