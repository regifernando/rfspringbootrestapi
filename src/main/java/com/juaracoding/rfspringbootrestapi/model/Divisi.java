package com.juaracoding.rfspringbootrestapi.model;

import com.juaracoding.rfspringbootrestapi.constant.ConstantConfig;

import javax.persistence.*;
import java.util.Date;

/*
    Modul Code = 01
 */
@Entity
@Table(name = "MstDivisi")
public class Divisi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDDivisi")
    private Long idDivisi;

    @Column(name = "NamaDivisi",nullable = false)
    private String namaDivisi;

    /*start audit trails*/
    @Column(name = "CreatedBy",updatable = false,nullable = false)
    private Long createdBy = 1L;
    @Column(name = "CreatedAt",updatable = false,nullable = false, columnDefinition = ConstantConfig.GENERATE_TIME_STAMP)// INI UNTUK KASIH DEFAULT WAKTU KE SERVER DATABASE
    private Date createdAt = new Date();
    @Column(name = "ModifiedBy",insertable = false)
    private Long modifiedBy;
    @Column(name = "ModifiedAt",insertable = false)
    private Date modifiedAt;
    @Column(name = "IsActive")
    private Boolean isActive ;
    /*end audit trails*/

    public Long getIdDivisi() {
        return idDivisi;
    }

    public void setIdDivisi(Long idDivisi) {
        this.idDivisi = idDivisi;
    }

    public String getNamaDivisi() {
        return namaDivisi;
    }

    public void setNamaDivisi(String namaDivisi) {
        this.namaDivisi = namaDivisi;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}

