package com.example.andri.planner.agenda;

import android.content.ContentValues;

/**
 * Created by andri on 27/12/17.
 */

public class AgendaKerja extends Agenda {
    private String Ruang;
    private String level;

    public AgendaKerja(String id, String judul, String tempat, String jamMulai, String jamSelesai, String deskripsi, String kategori, String Ruang,String level) {
        super(id, judul, tempat, jamMulai, jamSelesai, deskripsi, kategori);
        this.setRuang(Ruang);
        this.setLevel(level);
    }


    public String getRuang() {
        return Ruang;
    }

    public void setRuang(String ruang) {
        Ruang = ruang;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public void reminder() {

    }

    @Override
    public ContentValues tambah_biodata(String judul, String lokasi, String Waktu_mulai, String Waktu_selesai) {
        return null;
    }
}
