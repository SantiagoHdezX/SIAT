/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.douxsystem.siat.domain.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santiago
 */
@Entity
@XmlRootElement
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long TrackNumber;
    
    @ManyToOne
    private TaxiDriver TaxiDriver;
    @ManyToOne
    private User User;
    private String Origen;
    private String Destino;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Departure_Date;

    public Request() {
    }

    public Request(Long Id, Long TrackNumber, TaxiDriver TaxiDriver, User User, String Origen, String Destino, Date Departure_Date) {
        this.Id = Id;
        this.TrackNumber = TrackNumber;
        this.TaxiDriver = TaxiDriver;
        this.User = User;
        this.Origen = Origen;
        this.Destino = Destino;
        this.Departure_Date = Departure_Date;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Long getTrackNumber() {
        return TrackNumber;
    }

    public void setTrackNumber(Long TrackNumber) {
        this.TrackNumber = TrackNumber;
    }

    public TaxiDriver getTaxiDriver() {
        return TaxiDriver;
    }

    public void setTaxiDriver(TaxiDriver TaxiDriver) {
        this.TaxiDriver = TaxiDriver;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }

    public String getOrigen() {
        return Origen;
    }

    public void setOrigen(String Origen) {
        this.Origen = Origen;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }

    public Date getDeparture_Date() {
        return Departure_Date;
    }

    public void setDeparture_Date(Date Departure_Date) {
        this.Departure_Date = Departure_Date;
    }

}
