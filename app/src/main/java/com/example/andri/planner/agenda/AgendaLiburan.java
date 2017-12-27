package com.example.andri.planner.agenda;

import android.content.ContentValues;

/**
 * Created by andri on 27/12/17.
 */

public class AgendaLiburan extends Agenda {
    private String Estimasibiaya;
    private String Kendaraan;
    private String Perlengkapan;

    public AgendaLiburan(String id, String judul, String tempat, String jamMulai, String jamSelesai, String deskripsi, String kategori, String Estimasibiaya, String Kendaraan, String Perlengkapan) {
        super(id, judul, tempat, jamMulai, jamSelesai, deskripsi, kategori);
        this.setEstimasibiaya(Estimasibiaya);
        this.setKendaraan(Kendaraan);
        this.setPerlengkapan(Perlengkapan);
    }


    public String getEstimasibiaya() {
        return Estimasibiaya;
    }

    public void setEstimasibiaya(String estimasibiaya) {
        Estimasibiaya = estimasibiaya;
    }

    public String getKendaraan() {
        return Kendaraan;
    }

    public void setKendaraan(String kendaraan) {
        Kendaraan = kendaraan;
    }

    public String getPerlengkapan() {
        return Perlengkapan;
    }

    public void setPerlengkapan(String perlengkapan) {
        Perlengkapan = perlengkapan;
    }

    @Override
    public void reminder() {

    }

    @Override
    public ContentValues tambah_biodata(String judul, String lokasi, String Waktu_mulai, String Waktu_selesai) {
        return null;
    }
}
