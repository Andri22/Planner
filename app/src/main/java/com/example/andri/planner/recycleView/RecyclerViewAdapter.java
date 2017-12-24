package com.example.andri.planner.recycleView;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andri.planner.MainActivity;
import com.example.andri.planner.R;
import com.example.andri.planner.TambahAgenda;
import com.example.andri.planner.agenda.AgendaKerja;

import java.util.ArrayList;

/**
 * Created by andri on 20/12/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<AgendaKerja> rvData;

    public RecyclerViewAdapter(ArrayList<AgendaKerja> inputData) {
        rvData = inputData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // di tutorial ini kita hanya menggunakan data String untuk tiap item
        public TextView tvTitle;
        public TextView tvSubtitle;
        public TextView tvJam;
        public LinearLayout tvButton;

        public ViewHolder(View v) {
            super(v);
            tvTitle = v.findViewById(R.id.tv_title);
            tvSubtitle = v.findViewById(R.id.tv_subtitle);
            tvButton = v.findViewById(R.id.tv_item);
            tvJam = v.findViewById(R.id.tv_jam);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // membuat view baru
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_rv_item, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - mengambil elemen dari dataset (ArrayList) pada posisi tertentu
        // - mengeset isi view dengan elemen dari dataset tersebut

        final AgendaKerja agenda = rvData.get(position);

        holder.tvTitle.setText(agenda.getJudul());
        holder.tvSubtitle.setText(agenda.getTempat());
        holder.tvJam.setText(agenda.getJamMulai().split(" ")[1]);

        holder.tvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] a = agenda.getJamMulai().split(" ");

                for (int q = 0; q < a.length; q++) {

                    System.out.println(a[q]);
                }


            }
        });

    }

    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return rvData.size();
    }
}
