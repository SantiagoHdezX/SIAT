/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.douxsystem.siat.domain.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Santiago
 */
@Entity
@Table(name = "anio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anio.findAll", query = "SELECT a FROM Anio a"),
    @NamedQuery(name = "Anio.findByIdAnio", query = "SELECT a FROM Anio a WHERE a.idAnio = :idAnio"),
    @NamedQuery(name = "Anio.findByFecAnio", query = "SELECT a FROM Anio a WHERE a.fecAnio = :fecAnio")})
public class Anio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_anio")
    private Integer idAnio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_anio")
    @Temporal(TemporalType.DATE)
    private Date fecAnio;
    @OneToMany(mappedBy = "idAnio")
    private Collection<Taxi> taxiCollection;

    public Anio() {
    }

    public Anio(Integer idAnio) {
        this.idAnio = idAnio;
    }

    public Anio(Integer idAnio, Date fecAnio) {
        this.idAnio = idAnio;
        this.fecAnio = fecAnio;
    }

    public Integer getIdAnio() {
        return idAnio;
    }

    public void setIdAnio(Integer idAnio) {
        this.idAnio = idAnio;
    }

    public Date getFecAnio() {
        return fecAnio;
    }

    public void setFecAnio(Date fecAnio) {
        this.fecAnio = fecAnio;
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
        hash += (idAnio != null ? idAnio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anio)) {
            return false;
        }
        Anio other = (Anio) object;
        if ((this.idAnio == null && other.idAnio != null) || (this.idAnio != null && !this.idAnio.equals(other.idAnio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.douxsystem.siat.domain.entities.Anio[ idAnio=" + idAnio + " ]";
    }
    
}
