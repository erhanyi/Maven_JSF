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
@Table(name = "sinavpuan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sinavpuan.findAll", query = "SELECT s FROM Sinavpuan s")
    , @NamedQuery(name = "Sinavpuan.findBySinavpuanid", query = "SELECT s FROM Sinavpuan s WHERE s.sinavpuanid = :sinavpuanid")
    , @NamedQuery(name = "Sinavpuan.findByDers", query = "SELECT s FROM Sinavpuan s WHERE s.ders = :ders")
    , @NamedQuery(name = "Sinavpuan.findByOkulsinavid", query = "SELECT s FROM Sinavpuan s WHERE s.okulsinavid = :okulsinavid")
    , @NamedQuery(name = "Sinavpuan.findByPuan", query = "SELECT s FROM Sinavpuan s WHERE s.puan = :puan")})
public class Sinavpuan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SINAVPUANID")
    private Integer sinavpuanid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DERS")
    private String ders;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OKULSINAVID")
    private int okulsinavid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PUAN")
    private int puan;

    public Sinavpuan() {
    }

    public Sinavpuan(Integer sinavpuanid) {
        this.sinavpuanid = sinavpuanid;
    }

    public Sinavpuan(Integer sinavpuanid, String ders, int okulsinavid, int puan) {
        this.sinavpuanid = sinavpuanid;
        this.ders = ders;
        this.okulsinavid = okulsinavid;
        this.puan = puan;
    }

    public Integer getSinavpuanid() {
        return sinavpuanid;
    }

    public void setSinavpuanid(Integer sinavpuanid) {
        this.sinavpuanid = sinavpuanid;
    }

    public String getDers() {
        return ders;
    }

    public void setDers(String ders) {
        this.ders = ders;
    }

    public int getOkulsinavid() {
        return okulsinavid;
    }

    public void setOkulsinavid(int okulsinavid) {
        this.okulsinavid = okulsinavid;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sinavpuanid != null ? sinavpuanid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sinavpuan)) {
            return false;
        }
        Sinavpuan other = (Sinavpuan) object;
        if ((this.sinavpuanid == null && other.sinavpuanid != null) || (this.sinavpuanid != null && !this.sinavpuanid.equals(other.sinavpuanid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erhan.model.Sinavpuan[ sinavpuanid=" + sinavpuanid + " ]";
    }
    
}
