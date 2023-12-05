package com.juaracoding.rfspringbootrestapi.controller;


import com.juaracoding.rfspringbootrestapi.model.Peserta;
import com.juaracoding.rfspringbootrestapi.repo.PesertaRepo;
import com.juaracoding.rfspringbootrestapi.service.PesertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/peserta")
public class PesertaController {

    PesertaService pesertaService;

    @Autowired
    public PesertaController(PesertaService pesertaService) {
        this.pesertaService = pesertaService;
    }

    @Autowired
    PesertaRepo pesertaRepo;
    //PesertaService pesertaRepo = new PesertaService();

    @GetMapping("/v1/getall")
    public List<Peserta> getAllData() {
        List<Peserta> daftarPeserta = pesertaRepo.findAll();
        return daftarPeserta;
    }

    @PostMapping("/v1/save")
    public String postData(@RequestBody Peserta peserta) {
        pesertaRepo.save(peserta);
        return peserta.getNama() + " berhasil ditambahkan";
    }

    @GetMapping("/v1/searchById")
    public Object searchPesertaById(@RequestParam(value = "id") Long id) {
        Optional<Peserta> hasil = pesertaRepo.findById(id);
//        Peserta p1= pesertaRepo.findById(id).orElse(
//                null
//        );
        //Derived Query / JPAQL -> 1 kondisi dimana kolomnya unik
        if(hasil.isEmpty())
        {
            return "Data Tidak Ada";
        }
        Peserta p = hasil.get();
        return p;
    }

    @GetMapping("/v1/searchByNama")
    public Object searchPesertaByNama(
            @RequestParam(value = "nama") String strNama,
            @RequestParam(value = "batch") String strBatch) {
        List<Peserta> hasil = pesertaRepo.findByNamaAndBatch(strNama,strBatch);
//        Peserta p1= pesertaRepo.findById(id).orElse(
//                null
//        );
        //Derived Query / JPAQL -> 1 kondisi dimana kolomnya unik
        if(hasil.isEmpty())
        {
            return "Data Tidak Ada";
        }
        System.out.println("COUNT = "+pesertaRepo.countByBatch(strBatch));
//        System.out.println("PROSES DELETE BERJALAN ");
//        pesertaRepo.deleteByNama(strNama);
//        System.out.println("PROSES DELETE BERAKHIR ");
        List<Peserta> listDistinct = pesertaRepo.findDistinctBatchByBatch(strBatch);

        return hasil;
    }

    @PostMapping("/v1/val")
    public String testValidasi(@Valid @RequestBody Peserta peserta) {

        try{

            int intX = 1/0;

        }catch (ArithmeticException e)
        {
            return "Gagal "+e.getMessage();
        }

        System.out.println("TAHAN DISINI");
        return peserta.getNama() + " berhasil ditambahkan";
    }

    @PutMapping("/v1/u/{id}")
    public String update(@Valid @RequestBody Peserta peserta,
                         @PathVariable(value = "id") Long id) {


        System.out.println("Masuk Sini !!");
        return (String) pesertaService.updateData(id,peserta);
    }
}