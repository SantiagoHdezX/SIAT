/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.douxsystem.siat.domain.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Santiago
 */
@Entity
@XmlRootElement
public class Taxi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Placa;
    @ManyToOne
    private Car Car;

    @OneToOne(mappedBy = "Taxi")
    private TaxiDriver TaxiDriver;

    public Taxi() {
    }

    public Taxi(Long Id, String Placa, Car Car, TaxiDriver TaxiDriver) {
        this.Id = Id;
        this.Placa = Placa;
        this.Car = Car;
        this.TaxiDriver = TaxiDriver;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public Car getCar() {
        return Car;
    }

    public void setCar(Car Car) {
        this.Car = Car;
    }
    
    @XmlTransient
    public TaxiDriver getTaxiDriver() {
        return TaxiDriver;
    }

    public void setTaxiDriver(TaxiDriver TaxiDriver) {
        this.TaxiDriver = TaxiDriver;
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
