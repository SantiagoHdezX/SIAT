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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Santiago
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="User.ReturnAllUsers", query="SELECT u FROM User u")
})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Nombre;
    private String ApellidoPaterno;
    private String ApellidoMaterno;
    private String CorreoElectronico;
    private String Passwd;
    
    @OneToOne
    private Address Address;
    
    @ManyToOne
    private Role Role;
    @OneToMany(mappedBy = "User")
    private Collection<Request> Requests;

    public User() {
    }

    public User(Long Id, String Nombre, String ApellidoPaterno, String ApellidoMaterno, String CorreoElectronico, String Passwd, Address Address, Role Role, Collection<Request> Requests) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.CorreoElectronico = CorreoElectronico;
        this.Passwd = Passwd;
        this.Address = Address;
        this.Role = Role;
        this.Requests = Requests;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    public String getPasswd() {
        return Passwd;
    }

    public void setPasswd(String Passwd) {
        this.Passwd = Passwd;
    }

    public Address getAddress() {
        return Address;
    }

    public void setAddress(Address Address) {
        this.Address = Address;
    }

    public Role getRole() {
        return Role;
    }

    public void setRole(Role Role) {
        this.Role = Role;
    }

    @XmlTransient
    public Collection<Request> getRequests() {
        return Requests;
    }

    public void setRequests(Collection<Request> Requests) {
        this.Requests = Requests;
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
