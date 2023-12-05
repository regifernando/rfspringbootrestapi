package com.juaracoding.rfspringbootrestapi.service;


import com.juaracoding.rfspringbootrestapi.model.KategoriBarang;
import com.juaracoding.rfspringbootrestapi.repo.KategoriBarangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class KategoriBarangService {

    KategoriBarangRepo kategoriBarangRepo;


    @Autowired
    public KategoriBarangService(KategoriBarangRepo kategoriBarangRepo) {
        this.kategoriBarangRepo = kategoriBarangRepo;
    }

    public Object save(KategoriBarang kategoriBarang){
        try{
            kategoriBarangRepo.save(kategoriBarang);
        }catch (Exception e)
        {
            return "Gagal disimpan "+e.getMessage();
        }

        return "Berhasil Disimpan";

    }
    public Object saveBat(List<KategoriBarang> listKategoriBarang){
        try{
            kategoriBarangRepo.saveAll(listKategoriBarang);
        }catch (Exception e)
        {
            return "Gagal disimpan "+e.getMessage();
        }

        return "Berhasil Disimpan";

    }


}
