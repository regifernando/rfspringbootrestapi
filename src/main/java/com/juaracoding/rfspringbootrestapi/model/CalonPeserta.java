package com.juaracoding.rfspringbootrestapi.model;

import javax.persistence.*;

@Entity
@Table(name = "MstCalonPeserta")
public class CalonPeserta {

    //CRUD
    //C =  CREATE
    //R = READ
    //U = UPDATE
    //D = DELETE

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama;
    private Integer umur;
    private Double nilai;
    public String getNama() {
        return nama;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }

    public Double getNilai() {
        return nilai;
    }

    public void setNilai(Double nilai) {
        this.nilai = nilai;
    }
}
