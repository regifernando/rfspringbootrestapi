package com.juaracoding.rfspringbootrestapi.dto;
import com.juaracoding.rfspringbootrestapi.constant.ConstantRegex;
import com.juaracoding.rfspringbootrestapi.constant.ConstantUser;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

/*
    Referensi ke Model User
 */
public class RegistrasiDTO {

    private String namaLengkap;

    /* huruf kecil / nomor kombinasi
     minimal 8 maksimal 16 karakter
     paulc256bit
     */
    @NotNull(message = ConstantUser.ERROR_USERNAME_IS_NULL)
    @NotBlank(message = ConstantUser.ERROR_USERNAME_IS_BLANK)
    @NotEmpty(message = ConstantUser.ERROR_USERNAME_IS_EMPTY)
    @Pattern(regexp = "^[a-z0-9]{8,16}$")
    private String username;

    @NotNull(message = ConstantUser.ERROR_EMAIL_IS_NULL)
    @NotBlank(message = ConstantUser.ERROR_EMAIL_IS_BLANK)
    @NotEmpty(message = ConstantUser.ERROR_EMAIL_IS_EMPTY)
    @Pattern(regexp = ConstantRegex.REGEX_EMAIL_STANDARD_RFC5322,message = ConstantRegex.ERROR_EMAIL_STANDARD_RFC5322)
    private String email;
    private String noHp;
    private LocalDate tanggalLahir;
    private String password;

    private String alamat;

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}

