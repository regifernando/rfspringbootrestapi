package com.juaracoding.rfspringbootrestapi.service;


import com.juaracoding.rfspringbootrestapi.model.Peserta;
import com.juaracoding.rfspringbootrestapi.repo.PesertaRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class PesertaService {


    /*
        CREATE
        READ
        UPDATE
        DELETE
     */

    PesertaRepo pesertaRepo;
    //@Autowired
    //ModelMapper modelMapper;

    @Autowired
    public PesertaService(PesertaRepo pesertaRepo) {
        this.pesertaRepo = pesertaRepo;
    }

    public Object updateData(Long id, Peserta peserta){//object kiriman dari FE

        Optional<Peserta> op = pesertaRepo.findById(id);// object dari database
        if(op.isEmpty())
        {
            return "USER TIDAK ADA !!!";
        }

        Peserta pesertaNext = op.get();
        pesertaNext.setAlamat(peserta.getAlamat());
        pesertaNext.setNama(peserta.getNama());
        //pesertaNext.setTanggalLahir(peserta.getTanggalLahir());

        return "Update Berhasil";
    }
}