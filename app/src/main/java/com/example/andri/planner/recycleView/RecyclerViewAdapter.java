package com.example.andri.planner.recycleView;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.andri.planner.R;
import com.example.andri.planner.UpdateAgenda;
import com.example.andri.planner.agenda.Agenda;
import com.example.andri.planner.agenda.AgendaAkademik;

import java.util.ArrayList;

/**
 * Created by andri on 20/12/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    //private ArrayList<AgendaAkademik> rvData1;
    //private ArrayList<AgendaAkademik> rvData2;
    //private ArrayList<AgendaAkademik> rvData3;
    //private ArrayList<AgendaAkademik> rvData4;
    //private ArrayList<AgendaAkademik> rvData5;
    private ArrayList<Agenda> rvData;

    private Context mContext;
    private Activity activity;


    public RecyclerViewAdapter(ArrayList<Agenda> inputData) {
        this.rvData = inputData;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        // di tutorial ini kita hanya menggunakan data String untuk tiap item
        public TextView tvTitle;
        public TextView tvSubtitle;
        public TextView tvJam, tvJam2, tvTgl, tvTgl1;
        public LinearLayout tvButton;

        public ViewHolder(View itemSelect) {
            super(itemSelect);
            mContext = itemSelect.getContext();
            tvTitle = itemSelect.findViewById(R.id.tv_title);
            tvSubtitle = itemSelect.findViewById(R.id.tv_subtitle);
            tvButton = itemSelect.findViewById(R.id.tv_item);
            tvJam = itemSelect.findViewById(R.id.tv_jam);
            tvJam2 = itemSelect.findViewById(R.id.tv_jam2);


            itemSelect.setClickable(true);



            itemSelect.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {

                }



            });

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
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - mengambil elemen dari dataset (ArrayList) pada posisi tertentu
        // - mengeset isi view dengan elemen dari dataset tersebut

        final Agenda agenda = rvData.get(position);

        System.out.println(agenda.getJudul());
        System.out.println(agenda.getWaktuMulai().split(" ")[0]);

        holder.tvTitle.setText(agenda.getJudul());
        holder.tvSubtitle.setText(agenda.getWaktuMulai().split(" ")[0]);
        holder.tvJam.setText(agenda.getWaktuMulai().split(" ")[1]);
        holder.tvJam2.setText(agenda.getWaktuSelesai().split(" ")[1]);

        holder.tvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), UpdateAgenda.class);
                if(agenda.getKategori().equals("akademik")){
                    intent.putExtra("judul", holder.tvTitle.getText());
                    intent.putExtra("id", agenda.getId());
                    intent.putExtra("subtitle", holder.tvSubtitle.getText());
                    intent.putExtra("Wmulai", holder.tvJam.getText());
                    intent.putExtra("Wselesai", holder.tvJam2.getText());
                    intent.putExtra("Tmulai", agenda.getWaktuMulai().split(" ")[0]);
                    intent.putExtra("Tselesai", agenda.getWaktuSelesai().split(" ")[0]);
                }
                view.getContext().startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        // menghitung ukuran dataset / jumlah data yang ditampilkan di RecyclerView
        return rvData.size();
    }

    // method untuk menghapus data recyclerview
    public void remove(String item) {
        int position = rvData.indexOf(item);
        rvData.remove(position);
        notifyItemRemoved(position);
    }
}
