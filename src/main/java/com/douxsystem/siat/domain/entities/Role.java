/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.douxsystem.siat.domain.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Santiago
 */
@Entity
@XmlRootElement
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String NombreRol;
    private byte NivelAccesso;

    @OneToMany(mappedBy = "Role")
    private Collection<User> Users;

    public Role() {
    }

    public Role(Long Id, String NombreRol, byte NivelAccesso, Collection<User> Users) {
        this.Id = Id;
        this.NombreRol = NombreRol;
        this.NivelAccesso = NivelAccesso;
        this.Users = Users;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNombreRol() {
        return NombreRol;
    }

    public void setNombreRol(String NombreRol) {
        this.NombreRol = NombreRol;
    }

    public byte getNivelAccesso() {
        return NivelAccesso;
    }

    public void setNivelAccesso(byte NivelAccesso) {
        this.NivelAccesso = NivelAccesso;
    }

    @XmlTransient
    public Collection<User> getUsers() {
        return Users;
    }

    public void setUsers(Collection<User> Users) {
        this.Users = Users;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
