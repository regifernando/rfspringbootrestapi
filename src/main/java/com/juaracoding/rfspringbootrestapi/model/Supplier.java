package com.juaracoding.rfspringbootrestapi.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MstSupplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDSupplier")
    private Long id;

    @Column(name = "NamaSupplier")
    private String namaSupplier;

    /*

    @ManyToMany
    @JoinTable(name = "MapSupplierBarang",
    joinColumns = {@JoinColumn(name = "IDSupplier",referencedColumnName = "IDSupplier",foreignKey=@ForeignKey(name = "FKSupplierBarang"))},
    inverseJoinColumns =  {@JoinColumn(name = "IDBarang",referencedColumnName = "IDBarang")},
    uniqueConstraints = @UniqueConstraint(columnNames = {"IDSupplier","IDBarang"})
    )
    *
    * */
    @ManyToMany
    @JoinTable(name = "MapSupplierBarang",
            joinColumns = {@JoinColumn(name = "IDSupplier",referencedColumnName = "IDSupplier")},
            inverseJoinColumns =  {@JoinColumn(name = "IDBarang",referencedColumnName = "IDBarang")},
            uniqueConstraints = @UniqueConstraint(columnNames = {"IDSupplier","IDBarang"})
    )
    private List<Barang> listBarang;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaSupplier() {
        return namaSupplier;
    }

    public void setNamaSupplier(String namaSupplier) {
        this.namaSupplier = namaSupplier;
    }

    public List<Barang> getListBarang() {
        return listBarang;
    }

    public void setListBarang(List<Barang> listBarang) {
        this.listBarang = listBarang;
    }
}