package com.juaracoding.rfspringbootrestapi.dto.menugroup;


public class MenuGroupDTO {

    private Long idMenuGroup;

    private String namaMenuGroup;

    private String deskripsi;

    public Long getIdMenuGroup() {
        return idMenuGroup;
    }

    public void setIdMenuGroup(Long idMenuGroup) {
        this.idMenuGroup = idMenuGroup;
    }

    public String getNamaMenuGroup() {
        return namaMenuGroup;
    }

    public void setNamaMenuGroup(String namaMenuGroup) {
        this.namaMenuGroup = namaMenuGroup;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}

