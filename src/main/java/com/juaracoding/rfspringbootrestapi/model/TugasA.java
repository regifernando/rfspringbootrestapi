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
    @Column(name = "Nama")
    private String nama;
    @Column(name = "Alamat")
    private String alamat;
    @Column(name = "TanggalLahir")
    private Date tanggalLahir;
    @Column(name = "MasihHidup")
    private Boolean masihHidup;
    @Column(name = "CreatedDate")
    private LocalDateTime createdDate;
    @Column(name = "CreatedBy")
    private Integer createdBy;
    @Column(name = "ModifiedDate")
    private LocalDateTime modifiedDate;
    @Column(name = "ModifiedBy")
    private Integer modifiedBy;
    private Boolean isDelete;
}
