/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhan.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author erhan
 */
@Entity
@Table(name = "sinav")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sinav.findAll", query = "SELECT s FROM Sinav s")
    , @NamedQuery(name = "Sinav.findBySinavid", query = "SELECT s FROM Sinav s WHERE s.sinavid = :sinavid")
    , @NamedQuery(name = "Sinav.findBySinavadi", query = "SELECT s FROM Sinav s WHERE s.sinavadi = :sinavadi")})
public class Sinav implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SINAVID")
    private Integer sinavid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SINAVADI")
    private String sinavadi;

    public Sinav() {
    }

    public Sinav(Integer sinavid) {
        this.sinavid = sinavid;
    }

    public Sinav(Integer sinavid, String sinavadi) {
        this.sinavid = sinavid;
        this.sinavadi = sinavadi;
    }

    public Integer getSinavid() {
        return sinavid;
    }

    public void setSinavid(Integer sinavid) {
        this.sinavid = sinavid;
    }

    public String getSinavadi() {
        return sinavadi;
    }

    public void setSinavadi(String sinavadi) {
        this.sinavadi = sinavadi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sinavid != null ? sinavid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sinav)) {
            return false;
        }
        Sinav other = (Sinav) object;
        if ((this.sinavid == null && other.sinavid != null) || (this.sinavid != null && !this.sinavid.equals(other.sinavid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erhan.model.Sinav[ sinavid=" + sinavid + " ]";
    }
    
}
