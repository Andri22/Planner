package com.example.andri.planner.db;

/**
 * Created by andri on 20/12/17.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import android.content.ContentValues;

import com.example.andri.planner.agenda.AgendaAkademik;
import com.example.andri.planner.agenda.AgendaKerja;

/**
 * Created by Kuncoro on 22/12/2016.
 */

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "agenda.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table agenda(" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " judul text null," +
                " lokasi text null," +
                " mulai DATETIME null," +
                " selesai DATETIME null," +
                " deskripsi text null," +
                " ruang text null," +
                " Kegiatan text null," +
                " level text null," +
                " estimasiBiaya text null," +
                " kendaraan text null," +
                " perlengkapan text null," +
                " kategori text null" +
                ");";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO agenda(id, judul, lokasi, mulai,selesai,deskripsi, ruang, kategori) VALUES ('1','makan','uin','10/12/2007 21:10','10/12/2007 21:10','makan','102','akademik');";
        db.execSQL(sql);
        sql = "INSERT INTO agenda(id, judul, lokasi, mulai,selesai,deskripsi, kegiatan, kategori) VALUES ('2','makan anjing','uin','12/12/2007 21:10','12/12/2007 21:10','makan','mandi','keluarga');";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }

    public void tambah_biodata(ContentValues values) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.insert("agenda", null, values);
        database.close();
    }

    public int update_biodata(String id, String judul, String lokasi, String Waktu_mulai, String Waktu_selesai) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues recordBiodata = new ContentValues();
        recordBiodata.put("judul", judul);
        recordBiodata.put("lokasi", lokasi);
        recordBiodata.put("mulai", Waktu_mulai);
        recordBiodata.put("selesai", Waktu_selesai);
        return database.update("agenda", recordBiodata, "id=" + id, null);
    }

}
