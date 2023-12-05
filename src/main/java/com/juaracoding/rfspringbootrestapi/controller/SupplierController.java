package com.juaracoding.rfspringbootrestapi.controller;


import com.juaracoding.rfspringbootrestapi.model.Supplier;
import com.juaracoding.rfspringbootrestapi.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    private SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    /*
        {

            "namaSupplier" : "PT Garuda Matang",
            "listBarang" : [
                {
                    "id":1
                },
                {
                    "id":2
                },
                {
                    "id":3
                }
            ]
        }
     */
    @PostMapping("/v1/sv")
    public Object save(@RequestBody Supplier supplier){

        return supplierService.save(supplier);
    }
    @PostMapping("/v1/svb")
    public Object saveBatch(@RequestBody List<Supplier> listSupplier){

        return supplierService.saveBat(listSupplier);
    }

    @GetMapping("/v1/all")
    public Object findAll()
    {
        return supplierService.findAll();
    }
}
