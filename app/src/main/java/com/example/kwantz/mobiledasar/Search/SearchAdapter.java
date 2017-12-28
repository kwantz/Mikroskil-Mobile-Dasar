package com.example.kwantz.mobiledasar.Search;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kwantz.mobiledasar.BarangActivity;
import com.example.kwantz.mobiledasar.Model.PembelianBarang;
import com.example.kwantz.mobiledasar.Model.RiwayatKataKunci;
import com.example.kwantz.mobiledasar.R;
import com.example.kwantz.mobiledasar.Transaksi.Adapter.PembelianAdapter;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private ArrayList<String> arrayKataKunci = new ArrayList<>();

    public SearchAdapter () {
        this.arrayKataKunci = RiwayatKataKunci.getLimaKataKunciTerakhir();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;

        public ViewHolder(View view) {
            super(view);

            text = view.findViewById(R.id.text);
        }
    }

    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_kata_kunci, parent, false);
        SearchAdapter.ViewHolder viewHolder = new SearchAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SearchAdapter.ViewHolder holder, int position) {
        final String kataKunci = arrayKataKunci.get(position);
        Log.e("posisi", position + " " + arrayKataKunci.get(position));
        holder.text.setText(kataKunci);

        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), BarangActivity.class);
                intent.putExtra("Input", kataKunci);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayKataKunci.size();
    }
}
