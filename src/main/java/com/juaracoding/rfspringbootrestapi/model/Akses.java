package com.juaracoding.rfspringbootrestapi.model;


import com.juaracoding.rfspringbootrestapi.constant.ConstantConfig;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/*
    Modul Code = 04
 */
@Entity
@Table(name = "MstAkses")
public class Akses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDAkses")
    private Long idAkses;
    @Column(name = "NamaAkses",nullable = false)
    private String namaAkses;

    @ManyToMany
    @JoinTable(name = "MapAksesMenu",
            joinColumns = {@JoinColumn(name = "IDAkses",referencedColumnName = "IDAkses",foreignKey=@ForeignKey(name = "FKMapAkses"))},
            inverseJoinColumns =  {@JoinColumn(name = "IDMenu")},
            uniqueConstraints = @UniqueConstraint(columnNames = {"IDAkses","IDMenu"})
    )
    private List<Menu> listMenu;
    @ManyToOne
    @JoinColumn(name = "IDDivisi",foreignKey = @ForeignKey(name = "FKAksesDivisi"))
    private Divisi divisi;

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


    public Divisi getDivisi() {
        return divisi;
    }

    public void setDivisi(Divisi divisi) {
        this.divisi = divisi;
    }

    public Long getIdAkses() {
        return idAkses;
    }

    public void setIdAkses(Long idAkses) {
        this.idAkses = idAkses;
    }

    public String getNamaAkses() {
        return namaAkses;
    }

    public void setNamaAkses(String namaAkses) {
        this.namaAkses = namaAkses;
    }

    public List<Menu> getListMenu() {
        return listMenu;
    }

    public void setListMenu(List<Menu> listMenu) {
        this.listMenu = listMenu;
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
