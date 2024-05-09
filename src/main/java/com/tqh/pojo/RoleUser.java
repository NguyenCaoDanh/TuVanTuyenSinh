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
@Table(name = "role_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoleUser.findAll", query = "SELECT r FROM RoleUser r"),
    @NamedQuery(name = "RoleUser.findByIdRoleuser", query = "SELECT r FROM RoleUser r WHERE r.idRoleuser = :idRoleuser"),
    @NamedQuery(name = "RoleUser.findByName", query = "SELECT r FROM RoleUser r WHERE r.name = :name")})
public class RoleUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_roleuser")
    private Integer idRoleuser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "roleUserIdRoleuser")
    @JsonIgnore
    private Set<Users> usersSet;

    public RoleUser() {
    }

    public RoleUser(Integer idRoleuser) {
        this.idRoleuser = idRoleuser;
    }

    public RoleUser(Integer idRoleuser, String name) {
        this.idRoleuser = idRoleuser;
        this.name = name;
    }

    public Integer getIdRoleuser() {
        return idRoleuser;
    }

    public void setIdRoleuser(Integer idRoleuser) {
        this.idRoleuser = idRoleuser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Set<Users> getUsersSet() {
        return usersSet;
    }

    public void setUsersSet(Set<Users> usersSet) {
        this.usersSet = usersSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRoleuser != null ? idRoleuser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleUser)) {
            return false;
        }
        RoleUser other = (RoleUser) object;
        if ((this.idRoleuser == null && other.idRoleuser != null) || (this.idRoleuser != null && !this.idRoleuser.equals(other.idRoleuser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tqh.pojo.RoleUser[ idRoleuser=" + idRoleuser + " ]";
    }
    
}
