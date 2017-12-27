package com.example.andri.planner.agenda;

import android.content.ContentValues;

/**
 * Created by andri on 27/12/17.
 */

public class AgendaKeluarga extends Agenda {
    private String BentukKegiatan;

    public AgendaKeluarga(String id, String judul, String tempat, String jamMulai, String jamSelesai, String deskripsi, String kategori, String BentukKegiatan) {
        super(id, judul, tempat, jamMulai, jamSelesai, deskripsi, kategori);
        this.setBentukKegiatan(BentukKegiatan);
    }


    public String getBentukKegiatan() {
        return BentukKegiatan;
    }

    public void setBentukKegiatan(String bentukKegiatan) {
        BentukKegiatan = bentukKegiatan;
    }

    @Override
    public void reminder() {

    }

    @Override
    public ContentValues tambah_biodata(String judul, String lokasi, String Waktu_mulai, String Waktu_selesai) {
        return null;
    }
}
