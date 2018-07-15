/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhan.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author erhan
 */
@Entity
@Table(name = "okulders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Okulders.findAll", query = "SELECT o FROM Okulders o")
    , @NamedQuery(name = "Okulders.findByDersid", query = "SELECT o FROM Okulders o WHERE o.dersid = :dersid")
    , @NamedQuery(name = "Okulders.findByDersadi", query = "SELECT o FROM Okulders o WHERE o.dersadi = :dersadi")
    , @NamedQuery(name = "Okulders.findByOkul", query = "SELECT o FROM Okulders o WHERE o.okul = :okul")})
public class Okulders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DERSID")
    private Integer dersid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DERSADI")
    private String dersadi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "okul")
    private int okul;
    
    @Transient
    private List<DersPuan> dersSinavPuanListesi;
    
    @Transient
    private Map<String,BigDecimal> sinavPuanData;
    
    public BigDecimal getSinavPuanData(String sinavAdi) {
        return sinavPuanData.get(sinavAdi);
    }

    public Map<String, BigDecimal> getSinavPuanData() {
        return sinavPuanData;
    }

    public void setSinavPuanData(Map<String, BigDecimal> sinavPuanData) {
        this.sinavPuanData = sinavPuanData;
    }

    public List<DersPuan> getDersSinavPuanListesi() {
        return dersSinavPuanListesi;
    }

    public void setDersSinavPuanListesi(List<DersPuan> dersSinavPuanListesi) {
        this.dersSinavPuanListesi = dersSinavPuanListesi;
    }   

    public Okulders() {
    }

    public Okulders(Integer dersid) {
        this.dersid = dersid;
    }

    public Okulders(Integer dersid, String dersadi, int okul) {
        this.dersid = dersid;
        this.dersadi = dersadi;
        this.okul = okul;
    }

    public Integer getDersid() {
        return dersid;
    }

    public void setDersid(Integer dersid) {
        this.dersid = dersid;
    }

    public String getDersadi() {
        return dersadi;
    }

    public void setDersadi(String dersadi) {
        this.dersadi = dersadi;
    }

    public int getOkul() {
        return okul;
    }

    public void setOkul(int okul) {
        this.okul = okul;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dersid != null ? dersid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Okulders)) {
            return false;
        }
        Okulders other = (Okulders) object;
        if ((this.dersid == null && other.dersid != null) || (this.dersid != null && !this.dersid.equals(other.dersid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erhan.model.Okulders[ dersid=" + dersid + " ]";
    }
    
}
