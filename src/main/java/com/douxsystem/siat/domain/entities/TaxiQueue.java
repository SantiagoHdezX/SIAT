/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.douxsystem.siat.domain.entities;

import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author santiago
 */
@XmlRootElement
@Entity
public class TaxiQueue implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Time HoraLlegada;
    @ManyToOne
    private TaxiDriver TaxiDriver;
    
    @OneToOne
    private Request Request;

    public TaxiQueue() {
    }

    public TaxiQueue(Long Id, Time HoraLlegada, TaxiDriver TaxiDriver, Request Request) {
        this.Id = Id;
        this.HoraLlegada = HoraLlegada;
        this.TaxiDriver = TaxiDriver;
        this.Request = Request;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Time getHoraLlegada() {
        return HoraLlegada;
    }

    public void setHoraLlegada(Time HoraLlegada) {
        this.HoraLlegada = HoraLlegada;
    }

    public TaxiDriver getTaxiDriver() {
        return TaxiDriver;
    }
    
    public void setTaxiDriver(TaxiDriver TaxiDriver) {
        this.TaxiDriver = TaxiDriver;
    }

    public Request getRequest() {
        return Request;
    }

    public void setRequest(Request Request) {
        this.Request = Request;
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
