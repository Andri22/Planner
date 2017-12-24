package com.example.andri.planner.agenda;

/**
 * Created by andri on 20/12/17.
 */

public class AgendaKerja{

    private String judul;
    private String tanggal;
    private String jamMulai;
    private String jamSelesai;
    private String tempat;
    private String deskripsi;

    public AgendaKerja(String judul,String tempat, String jamMulai, String jamSelesai){
        this.judul=judul;
        this.jamMulai=jamMulai;
        this.jamSelesai=jamSelesai;
        this.tempat=tempat;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJamMulai() {
        return jamMulai;
    }

    public void setJamMulai(String jamMulai) {
        this.jamMulai = jamMulai;
    }

    public String getJamSelesai() {
        return jamSelesai;
    }

    public void setJamSelesai(String jamSelesai) {
        this.jamSelesai = jamSelesai;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
