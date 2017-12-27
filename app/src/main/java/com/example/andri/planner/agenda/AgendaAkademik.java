package com.example.andri.planner.agenda;

import android.content.ContentValues;

/**
 * Created by andri on 27/12/17.
 */

public class AgendaAkademik extends Agenda {
    private String Ruang;

    public AgendaAkademik(String id, String judul, String tempat, String jamMulai, String jamSelesai, String deskripsi, String kategori, String Ruang) {
        super(id, judul, tempat, jamMulai, jamSelesai, deskripsi, kategori);
        this.setRuang(Ruang);
    }


    public String getRuang() {
        return Ruang;
    }

    public void setRuang(String ruang) {
        Ruang = ruang;
    }

    @Override
    public void reminder() {

    }

    @Override
    public ContentValues tambah_biodata(String judul, String lokasi, String Waktu_mulai, String Waktu_selesai) {
        ContentValues values = new ContentValues();
        values.put("judul", judul);
        values.put("lokasi", lokasi);
        values.put("mulai", Waktu_mulai);
        values.put("selesai", Waktu_selesai);
        values.put("kategori","akademik");
        return values;
    }

}
