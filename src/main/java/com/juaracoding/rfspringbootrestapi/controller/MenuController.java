package com.juaracoding.rfspringbootrestapi.controller;


import com.juaracoding.rfspringbootrestapi.dto.menu.MenuDTO;
import com.juaracoding.rfspringbootrestapi.model.Menu;
import com.juaracoding.rfspringbootrestapi.service.MenuService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/menu")
public class MenuController {

    private MenuService menuService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

   /*
         {
            "namaMenu" : "IT ONE",
                "menuGroup" : {
                 "idMenuGroup" : 1
            }
        }
    */

    @PostMapping("/v1/sv")
    public Object save(@Valid @RequestBody MenuDTO menuDTO){

        Menu menu = modelMapper.map(menuDTO, new TypeToken<Menu>(){}.getType());
        return menuService.save(menu);
    }

    @GetMapping("/v1/all")
    public Object findAll(){
        return menuService.findAll();
    }

    @GetMapping("/v1/fbp")
    public Object findByPage(
            @RequestParam(value = "page") Integer pagez,// halaman ke ?
            @RequestParam(value = "sort") String sortz,// asc / desc
            @RequestParam(value = "sortby") String sortzBy, // sorting berdasarkan field apa ?
            @RequestParam(value = "itemPerPage") String itemPerPage// data per halaman
    ){
        sortzBy = sortzBy==null?"idMenu":sortzBy;
        Pageable pageable = PageRequest.
                of(pagez,//HALAMAN KE BERAPA
                        Integer.parseInt(itemPerPage.equals("")?"5":itemPerPage),// BERAPA DATA PER HALAMAN
                        sortz.equals("asc")? Sort.by(sortzBy):Sort.by(sortzBy).descending()// SORTING ASC / DESC
                );
        return menuService.findByPage(pageable);
    }

//    private void mapSorting()
//    {
//        mapSorting.put("id","ID MENU");
//        mapSorting.put("nama","NAMA MENU");
//        mapSorting.put("kode","KODE MENU");
//    }
}
