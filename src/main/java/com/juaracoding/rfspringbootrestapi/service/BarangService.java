package com.juaracoding.rfspringbootrestapi.service;

import com.juaracoding.rfspringbootrestapi.model.Barang;
import com.juaracoding.rfspringbootrestapi.repo.BarangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class BarangService {

    private BarangRepo barangRepo;

    @Autowired
    public BarangService(BarangRepo barangRepo) {
        this.barangRepo = barangRepo;
    }

    public Object save(Barang barang){
        try{
            barangRepo.save(barang);
        }catch (Exception e)
        {
            return "Gagal disimpan "+e.getMessage();
        }

        return "Berhasil Disimpan";

    }

    public Object saveBat(List<Barang> listBarang){
        try{
            barangRepo.saveAll(listBarang);
        }catch (Exception e)
        {
            return "Gagal disimpan "+e.getMessage();
        }

        return "Berhasil Disimpan";

    }
}