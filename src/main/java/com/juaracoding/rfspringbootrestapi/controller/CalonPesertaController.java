package com.juaracoding.rfspringbootrestapi.controller;

import com.juaracoding.rfspringbootrestapi.model.CalonPeserta;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calonpeserta")
public class CalonPesertaController {
    @PostMapping("/seleksi")
    public String seleksiCalonPeserta(@RequestBody CalonPeserta calon) {
        if (calon.getNilai() > 80 && calon.getUmur() >= 18 && calon.getUmur() <= 60) {
            return calon.getNama() + " lolos seleksi";
        } else {
            return calon.getNama() + " tidak lolos seleksi";
        }
    }

}
