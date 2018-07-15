package com.erhan.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author erhan
 */
public class DersPuan implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer sinavid;
    private String sinavadi;
    private Integer okulsinavid;
    private Integer sinavpuanid;
    private BigDecimal puan;

    public Integer getOkulsinavid() {
        return okulsinavid;
    }

    public void setOkulsinavid(Integer okulsinavid) {
        this.okulsinavid = okulsinavid;
    }

    public Integer getSinavid() {
        return sinavid;
    }

    public void setSinavid(Integer sinavid) {
        this.sinavid = sinavid;
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

    public String getSinavadi() {
        return sinavadi;
    }

    public void setSinavadi(String sinavadi) {
        this.sinavadi = sinavadi;
    }
}
