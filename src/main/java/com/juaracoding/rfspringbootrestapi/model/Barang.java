package com.juaracoding.rfspringbootrestapi.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MstBarang")
public class Barang {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDBarang")
    private Long id;
    private String namaBarang;

    @ManyToOne
    @JoinColumn(name = "IDKategoriBarang", foreignKey = @ForeignKey(name = "fkBarangToKategori1"))
    private KategoriBarang kategoriBarang;

    @ManyToMany(mappedBy = "listBarang")
    private List<Supplier> listSupplier;

    public List<Supplier> getListSupplier() {
        return listSupplier;
    }

    public void setListSupplier(List<Supplier> listSupplier) {
        this.listSupplier = listSupplier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public KategoriBarang getKategoriBarang() {
        return kategoriBarang;
    }

    public void setKategoriBarang(KategoriBarang kategoriBarang) {
        this.kategoriBarang = kategoriBarang;
    }
}