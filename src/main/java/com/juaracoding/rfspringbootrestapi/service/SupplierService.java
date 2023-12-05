package com.juaracoding.rfspringbootrestapi.service;


import com.juaracoding.rfspringbootrestapi.model.Supplier;
import com.juaracoding.rfspringbootrestapi.repo.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SupplierService {
    private SupplierRepo supplierRepo;


    @Autowired
    public SupplierService(SupplierRepo supplierRepo) {
        this.supplierRepo = supplierRepo;
    }

    public Object save(Supplier supplier){
        try{
            supplierRepo.save(supplier);
        }catch (Exception e)
        {
            return "Gagal disimpan "+e.getMessage();
        }

        return "Berhasil Disimpan";

    }

    public Object saveBat(List<Supplier> listSupplier){
        try{
            supplierRepo.saveAll(listSupplier);
        }catch (Exception e)
        {
            return "Gagal disimpan "+e.getMessage();
        }

        return "Berhasil Disimpan";

    }

    public Object findAll() {
        List<Supplier> listSupplier;
        try {
            listSupplier = supplierRepo.findAll();
        } catch (Exception e) {
            return "Gagal disimpan " + e.getMessage();
        }

        return listSupplier;

    }
}

