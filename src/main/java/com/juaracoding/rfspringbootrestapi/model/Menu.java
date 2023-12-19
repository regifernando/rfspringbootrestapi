package com.juaracoding.rfspringbootrestapi.model;

import com.juaracoding.rfspringbootrestapi.constant.ConstantConfig;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/*
    Modul Code = 03
 */
@Entity
@Table(name = "MstMenu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDMenu")
    private Long idMenu;

    @Column(name = "NamaMenu")
    private String namaMenu;

    @ManyToOne
    @JoinColumn(name = "IDMenuGroup",foreignKey = @ForeignKey(name = "FKToMenuGroup"))
    private MenuGroup menuGroup;

    @ManyToMany(mappedBy = "listMenu")
    private List<Akses> listAkses;

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

    public MenuGroup getMenuGroup() {
        return menuGroup;
    }

    public void setMenuGroup(MenuGroup menuGroup) {
        this.menuGroup = menuGroup;
    }

    public List<Akses> getListAkses() {
        return listAkses;
    }

    public void setListAkses(List<Akses> listAkses) {
        this.listAkses = listAkses;
    }

    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
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

