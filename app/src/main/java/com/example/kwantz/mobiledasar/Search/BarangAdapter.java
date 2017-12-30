package com.example.kwantz.mobiledasar.Search;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kwantz.mobiledasar.DetailActivity;
import com.example.kwantz.mobiledasar.Model.Barang;
import com.example.kwantz.mobiledasar.Model.ListBarang;
import com.example.kwantz.mobiledasar.Model.PembelianBarang;
import com.example.kwantz.mobiledasar.Model.RiwayatKataKunci;
import com.example.kwantz.mobiledasar.R;
import com.example.kwantz.mobiledasar.Transaksi.Adapter.PembelianAdapter;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.ViewHolder> {
    private ArrayList<Barang> arrayBarang = new ArrayList<>();

    public BarangAdapter () {
        this.arrayBarang = ListBarang.getTigaRiwayatBarangTerakhir();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, harga;
        private ImageView gambar;
        private LinearLayout barang;

        public ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            harga = view.findViewById(R.id.harga);
            gambar = view.findViewById(R.id.gambar);
            barang = view.findViewById(R.id.barang);
        }
    }

    @Override
    public BarangAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_riwayat_barang, parent, false);
        BarangAdapter.ViewHolder viewHolder = new BarangAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BarangAdapter.ViewHolder holder, final int position) {
        final Barang kataKunci = arrayBarang.get(position);
        holder.title.setText(kataKunci.getTitle());
        holder.harga.setText(kataKunci.getHargaAsli());
        holder.gambar.setImageResource(kataKunci.getIcon());

        holder.barang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("Posisi", Integer.toString(kataKunci.getIcon()));
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayBarang.size();
    }
}
