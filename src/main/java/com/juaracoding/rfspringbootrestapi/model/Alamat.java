package com.juaracoding.rfspringbootrestapi.model;

public class Alamat {
    private String jalan;
    private Integer nomor;
    private String kota;
    private Integer kodePos;

    public String getJalan() {
        return jalan;
    }

    public void setJalan(String jalan) {
        this.jalan = jalan;
    }

    public Integer getNomor() {
        return nomor;
    }

    public void setNomor(Integer nomor) {
        this.nomor = nomor;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public Integer getKodePos() {
        return kodePos;
    }

    public void setKodePos(Integer kodePos) {
        this.kodePos = kodePos;
    }
}
