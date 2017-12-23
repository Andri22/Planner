package com.example.andri.planner;


import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andri.planner.agenda.Agenda;
import com.example.andri.planner.agenda.AgendaKerja;
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
    private ArrayList<String> dataSet;

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

        Agenda a = new AgendaKerja("dsdssd");

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
            dataSet.add(cursor.getString(2).toString());
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
