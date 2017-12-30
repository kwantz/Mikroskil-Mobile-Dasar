package com.example.kwantz.mobiledasar.Transaksi.Adapter;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kwantz.mobiledasar.Model.Barang;
import com.example.kwantz.mobiledasar.Model.ListBarang;
import com.example.kwantz.mobiledasar.Model.PembelianBarang;
import com.example.kwantz.mobiledasar.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PembelianAdapter extends RecyclerView.Adapter<PembelianAdapter.ViewHolder> {
    private ArrayList<PembelianBarang> pembelianBarang = new ArrayList<>();

    public PembelianAdapter (ArrayList<PembelianBarang> pembelianBarangArrayList) {
        this.pembelianBarang = pembelianBarangArrayList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CircleImageView pending, paid, send, take, finish;
        public TextView title, harga, status;
        public ImageView icon;
        public View view;

        public ViewHolder(View view) {
            super(view);

            this.view = view;
            paid = view.findViewById(R.id.paid);
            send = view.findViewById(R.id.send);
            take = view.findViewById(R.id.take);
            finish = view.findViewById(R.id.finish);
            pending = view.findViewById(R.id.pending);

            icon = view.findViewById(R.id.icon);
            title = view.findViewById(R.id.title);
            harga = view.findViewById(R.id.harga);
            status = view.findViewById(R.id.status);
        }
    }

    @Override
    public PembelianAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_pembelian, parent, false);
        PembelianAdapter.ViewHolder viewHolder = new PembelianAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PembelianAdapter.ViewHolder holder, int position) {
        PembelianBarang barang = pembelianBarang.get(position);

        setCircleImageViewPending(holder, barang);
        setCircleImageViewPaid(holder, barang);
        setCircleImageViewSend(holder, barang);
        setCircleImageViewTake(holder, barang);
        setCircleImageViewFinish(holder, barang);

        holder.icon.setImageResource(barang.getBarang().getIcon());
        holder.title.setText(barang.getBarang().getTitle());
        holder.status.setText(barang.getStatus());

        if (barang.getBarang().isHargaNormal()) {
            holder.harga.setText(barang.getBarang().getHargaAsli());
        } else {
            holder.harga.setText(barang.getBarang().getHargaDiskon());
        }
    }

    private ColorDrawable setWarnaUntukStatusPembelian (PembelianAdapter.ViewHolder holder, Boolean status) {
        if (status)
            return new ColorDrawable(holder.view.getResources().getColor(R.color.finish));

        return new ColorDrawable(holder.view.getResources().getColor(R.color.pending));
    }

    private void setCircleImageViewPending (PembelianAdapter.ViewHolder holder, PembelianBarang barang) {
        Drawable color = setWarnaUntukStatusPembelian(holder, barang.isPending());
        Drawable image = holder.view.getResources().getDrawable(R.drawable.ic_waiting_32);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{color, image});

        holder.pending.setImageDrawable(layerDrawable);
    }

    private void setCircleImageViewPaid (PembelianAdapter.ViewHolder holder, PembelianBarang barang) {
        Drawable color = setWarnaUntukStatusPembelian(holder, barang.isPaid());
        Drawable image = holder.view.getResources().getDrawable(R.drawable.ic_paid_32);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{color, image});

        holder.paid.setImageDrawable(layerDrawable);
    }

    private void setCircleImageViewSend (PembelianAdapter.ViewHolder holder, PembelianBarang barang) {
        Drawable color = setWarnaUntukStatusPembelian(holder, barang.isSend());
        Drawable image = holder.view.getResources().getDrawable(R.drawable.ic_delivered_32);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{color, image});

        holder.send.setImageDrawable(layerDrawable);
    }

    private void setCircleImageViewTake (PembelianAdapter.ViewHolder holder, PembelianBarang barang) {
        Drawable color = setWarnaUntukStatusPembelian(holder, barang.isTake());
        Drawable image = holder.view.getResources().getDrawable(R.drawable.ic_accepted_32);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{color, image});

        holder.take.setImageDrawable(layerDrawable);
    }

    private void setCircleImageViewFinish (PembelianAdapter.ViewHolder holder, PembelianBarang barang) {
        Drawable color = setWarnaUntukStatusPembelian(holder, barang.isFinish());
        Drawable image = holder.view.getResources().getDrawable(R.drawable.ic_finished_32);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{color, image});

        holder.finish.setImageDrawable(layerDrawable);
    }

    @Override
    public int getItemCount() {
        return pembelianBarang.size();
    }
}
