package com.juaracoding.rfspringbootrestapi.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public class User{
    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]{6,12}$",
            message = "username must be of 6 to 12 length with no special characters")
    private String username;
    @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){4,12}$",
            message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
    private String password;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate contohTgl; // yyyy-MM-dd

    @DateTimeFormat(pattern = "yyyy-MM-dd  HH:mm:ss.SSS")
    private Date contohtglWaktu; // yyyy-MM-dd  HH:mm:ss.SSS

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
