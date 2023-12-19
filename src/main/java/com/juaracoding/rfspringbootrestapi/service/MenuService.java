package com.juaracoding.rfspringbootrestapi.service;

import com.juaracoding.rfspringbootrestapi.dto.menu.MenuDTO;
import com.juaracoding.rfspringbootrestapi.model.Menu;
import com.juaracoding.rfspringbootrestapi.repo.MenuRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MenuService {


    private MenuRepo menuRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public MenuService(MenuRepo menuRepo) {
        this.menuRepo = menuRepo;
    }

    public Object save(Menu menu){
        try{
            menuRepo.save(menu);
        }catch (Exception e)
        {
            return "Gagal disimpan "+e.getMessage();
        }

        return "Berhasil Disimpan";
    }

    public Object findAll() {

        List<Menu> listMenu;
        try {
            listMenu = menuRepo.findAll();
            if(listMenu.isEmpty())
            {
                return "Data tidak ada";
            }
        } catch (Exception e) {
            return "Gagal  " + e.getMessage();
        }

        List<MenuDTO> listMenuDTO = modelMapper.map(listMenu, new TypeToken<List<MenuDTO>>(){}.getType());
        return listMenuDTO;
    }

    public Object findByPage(Pageable pageable){
        Page<Menu> pageMenu = null;
        List<Menu> listMenu = null;
        List<MenuDTO> listMenuDTO = null;
        Map<String,Object> mapResult = null;

        try{
            pageMenu = menuRepo.findAll(pageable);
            listMenu = pageMenu.getContent();
            if(listMenu.isEmpty())
            {
                return "Data Tidak Ada";
            }
        }catch (Exception e)
        {
            return "Error : "+e.getMessage();
        }

//        listMenuDTO = modelMapper.map(listMenu,new TypeToken<List<MenuDTO>>(){}.getType());
        return pageMenu;
    }
}
