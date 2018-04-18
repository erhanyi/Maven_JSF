package com.erhan.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table (name = "kullanici")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kullanici.findAll", query = "SELECT k FROM Kullanici k")
    , @NamedQuery(name = "Kullanici.findByTckimlikno", query = "SELECT k FROM Kullanici k WHERE k.tckimlikno = :tckimlikno")
    , @NamedQuery(name = "Kullanici.findByAdi", query = "SELECT k FROM Kullanici k WHERE k.adi = :adi")
    , @NamedQuery(name = "Kullanici.findBySoyadi", query = "SELECT k FROM Kullanici k WHERE k.soyadi = :soyadi")
    , @NamedQuery(name = "Kullanici.findBySifre", query = "SELECT k FROM Kullanici k WHERE k.sifre = :sifre")})
public class Kullanici implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(nullable = false, length = 11)
    private String tckimlikno;
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

    public Kullanici() {
    }

    public Kullanici(String tckimlikno) {
        this.tckimlikno = tckimlikno;
    }

    public Kullanici(String tckimlikno, String adi, String soyadi, String sifre) {
        this.tckimlikno = tckimlikno;
        this.adi = adi;
        this.soyadi = soyadi;
        this.sifre = sifre;
    }

    public String getTckimlikno() {
        return tckimlikno;
    }

    public void setTckimlikno(String tckimlikno) {
        this.tckimlikno = tckimlikno;
    }

    public String getAdi() {
        return adi;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tckimlikno != null ? tckimlikno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Kullanici)) {
            return false;
        }
        Kullanici other = (Kullanici) object;
        return !((this.tckimlikno == null && other.tckimlikno != null) || (this.tckimlikno != null && !this.tckimlikno.equals(other.tckimlikno)));
    }

    @Override
    public String toString() {
        return "com.erhan.model.Kullanici[ tckimlikno=" + tckimlikno + " ]";
    }
    
}
