package com.example.andri.planner;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.andri.planner.agenda.Agenda;
import com.example.andri.planner.agenda.AgendaAkademik;
import com.example.andri.planner.agenda.AgendaKeluarga;
import com.example.andri.planner.agenda.AgendaKerja;
import com.example.andri.planner.agenda.AgendaLiburan;
import com.example.andri.planner.agenda.AgendaPribadi;
import com.example.andri.planner.db.DataHelper;
import com.example.andri.planner.recycleView.RecyclerViewAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1Fragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Agenda> dataSet;
    //private ArrayList<AgendaAkademik> dataSet1;
    //private ArrayList<AgendaKeluarga> dataSet2;
    //private ArrayList<AgendaKerja> dataSet3;
    //private ArrayList<AgendaLiburan> dataSet4;
    //private ArrayList<AgendaPribadi> dataSet5;


    String[] daftar;
    RecyclerView recyclerView;
    Menu menu;
    protected Cursor cursor;
    DataHelper dbcenter;
    public static Tab1Fragment ma;


    public Tab1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tab1, container, false);

        //dbcenter.get_agenda();
        //dataSet1 = new ArrayList<>();
        //dataSet2 = new ArrayList<>();
        //dataSet3 = new ArrayList<>();
        //dataSet4 = new ArrayList<>();
        //dataSet5 = new ArrayList<>();
        dataSet = new ArrayList<>();
        initDataset();

        rvView = rootView.findViewById(R.id.R_fragment1);
        rvView.setHasFixedSize(true);

        /**
         * Kita menggunakan LinearLayoutManager untuk list standar
         * yang hanya berisi daftar item
         * disusun dari atas ke bawah
         */
        layoutManager = new LinearLayoutManager(getActivity());
        rvView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewAdapter(dataSet);
        rvView.setAdapter(adapter);

        return rootView;


    }

    public void initDataset() {
        dbcenter = new DataHelper(getActivity());
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM agenda", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();

        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            System.out.println(cursor.getString(12).toString());
            if (cursor.getString(12).toString().equals("akademik")) {
                dataSet.add(new AgendaAkademik(
                        cursor.getString(0).toString(), //id
                        cursor.getString(1).toString(), //judul
                        cursor.getString(2).toString(), //tempat
                        cursor.getString(3).toString(), //mulai
                        cursor.getString(4).toString(), //selsei
                        cursor.getString(5).toString(), //deskripsi
                        cursor.getString(12).toString(),
                        cursor.getString(6).toString() //ruang

                ));
            }
            else if (cursor.getString(12).toString().equals("keluarga")) {
                dataSet.add(new AgendaKeluarga(
                        cursor.getString(0).toString(),
                        cursor.getString(1).toString(),
                        cursor.getString(2).toString(),
                        cursor.getString(3).toString(),
                        cursor.getString(4).toString(),
                        cursor.getString(5).toString(),
                        cursor.getString(12).toString(),
                        cursor.getString(7).toString() //kegiatan

                ));
            }
            else if (cursor.getString(12).toString().equals("kerja")) {
                dataSet.add(new AgendaKerja(
                        cursor.getString(0).toString(),
                        cursor.getString(1).toString(),
                        cursor.getString(2).toString(),
                        cursor.getString(3).toString(),
                        cursor.getString(4).toString(),
                        cursor.getString(5).toString(),
                        cursor.getString(12).toString(),
                        cursor.getString(6).toString(),
                        cursor.getString(8).toString() //level
                ));
            }
            else if (cursor.getString(12).toString().equals("liburan")) {
                dataSet.add(new AgendaLiburan(
                        cursor.getString(0).toString(),
                        cursor.getString(1).toString(),
                        cursor.getString(2).toString(),
                        cursor.getString(3).toString(),
                        cursor.getString(4).toString(),
                        cursor.getString(5).toString(),
                        cursor.getString(12).toString(),
                        cursor.getString(9).toString(),
                        cursor.getString(10).toString(),
                        cursor.getString(11).toString()
                ));
            }
            else if (cursor.getString(12).toString() .equals("pribadi")) {
                dataSet.add(new AgendaPribadi(
                        cursor.getString(0).toString(),
                        cursor.getString(1).toString(),
                        cursor.getString(2).toString(),
                        cursor.getString(3).toString(),
                        cursor.getString(4).toString(),
                        cursor.getString(5).toString(),
                        cursor.getString(12).toString(),
                        cursor.getString(7).toString()
                ));
            }
        }

        /**
         * Tambahkan item ke dataset
         * dalam prakteknya bisa bermacam2
         * tidak hanya String seperti di kasus ini
         */
        /**dataSet.add("Karin");
         dataSet.add("Ingrid");
         dataSet.add("Helga");
         dataSet.add("Renate");
         dataSet.add("Elke");
         dataSet.add("Ursula");
         dataSet.add("Erika");
         dataSet.add("Christa");
         dataSet.add("Gisela");
         dataSet.add("Monika");*/

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {




    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
