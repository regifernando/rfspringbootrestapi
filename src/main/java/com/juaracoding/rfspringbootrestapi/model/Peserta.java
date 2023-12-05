package com.juaracoding.rfspringbootrestapi.model;



import com.juaracoding.rfspringbootrestapi.constant.ConstantClassPeserta;

import javax.persistence.*;

@Entity
@Table(name = "MstPeserta")
public class Peserta {
    //repo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "Nama",columnDefinition = ConstantClassPeserta.COL_DEF_NAMA)
    private String nama;
    @Column(name = "Batch")
    private String batch;
    @Column(name = "Alamat")
    private String alamat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

}