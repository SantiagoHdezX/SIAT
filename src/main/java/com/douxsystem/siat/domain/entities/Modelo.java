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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "modelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modelo.findAll", query = "SELECT m FROM Modelo m"),
    @NamedQuery(name = "Modelo.findByIdMod", query = "SELECT m FROM Modelo m WHERE m.idMod = :idMod"),
    @NamedQuery(name = "Modelo.findByNomMod", query = "SELECT m FROM Modelo m WHERE m.nomMod = :nomMod")})
public class Modelo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mod")
    private Integer idMod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_mod")
    private String nomMod;
    @OneToMany(mappedBy = "idMod")
    private Collection<Taxi> taxiCollection;

    public Modelo() {
    }

    public Modelo(Integer idMod) {
        this.idMod = idMod;
    }

    public Modelo(Integer idMod, String nomMod) {
        this.idMod = idMod;
        this.nomMod = nomMod;
    }

    public Integer getIdMod() {
        return idMod;
    }

    public void setIdMod(Integer idMod) {
        this.idMod = idMod;
    }

    public String getNomMod() {
        return nomMod;
    }

    public void setNomMod(String nomMod) {
        this.nomMod = nomMod;
    }

    @XmlTransient
    public Collection<Taxi> getTaxiCollection() {
        return taxiCollection;
    }

    public void setTaxiCollection(Collection<Taxi> taxiCollection) {
        this.taxiCollection = taxiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMod != null ? idMod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modelo)) {
            return false;
        }
        Modelo other = (Modelo) object;
        if ((this.idMod == null && other.idMod != null) || (this.idMod != null && !this.idMod.equals(other.idMod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.douxsystem.siat.domain.entities.Modelo[ idMod=" + idMod + " ]";
    }
    
}
