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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author erhan
 */
@Entity
@Table(name = "okulsinav")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Okulsinav.findAll", query = "SELECT o FROM Okulsinav o")
    , @NamedQuery(name = "Okulsinav.findByOkulsinavid", query = "SELECT o FROM Okulsinav o WHERE o.okulsinavid = :okulsinavid")
    , @NamedQuery(name = "Okulsinav.findByOkul", query = "SELECT o FROM Okulsinav o WHERE o.okul = :okul")
    , @NamedQuery(name = "Okulsinav.findBySinavid", query = "SELECT o FROM Okulsinav o WHERE o.sinavid = :sinavid")})
public class Okulsinav implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OKULSINAVID")
    private Integer okulsinavid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OKUL")
    private int okul;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SINAVID")
    private int sinavid;

    public Okulsinav() {
    }

    public Okulsinav(Integer okulsinavid) {
        this.okulsinavid = okulsinavid;
    }

    public Okulsinav(Integer okulsinavid, int okul, int sinavid) {
        this.okulsinavid = okulsinavid;
        this.okul = okul;
        this.sinavid = sinavid;
    }

    public Integer getOkulsinavid() {
        return okulsinavid;
    }

    public void setOkulsinavid(Integer okulsinavid) {
        this.okulsinavid = okulsinavid;
    }

    public int getOkul() {
        return okul;
    }

    public void setOkul(int okul) {
        this.okul = okul;
    }

    public int getSinavid() {
        return sinavid;
    }

    public void setSinavid(int sinavid) {
        this.sinavid = sinavid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (okulsinavid != null ? okulsinavid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Okulsinav)) {
            return false;
        }
        Okulsinav other = (Okulsinav) object;
        if ((this.okulsinavid == null && other.okulsinavid != null) || (this.okulsinavid != null && !this.okulsinavid.equals(other.okulsinavid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erhan.model.Okulsinav[ okulsinavid=" + okulsinavid + " ]";
    }
    
}
