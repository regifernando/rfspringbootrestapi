package com.juaracoding.rfspringbootrestapi.dto.menu;


import com.juaracoding.rfspringbootrestapi.dto.menugroup.MenuGroup2DTO;

public class Menu2DTO {

    private String namaMenu;

    private MenuGroup2DTO menuGroup;

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public MenuGroup2DTO getMenuGroup() {
        return menuGroup;
    }

    public void setMenuGroup(MenuGroup2DTO menuGroup) {
        this.menuGroup = menuGroup;
    }
}
