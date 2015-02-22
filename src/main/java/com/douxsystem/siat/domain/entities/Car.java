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
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Santiago
 */
@Entity
@XmlRootElement
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Nombre;
    @ManyToOne
    private Brand Brand;
    private String Tipo;
    private Long Anio;

    @OneToMany(mappedBy = "Car")
    private Collection<Taxi> Taxis;

    public Car() {
    }

    public Car(Long Id, String Nombre, Brand Brand, String Tipo, Long Anio, Collection<Taxi> Taxis) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Brand = Brand;
        this.Tipo = Tipo;
        this.Anio = Anio;
        this.Taxis = Taxis;
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

    public Brand getBrand() {
        return Brand;
    }

    public void setBrand(Brand Brand) {
        this.Brand = Brand;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public Long getAnio() {
        return Anio;
    }

    public void setAnio(Long Anio) {
        this.Anio = Anio;
    }
    @XmlTransient
    public Collection<Taxi> getTaxis() {
        return Taxis;
    }

    public void setTaxis(Collection<Taxi> Taxis) {
        this.Taxis = Taxis;
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
