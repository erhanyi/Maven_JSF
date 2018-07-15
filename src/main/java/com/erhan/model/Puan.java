package com.erhan.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author erhan
 */
public class Puan implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer dersid;
    private String dersadi;
    private Integer sinavid;
    private String sinavadi;
    private Integer okulsinavid;
    private Integer sinavpuanid;
    private BigDecimal puan;

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

    public Integer getOkulsinavid() {
        return okulsinavid;
    }

    public void setOkulsinavid(Integer okulsinavid) {
        this.okulsinavid = okulsinavid;
    }

    public Integer getSinavpuanid() {
        return sinavpuanid;
    }

    public void setSinavpuanid(Integer sinavpuanid) {
        this.sinavpuanid = sinavpuanid;
    }

    public BigDecimal getPuan() {
        return puan;
    }

    public void setPuan(BigDecimal puan) {
        this.puan = puan;
    }
    
   

}
