package com.juaracoding.rfspringbootrestapi.controller;

import com.juaracoding.rfspringbootrestapi.model.CalonPeserta;
import javax.validation.constraints.Max;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/seleksi2")
    public String seleksiCalonPeserta2(@RequestParam(value = "nama") String nama,
                                       @RequestParam(value = "umur") @Max(127) Integer umur,
                                       @RequestParam(value = "nilai") Integer nilai) {
        if (nilai > 80 && umur >= 18 && umur <= 60) {
            return nama + " lolos seleksi";
        } else {
            return nama + " tidak lolos seleksi";
        }
    }

}
