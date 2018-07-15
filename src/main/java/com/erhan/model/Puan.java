/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erhan.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
public class Puan implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer okulid;
    private String okuladi;
    private Integer DERSID;
    private String DERSADI;
    private Integer OKULSINAVID;
    private Integer SINAVID;
    private Integer SINAVPUANID;
    private BigDecimal PUAN;
    private String SINAVADI;
    
    private Map<String,BigDecimal> data;
    

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

    public Integer getDERSID() {
        return DERSID;
    }

    public void setDERSID(Integer DERSID) {
        this.DERSID = DERSID;
    }

    public String getDERSADI() {
        return DERSADI;
    }

    public void setDERSADI(String DERSADI) {
        this.DERSADI = DERSADI;
    }

    public Integer getOKULSINAVID() {
        return OKULSINAVID;
    }

    public void setOKULSINAVID(Integer OKULSINAVID) {
        this.OKULSINAVID = OKULSINAVID;
    }

    public Integer getSINAVID() {
        return SINAVID;
    }

    public void setSINAVID(Integer SINAVID) {
        this.SINAVID = SINAVID;
    }

    public Integer getSINAVPUANID() {
        return SINAVPUANID;
    }

    public void setSINAVPUANID(Integer SINAVPUANID) {
        this.SINAVPUANID = SINAVPUANID;
    }

    public BigDecimal getPUAN() {
        return PUAN;
    }

    public void setPUAN(BigDecimal PUAN) {
        this.PUAN = PUAN;
    }

    public String getSINAVADI() {
        return SINAVADI;
    }

    public void setSINAVADI(String SINAVADI) {
        this.SINAVADI = SINAVADI;
    }

    public BigDecimal getData(String sinavAdi) {
        return data.get(sinavAdi);
    }

    public void setData(Map<String, BigDecimal> data) {
        this.data = data;
    }

}
