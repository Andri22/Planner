package com.example.andri.planner.agenda;

import android.content.ContentValues;

/**
 * Created by andri on 20/12/17.
 */

public abstract class Agenda {

    private String id;
    private String judul;
    private String WaktuMulai;
    private String WaktuSelesai;
    private String tempat;
    private String deskripsi;
    private String kategori;


    public Agenda(String id, String judul, String tempat, String jamMulai, String jamSelesai , String deskripsi, String kategori) {
        this.setId(id);
        this.setJudul(judul);
        this.setWaktuMulai(jamMulai);
        this.setWaktuSelesai(jamSelesai);
        this.setTempat(tempat);
        this.setDeskripsi(deskripsi);
        this.setKategori(kategori);

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getWaktuMulai() {
        return WaktuMulai;
    }

    public void setWaktuMulai(String waktuMulai) {
        WaktuMulai = waktuMulai;
    }

    public String getWaktuSelesai() {
        return WaktuSelesai;
    }

    public void setWaktuSelesai(String waktuSelesai) {
        WaktuSelesai = waktuSelesai;
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

    public abstract void reminder();


    public abstract ContentValues tambah_biodata(String judul, String lokasi, String Waktu_mulai, String Waktu_selesai);

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}


