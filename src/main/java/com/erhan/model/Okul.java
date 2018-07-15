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
@Table(name = "okul")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Okul.findAll", query = "SELECT o FROM Okul o")
    , @NamedQuery(name = "Okul.findByOkulid", query = "SELECT o FROM Okul o WHERE o.okulid = :okulid")
    , @NamedQuery(name = "Okul.findByOkuladi", query = "SELECT o FROM Okul o WHERE o.okuladi = :okuladi")})
public class Okul implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "okulid")
    private Integer okulid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "okuladi")
    private String okuladi;

    public Okul() {
    }

    public Okul(Integer okulid) {
        this.okulid = okulid;
    }

    public Okul(Integer okulid, String okuladi) {
        this.okulid = okulid;
        this.okuladi = okuladi;
    }

    public Integer getOkulid() {
        return okulid;
    }

    public void setOkulid(Integer okulid) {
        this.okulid = okulid;
    }

    public String getOkuladi() {
        return okuladi;
    }

    public void setOkuladi(String okuladi) {
        this.okuladi = okuladi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (okulid != null ? okulid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Okul)) {
            return false;
        }
        Okul other = (Okul) object;
        if ((this.okulid == null && other.okulid != null) || (this.okulid != null && !this.okulid.equals(other.okulid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erhan.model.Okul[ okulid=" + okulid + " ]";
    }
    
}
