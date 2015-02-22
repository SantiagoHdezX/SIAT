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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author santiago
 */
@XmlRootElement
@Entity
public class WeeklyTax implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Double Tax;
    @ManyToOne
    private TaxiDriver TaxiDriver;

    public WeeklyTax() {
    }

    public WeeklyTax(Long Id, Double Tax, TaxiDriver TaxiDriver) {
        this.Id = Id;
        this.Tax = Tax;
        this.TaxiDriver = TaxiDriver;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Double getTax() {
        return Tax;
    }

    public void setTax(Double Tax) {
        this.Tax = Tax;
    }

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
