package com.juaracoding.rfspringbootrestapi.controller;


import com.juaracoding.rfspringbootrestapi.dto.RegistrasiDTO;
import com.juaracoding.rfspringbootrestapi.model.MstUser;
import com.juaracoding.rfspringbootrestapi.service.MstUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/regis")
public class RegistrasiController {



    private MstUserService userService;

    @Autowired
    private ModelMapper modelMapper;

    /*
        {
            "username" : "paulpaul123",
                "email" : "paul123@gmail.com",
                "noHp" : "628331616416",
                "tanggalLahir" : null,
                "password" : "paulbanget",
                "alamat" : "Bogor Selatan"
        }
     */
    @Autowired
    public RegistrasiController(MstUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/v1/checkregis")
    public Object checkRegis(@Valid @RequestBody RegistrasiDTO registrasiDTO){
        MstUser usr = modelMapper.map(registrasiDTO, new TypeToken<MstUser>(){}.getType());

        return userService.save(usr);
    }
}

