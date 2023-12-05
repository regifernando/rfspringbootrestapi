package com.juaracoding.rfspringbootrestapi.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MstKategoriBarang")
public class KategoriBarang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDKategoriBarang")
    private Long id;
    private String namaKategoriBarang;
    private String deskripsi;

    @OneToMany(mappedBy = "kategoriBarang")
    private List<Barang> listBarang;

    public List<Barang> getListBarang() {
        return listBarang;
    }

    public void setListBarang(List<Barang> listBarang) {
        this.listBarang = listBarang;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaKategoriBarang() {
        return namaKategoriBarang;
    }

    public void setNamaKategoriBarang(String namaKategoriBarang) {
        this.namaKategoriBarang = namaKategoriBarang;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}

