package com.example.andri.planner.db;

/**
 * Created by andri on 20/12/17.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import android.content.ContentValues;

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
        String sql = "create table agenda(id int auto_increment, judul text null, lokasi text null, time1 DATETIME DEFAULT CURRENT_TIME null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO agenda (id, judul, lokasi, time1) VALUES ('1','Makan','Indramayu','21:00');";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }

    public void tambah_biodata(String judul, String lokasi) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("judul", judul);
        values.put("lokasi", lokasi);
        database.insert("agenda", null, values);
        database.close();
    }

    public int update_biodata(int id, String judul, String lokasi) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues recordBiodata = new ContentValues();
        recordBiodata.put("judul", judul);
        recordBiodata.put("lokasi", lokasi);
        return database.update("agenda", recordBiodata, "id=" + id, null);
    }

}
