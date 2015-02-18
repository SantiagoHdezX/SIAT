/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.douxsystem.siat.domain.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Santiago
 */
@Entity
@Table(name = "taxi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taxi.findAll", query = "SELECT t FROM Taxi t"),
    @NamedQuery(name = "Taxi.findByPlaTaxi", query = "SELECT t FROM Taxi t WHERE t.plaTaxi = :plaTaxi"),
    @NamedQuery(name = "Taxi.findByMarTaxi", query = "SELECT t FROM Taxi t WHERE t.marTaxi = :marTaxi")})
public class Taxi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "pla_taxi")
    private String plaTaxi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "mar_taxi")
    private String marTaxi;
    @OneToMany(mappedBy = "plaTaxi")
    private Collection<Taxista> taxistaCollection;
    @JoinColumn(name = "id_mod", referencedColumnName = "id_mod")
    @ManyToOne
    private Modelo idMod;
    @JoinColumn(name = "id_anio", referencedColumnName = "id_anio")
    @ManyToOne
    private Anio idAnio;

    public Taxi() {
    }

    public Taxi(String plaTaxi) {
        this.plaTaxi = plaTaxi;
    }

    public Taxi(String plaTaxi, String marTaxi) {
        this.plaTaxi = plaTaxi;
        this.marTaxi = marTaxi;
    }

    public String getPlaTaxi() {
        return plaTaxi;
    }

    public void setPlaTaxi(String plaTaxi) {
        this.plaTaxi = plaTaxi;
    }

    public String getMarTaxi() {
        return marTaxi;
    }

    public void setMarTaxi(String marTaxi) {
        this.marTaxi = marTaxi;
    }

    @XmlTransient
    public Collection<Taxista> getTaxistaCollection() {
        return taxistaCollection;
    }

    public void setTaxistaCollection(Collection<Taxista> taxistaCollection) {
        this.taxistaCollection = taxistaCollection;
    }

    public Modelo getIdMod() {
        return idMod;
    }

    public void setIdMod(Modelo idMod) {
        this.idMod = idMod;
    }

    public Anio getIdAnio() {
        return idAnio;
    }

    public void setIdAnio(Anio idAnio) {
        this.idAnio = idAnio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plaTaxi != null ? plaTaxi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taxi)) {
            return false;
        }
        Taxi other = (Taxi) object;
        if ((this.plaTaxi == null && other.plaTaxi != null) || (this.plaTaxi != null && !this.plaTaxi.equals(other.plaTaxi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.douxsystem.siat.domain.entities.Taxi[ plaTaxi=" + plaTaxi + " ]";
    }
    
}
