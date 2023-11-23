package com.juaracoding.rfspringbootrestapi.controller;

import com.juaracoding.rfspringbootrestapi.model.FormatData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/formdata")
public class FormDataController {
    @PostMapping("/v1/convertjson")
    public Object getDataJSON(@RequestBody FormatData formatData){
        return formatData;
    }
}
