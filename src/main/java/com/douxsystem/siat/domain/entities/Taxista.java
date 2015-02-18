/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.douxsystem.siat.domain.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santiago
 */
@Entity
@Table(name = "taxista")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taxista.findAll", query = "SELECT t FROM Taxista t"),
    @NamedQuery(name = "Taxista.findByIdTax", query = "SELECT t FROM Taxista t WHERE t.idTax = :idTax"),
    @NamedQuery(name = "Taxista.findByNomTax", query = "SELECT t FROM Taxista t WHERE t.nomTax = :nomTax"),
    @NamedQuery(name = "Taxista.findByAppTax", query = "SELECT t FROM Taxista t WHERE t.appTax = :appTax"),
    @NamedQuery(name = "Taxista.findByApmTax", query = "SELECT t FROM Taxista t WHERE t.apmTax = :apmTax"),
    @NamedQuery(name = "Taxista.findBySexTax", query = "SELECT t FROM Taxista t WHERE t.sexTax = :sexTax"),
    @NamedQuery(name = "Taxista.findByFecTax", query = "SELECT t FROM Taxista t WHERE t.fecTax = :fecTax"),
    @NamedQuery(name = "Taxista.findByDomTax", query = "SELECT t FROM Taxista t WHERE t.domTax = :domTax"),
    @NamedQuery(name = "Taxista.findByTelTax", query = "SELECT t FROM Taxista t WHERE t.telTax = :telTax")})
public class Taxista implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tax")
    private Integer idTax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "nom_tax")
    private String nomTax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "app_tax")
    private String appTax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "apm_tax")
    private String apmTax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "sex_tax")
    private String sexTax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_tax")
    @Temporal(TemporalType.DATE)
    private Date fecTax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "dom_tax")
    private String domTax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tel_tax")
    private int telTax;
    @JoinColumn(name = "pla_taxi", referencedColumnName = "pla_taxi")
    @ManyToOne
    private Taxi plaTaxi;

    public Taxista() {
    }

    public Taxista(Integer idTax) {
        this.idTax = idTax;
    }

    public Taxista(Integer idTax, String nomTax, String appTax, String apmTax, String sexTax, Date fecTax, String domTax, int telTax) {
        this.idTax = idTax;
        this.nomTax = nomTax;
        this.appTax = appTax;
        this.apmTax = apmTax;
        this.sexTax = sexTax;
        this.fecTax = fecTax;
        this.domTax = domTax;
        this.telTax = telTax;
    }

    public Integer getIdTax() {
        return idTax;
    }

    public void setIdTax(Integer idTax) {
        this.idTax = idTax;
    }

    public String getNomTax() {
        return nomTax;
    }

    public void setNomTax(String nomTax) {
        this.nomTax = nomTax;
    }

    public String getAppTax() {
        return appTax;
    }

    public void setAppTax(String appTax) {
        this.appTax = appTax;
    }

    public String getApmTax() {
        return apmTax;
    }

    public void setApmTax(String apmTax) {
        this.apmTax = apmTax;
    }

    public String getSexTax() {
        return sexTax;
    }

    public void setSexTax(String sexTax) {
        this.sexTax = sexTax;
    }

    public Date getFecTax() {
        return fecTax;
    }

    public void setFecTax(Date fecTax) {
        this.fecTax = fecTax;
    }

    public String getDomTax() {
        return domTax;
    }

    public void setDomTax(String domTax) {
        this.domTax = domTax;
    }

    public int getTelTax() {
        return telTax;
    }

    public void setTelTax(int telTax) {
        this.telTax = telTax;
    }

    public Taxi getPlaTaxi() {
        return plaTaxi;
    }

    public void setPlaTaxi(Taxi plaTaxi) {
        this.plaTaxi = plaTaxi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTax != null ? idTax.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taxista)) {
            return false;
        }
        Taxista other = (Taxista) object;
        if ((this.idTax == null && other.idTax != null) || (this.idTax != null && !this.idTax.equals(other.idTax))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.douxsystem.siat.domain.entities.Taxista[ idTax=" + idTax + " ]";
    }
    
}
