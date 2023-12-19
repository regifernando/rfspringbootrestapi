package com.juaracoding.rfspringbootrestapi.dto.menu;


import com.juaracoding.rfspringbootrestapi.dto.menugroup.MenuGroupDTO;

public class MenuDTO {
    private Long idMenu;
    private String namaMenu;
    private MenuGroupDTO menuGroup;
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

    public MenuGroupDTO getMenuGroup() {
        return menuGroup;
    }

    public void setMenuGroup(MenuGroupDTO menuGroup) {
        this.menuGroup = menuGroup;
    }
}
