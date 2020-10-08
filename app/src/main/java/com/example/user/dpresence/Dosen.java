package com.example.user.dpresence;

public class Dosen {
    private String nip;
    private String nama;
    private String email;
    public String password;
    private String prodi;
    private String jk;
    private String alamat;
    private String telp;

    public Dosen() {
    }

    public Dosen(String nip, String nama, String email, String password, String prodi, String jk, String alamat, String telp) {
        this.nip = nip;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.prodi = prodi;
        this.jk = jk;
        this.alamat = alamat;
        this.telp = telp;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }
}