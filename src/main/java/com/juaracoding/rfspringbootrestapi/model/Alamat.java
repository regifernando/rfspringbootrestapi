package com.juaracoding.rfspringbootrestapi.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Alamat")
public class Alamat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    /*
        DIAWALI HURUF BESAR / KAPITAL
        SISANYA HURUF KECIL DAN NOMOR SAJA (KOMBINASI)
        MINIMAL 8 KARAKTER MAKSIMAL 16
     */

    @NotNull
    @NotEmpty
    @NotBlank
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Length(min = 10 , max = 20)
    @Pattern(regexp = "^[a-zA-Z0-9]{10,20}$",message = "MINIMAL 10 MAKSIMAL 20 KARAKTER")
    @Column(unique = false,name = "",insertable = false ,updatable = true)
//    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&(){}:;<>,.?/~_+-=|]).{8,16}$",message = "Jalan tidak Valid")
//    @Pattern(regexp = "^$",message = "Jalan tidak Valid")
    private String jalan;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate contohTanggal;//yyyy-MM-dd

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date contohTanggalWaktu;//yyyy-MM-dd HH:mm:ss.SSS
    private Integer nomor;
    private String kota;
    private Integer kodePos;

    private Long createdBy;
    private Date createdAt;
    private Long modifiedBy;
    private Date modifiedAt;
    private Byte isActive;

    public String getJalan() {
        return jalan;
    }

    public void setJalan(String jalan) {
        this.jalan = jalan;
    }

    public Integer getNomor() {
        return nomor;
    }

    public void setNomor(Integer nomor) {
        this.nomor = nomor;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public Integer getKodePos() {
        return kodePos;
    }

    public void setKodePos(Integer kodePos) {
        this.kodePos = kodePos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getContohTanggal() {
        return contohTanggal;
    }

    public void setContohTanggal(LocalDate contohTanggal) {
        this.contohTanggal = contohTanggal;
    }

    public Date getContohTanggalWaktu() {
        return contohTanggalWaktu;
    }

    public void setContohTanggalWaktu(Date contohTanggalWaktu) {
        this.contohTanggalWaktu = contohTanggalWaktu;
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

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }
}
