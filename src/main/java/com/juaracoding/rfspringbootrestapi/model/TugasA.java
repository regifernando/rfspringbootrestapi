package com.juaracoding.rfspringbootrestapi.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "MstTugasA")
public class TugasA {

    @Id
    @NotNull
    private String IDTugasA;
    @Column(name = "Nama", length = 40)
    @NotNull
    private String nama;
    @Column(name = "Alamat", length = 500)
    @NotNull
    private String alamat;
    @Column(name = "TanggalLahir")
    @NotNull
    private Date tanggalLahir;
    @Column(name = "JenisKelamin")
    @NotNull
    private Character jenisKelamin;
    @Column(name = "MasihHidup")
    @NotNull
    private Boolean masihHidup;
    @Column(name = "CreatedDate")
    @NotNull
    private LocalDateTime createdDate;
    @Column(name = "CreatedBy")
    @NotNull
    private Integer createdBy;
    @Column(name = "ModifiedDate")
    private LocalDateTime modifiedDate;
    @Column(name = "ModifiedBy")
    private Integer modifiedBy;
    @Column(name = "IsDelete")
    @NotNull
    private Boolean isDelete;

    public String getIDTugasA() {
        return IDTugasA;
    }

    public void setIDTugasA(String IDTugasA) {
        this.IDTugasA = IDTugasA;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public Character getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(Character jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Boolean getMasihHidup() {
        return masihHidup;
    }

    public void setMasihHidup(Boolean masihHidup) {
        this.masihHidup = masihHidup;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
