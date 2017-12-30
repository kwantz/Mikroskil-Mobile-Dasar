package com.example.kwantz.mobiledasar.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kwantz.mobiledasar.BarangActivity;
import com.example.kwantz.mobiledasar.DIalog.BeliDialog;
import com.example.kwantz.mobiledasar.DetailActivity;
import com.example.kwantz.mobiledasar.Model.Barang;
import com.example.kwantz.mobiledasar.Model.ListBarang;
import com.example.kwantz.mobiledasar.R;

import java.util.ArrayList;

/**
 * Created by axios on 26/12/17.
 */

public class BarangAdapter extends RecyclerView.Adapter<com.example.kwantz.mobiledasar.Adapter.BarangAdapter.ViewHolder> {
    private ArrayList<Barang> arrayBarang = new ArrayList<>();
    private View view;

    public BarangAdapter (ArrayList<Barang> listBarang) {
        this.arrayBarang = listBarang;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, harga_asli, harga_diskon;
        private ImageView gambar;
        private LinearLayout konten;
        private Button beli;

        public ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            harga_asli = view.findViewById(R.id.harga_asli);
            harga_diskon = view.findViewById(R.id.harga_diskon);
            gambar = view.findViewById(R.id.gambar);
            konten = view.findViewById(R.id.konten);
            beli = view.findViewById(R.id.beli);
        }
    }

    @Override
    public com.example.kwantz.mobiledasar.Adapter.BarangAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_barang, parent, false);
        com.example.kwantz.mobiledasar.Adapter.BarangAdapter.ViewHolder viewHolder = new com.example.kwantz.mobiledasar.Adapter.BarangAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(com.example.kwantz.mobiledasar.Adapter.BarangAdapter.ViewHolder holder, final int position) {
        final Barang kataKunci = arrayBarang.get(position);
        holder.title.setText(kataKunci.getTitle());
        holder.gambar.setImageResource(kataKunci.getIcon());

        if (kataKunci.isHargaNormal()) {
            holder.harga_diskon.setText("");
            holder.harga_asli.setText(kataKunci.getHargaAsli());
        } else {
            holder.harga_asli.setText(kataKunci.getHargaDiskon());
            holder.harga_diskon.setText(kataKunci.getHargaAsli());
            holder.harga_asli.setTextColor(view.getResources().getColor(R.color.blPink));
        }

        holder.konten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("Posisi", Integer.toString(kataKunci.getIcon()));
                view.getContext().startActivity(intent);
            }
        });

        holder.beli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new BeliDialog((Activity) view.getContext(), kataKunci.getIcon());
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayBarang.size();
    }
}
