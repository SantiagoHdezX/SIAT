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
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Santiago
 */
@Entity
@XmlRootElement
public class TaxiDriver implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Nombre;
    private String ApellidoPaterno;
    private String ApellidoMaterno;
    private String Domicilio;
    private Long Telefono;
    private String Licencia;

    @OneToOne
    private Taxi Taxi;

    @OneToMany(mappedBy = "TaxiDriver")
    private Collection<Request> Requests;

    public TaxiDriver() {
    }

    public TaxiDriver(Long Id, String Nombre, String ApellidoPaterno, String ApellidoMaterno, String Domicilio, Long Telefono, String Licencia, Taxi Taxi, Collection<Request> Requests) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.Domicilio = Domicilio;
        this.Telefono = Telefono;
        this.Licencia = Licencia;
        this.Taxi = Taxi;
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

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }

    public Long getTelefono() {
        return Telefono;
    }

    public void setTelefono(Long Telefono) {
        this.Telefono = Telefono;
    }

    public String getLicencia() {
        return Licencia;
    }

    public void setLicencia(String Licencia) {
        this.Licencia = Licencia;
    }

    public Taxi getTaxi() {
        return Taxi;
    }

    public void setTaxi(Taxi Taxi) {
        this.Taxi = Taxi;
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
    public String toString() {
        return "com.douxsystem.siat.domain.entities.TaxiDriver[ Id=" + Id + " ]";
    }
}
