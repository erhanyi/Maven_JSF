/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhan.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Where;

/**
 *
 * @author erhan
 */
@Entity
@Table(catalog = "proje", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kullanici.findAll", query = "SELECT k FROM Kullanici k")
    , @NamedQuery(name = "Kullanici.findByKullaniciid", query = "SELECT k FROM Kullanici k WHERE k.kullaniciid = :kullaniciid")
    , @NamedQuery(name = "Kullanici.findByAdi", query = "SELECT k FROM Kullanici k WHERE k.adi = :adi")
    , @NamedQuery(name = "Kullanici.findBySoyadi", query = "SELECT k FROM Kullanici k WHERE k.soyadi = :soyadi")
    , @NamedQuery(name = "Kullanici.findBySifre", query = "SELECT k FROM Kullanici k WHERE k.sifre = :sifre")
    , @NamedQuery(name = "Kullanici.findByEmail", query = "SELECT k FROM Kullanici k WHERE k.email = :email")})
public class Kullanici implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer kullaniciid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String adi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String soyadi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(nullable = false, length = 10)
    private String sifre;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String email;
    
    @OneToMany(mappedBy = "kullanici", fetch = FetchType.LAZY)
    private List<Araba> arabaListesi = new ArrayList<>( );    

    public Kullanici() {
    }

    public Kullanici(Integer kullaniciid) {
        this.kullaniciid = kullaniciid;
    }

    public Kullanici(Integer kullaniciid, String adi, String soyadi, String sifre, String email) {
        this.kullaniciid = kullaniciid;
        this.adi = adi;
        this.soyadi = soyadi;
        this.sifre = sifre;
        this.email = email;
    }

    public Integer getKullaniciid() {
        return kullaniciid;
    }

    public void setKullaniciid(Integer kullaniciid) {
        this.kullaniciid = kullaniciid;
    }

    public String getAdi() {
        return adi;
    }

    public List<Araba> getArabaListesi() {
        return arabaListesi;
    }

    public void setArabaListesi(List<Araba> arabaListesi) {
        this.arabaListesi = arabaListesi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kullaniciid != null ? kullaniciid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kullanici)) {
            return false;
        }
        Kullanici other = (Kullanici) object;
        if ((this.kullaniciid == null && other.kullaniciid != null) || (this.kullaniciid != null && !this.kullaniciid.equals(other.kullaniciid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.erhan.model.Kullanici[ kullaniciid=" + kullaniciid + " ]";
    }
    
}
