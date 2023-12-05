package com.juaracoding.rfspringbootrestapi.controller;

import com.juaracoding.rfspringbootrestapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping
    private User hasUser(User user){
        return user;
    }
}
