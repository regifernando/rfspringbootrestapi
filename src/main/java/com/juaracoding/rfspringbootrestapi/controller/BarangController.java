package com.juaracoding.rfspringbootrestapi.controller;


import com.juaracoding.rfspringbootrestapi.model.Barang;
import com.juaracoding.rfspringbootrestapi.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/barang")
public class BarangController {

    private BarangService barangService;

    @Autowired
    public BarangController(BarangService barangService) {
        this.barangService = barangService;
    }

    /*
        {

        "namaBarang" : "Handphone",
        "kategoriBarang" : {
            "id" : 1
        }
}
     */
    @PostMapping("/v1/sv")
    public Object save(@RequestBody Barang barang){

        return barangService.save(barang);
    }

    /*
        [

                {

                    "namaBarang" : "Televisi",
                    "kategoriBarang" : {
                        "id" : 1
                    }
                },
                {

                    "namaBarang" : "Pisau Dapur",
                    "kategoriBarang" : {
                        "id" : 2
                    }
                },
                {

                    "namaBarang" : "Piring Kaca",
                    "kategoriBarang" : {
                        "id" : 2
                    }
                },
                {

                    "namaBarang" : "Meja",
                    "kategoriBarang" : {
                        "id" : 3
                    }
                },
                {

                    "namaBarang" : "Kursi",
                    "kategoriBarang" : {
                        "id" : 3
                    }
                }

            ]
     */
    @PostMapping("/v1/svb")
    public Object saveBatch(@RequestBody List<Barang> listBarang){

        return barangService.saveBat(listBarang);
    }
}
