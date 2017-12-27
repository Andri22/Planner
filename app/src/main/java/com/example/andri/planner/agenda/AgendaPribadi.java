package com.example.andri.planner.agenda;

import android.content.ContentValues;

/**
 * Created by andri on 27/12/17.
 */

public class AgendaPribadi extends Agenda {
    private String Kegiatan;

    public AgendaPribadi(String id, String judul, String tempat, String jamMulai, String jamSelesai, String deskripsi, String kategori, String Kegiatan) {
        super(id, judul, tempat, jamMulai, jamSelesai, deskripsi, kategori);
        this.setKegiatan(Kegiatan);
    }


    public String getKegiatan() {
        return Kegiatan;
    }

    public void setKegiatan(String kegiatan) {
        Kegiatan = kegiatan;
    }

    @Override
    public void reminder() {

    }

    @Override
    public ContentValues tambah_biodata(String judul, String lokasi, String Waktu_mulai, String Waktu_selesai) {
        return null;
    }


}
