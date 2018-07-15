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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author erhan
 */
@Entity
@Table(catalog = "proje", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Araba.findAll", query = "SELECT a FROM Araba a")
    , @NamedQuery(name = "Araba.findByArabaid", query = "SELECT a FROM Araba a WHERE a.arabaid = :arabaid")
    , @NamedQuery(name = "Araba.findByArabamarka", query = "SELECT a FROM Araba a WHERE a.arabamarka = :arabamarka")
    , @NamedQuery(name = "Araba.findByArabamodel", query = "SELECT a FROM Araba a WHERE a.arabamodel = :arabamodel")
    , @NamedQuery(name = "Araba.findByKullanici", query = "SELECT a FROM Araba a WHERE a.kullanici = :kullanici")})
public class Araba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer arabaid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String arabamarka;
    @Size(max = 100)
    @Column(length = 100)
    private String arabamodel;
    
    @ManyToOne
    @JoinColumn(name = "kullaniciId")
    private Kullanici kullanici;

    public Araba() {
    }

    public Araba(Integer arabaid) {
        this.arabaid = arabaid;
    }

    public Araba(Integer arabaid, String arabamarka, Kullanici kullanici) {
        this.arabaid = arabaid;
        this.arabamarka = arabamarka;
        this.kullanici = kullanici;
    }

    public Integer getArabaid() {
        return arabaid;
    }

    public void setArabaid(Integer arabaid) {
        this.arabaid = arabaid;
    }

    public String getArabamarka() {
        return arabamarka;
    }

    public void setArabamarka(String arabamarka) {
        this.arabamarka = arabamarka;
    }

    public String getArabamodel() {
        return arabamodel;
    }

    public void setArabamodel(String arabamodel) {
        this.arabamodel = arabamodel;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (arabaid != null ? arabaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Araba)) {
            return false;
        }
        Araba other = (Araba) object;
        if ((this.arabaid == null && other.arabaid != null) || (this.arabaid != null && !this.arabaid.equals(other.arabaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erhan.model.Araba[ arabaid=" + arabaid + " ]";
    }
    
}
