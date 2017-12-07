package com.example.kwantz.mobiledasar.Transaksi.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kwantz.mobiledasar.Model.Barang;
import com.example.kwantz.mobiledasar.Model.ListBarang;
import com.example.kwantz.mobiledasar.Model.TransaksiBarang;
import com.example.kwantz.mobiledasar.R;

import java.util.ArrayList;

public class TagihanAdapter extends RecyclerView.Adapter<TagihanAdapter.ViewHolder> {
    private ArrayList<TransaksiBarang> listBarang = new ArrayList<>();
    private String status;

    public TagihanAdapter (String status) {
        int step = 1;
        this.status = status;

        ListBarang lb = new ListBarang();

        for (Barang barang : lb.getListBarang()) {
            if (isSemuaBarangAtauBarangSudahDibayar(step)) {
                this.listBarang.add(new TransaksiBarang(barang, "DIBAYAR"));
            }
            else if (isSemuaBarangAtauBarangPending(step)) {
                this.listBarang.add(new TransaksiBarang(barang, "MENUNGGU"));
            }
            else if (isSemuaBarang(step)){
                this.listBarang.add(new TransaksiBarang(barang, "KEDALUWARSA"));
            }

            step++;
            if (step == 4) break;
        }
    }

    private Boolean isSemuaBarangAtauBarangSudahDibayar (int idBarang) {
        return (idBarang % 3 == 0) && (this.status.equals("SEMUA") || this.status.equals("DIBAYAR"));
    }

    private Boolean isSemuaBarangAtauBarangPending (int idBarang) {
        return (idBarang % 3 == 1) && (this.status.equals("SEMUA") || this.status.equals("MENUNGGU"));
    }

    private Boolean isSemuaBarang (int idBarang) {
        return (idBarang % 3 == 2) && this.status.equals("SEMUA");
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title, harga, status;
        public ImageView icon;

        public ViewHolder(View view) {
            super(view);

            icon = view.findViewById(R.id.icon);
            title = view.findViewById(R.id.title);
            harga = view.findViewById(R.id.harga);
            status = view.findViewById(R.id.status);
        }
    }

    @Override
    public TagihanAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_tagihan, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TransaksiBarang transaksi = listBarang.get(position);

        holder.icon.setImageResource(transaksi.getBarang().getIcon());
        holder.title.setText(transaksi.getBarang().getTitle());
        holder.status.setText(transaksi.getStatus());

        if (transaksi.getBarang().isHargaNormal()) {
            holder.harga.setText(transaksi.getBarang().getHargaAsli());
        }
        else {
            holder.harga.setText(transaksi.getBarang().getHargaDiskon());
        }
    }

    @Override
    public int getItemCount() {
        return listBarang.size();
    }
}
