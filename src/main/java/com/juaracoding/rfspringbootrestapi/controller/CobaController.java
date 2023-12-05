package com.juaracoding.rfspringbootrestapi.controller;

import com.juaracoding.rfspringbootrestapi.FileUtility;
import com.juaracoding.rfspringbootrestapi.model.CobaCoba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/main")
public class CobaController {

    @Autowired
    CobaCoba cobaCoba;

    @GetMapping("/v1/coba")
    public String coba(){
        return cobaCoba.helloWorld();
    }

    @GetMapping("/v1/welcome")
    public String welcome(){

        System.out.println("Masuk Kesini");
        return "Hello World!!";
    }

    @GetMapping("/v1/save")
    public String save(){

        System.out.println("Save Disini");
        return "Sudah TerSimpan";
    }

    @GetMapping("/v1/update")
    public String update(){

        System.out.println("Update Disini");
        return "Sudah Terubah";
    }

    @GetMapping("/v1/delete")
    public String delete(){

        System.out.println("Update Disini");
        return "Sudah Terubah";
    }

    @GetMapping("/v1/find")
    public String findBy(){

        System.out.println("Update Disini");
        return "Sudah Terubah";
    }

    @GetMapping("/v1/contohdata")
    public Map<String,Object> contohData(){

        Map<String,Object> map = new HashMap<>();
        map.put("nama","Paul");
        map.put("alamat","Bogor");

        return map;
    }

    @PostMapping("/kirim-file")
    public String submitFile(@RequestParam(value = "kiriman") MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String uploadDir = "user-files/";
        FileUtility.saveFile(uploadDir, fileName, file);
        return "Berhasil mengunggah file " + fileName;
    }

}
