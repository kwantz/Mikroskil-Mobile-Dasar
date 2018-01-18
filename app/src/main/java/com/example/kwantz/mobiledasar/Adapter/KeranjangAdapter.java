package com.example.kwantz.mobiledasar.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kwantz.mobiledasar.DIalog.HapusDialog;
import com.example.kwantz.mobiledasar.DeliveryActivity;
import com.example.kwantz.mobiledasar.Fragment.KeranjangFragment;
import com.example.kwantz.mobiledasar.Model.Barang;
import com.example.kwantz.mobiledasar.Model.KeranjangBarang;
import com.example.kwantz.mobiledasar.Model.PembelianBarang;
import com.example.kwantz.mobiledasar.R;
import com.example.kwantz.mobiledasar.Transaksi.Adapter.PembelianAdapter;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by axios on 30/12/17.
 */

public class KeranjangAdapter extends RecyclerView.Adapter<KeranjangAdapter.ViewHolder> {
    private ArrayList<Barang> barangArrayList;
    private LinearLayout notFound;
    private RecyclerView rv;

    public KeranjangAdapter (ArrayList<Barang> barang, LinearLayout notFound, RecyclerView rv) {
        this.barangArrayList = barang;
        this.notFound = notFound;
        this.rv = rv;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public Button lanjut;
        public ImageView icon, hapus;
        public TextView title, harga, totalHarga;
        public Spinner dropdown;

        public ViewHolder(View view) {
            super(view);

            this.view = view;
            icon = view.findViewById(R.id.icon);
            title = view.findViewById(R.id.title);
            harga = view.findViewById(R.id.harga);
            hapus = view.findViewById(R.id.hapus);
            lanjut = view.findViewById(R.id.btn_lanjut);
            dropdown = view.findViewById(R.id.dropdown);
            totalHarga = view.findViewById(R.id.total_harga);
        }
    }

    @Override
    public KeranjangAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_keranjang, parent, false);
        KeranjangAdapter.ViewHolder viewHolder = new KeranjangAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final KeranjangAdapter.ViewHolder holder, final int position) {
        final Barang barang = barangArrayList.get(position);

        holder.dropdown.setAdapter(getBeliDialogSpinnerAdapter((Activity) holder.view.getContext()));
        holder.icon.setImageResource(barang.getIcon());
        holder.title.setText(barang.getTitle());

        if (barang.isHargaNormal()) {
            holder.harga.setText(barang.getHargaAsli());
            holder.totalHarga.setText(barang.getHargaAsli());
        } else {
            holder.harga.setText(barang.getHargaDiskon());
            holder.totalHarga.setText(barang.getHargaDiskon());
        }

        holder.lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DeliveryActivity.class);
                intent.putExtra("icon", Integer.toString(barang.getIcon()));
                view.getContext().startActivity(intent);
            }
        });

        holder.dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) { holder.totalHarga.setText(getHargaTotalBarang(i + 1, holder)); }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        holder.hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hapusDialog(holder, barang, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return barangArrayList.size();
    }

    private ArrayAdapter<String> getBeliDialogSpinnerAdapter (Activity activity) {
        String[] items = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        return new ArrayAdapter<String>(activity.getBaseContext(), android.R.layout.simple_spinner_dropdown_item, items);
    }

    private String getHargaTotalBarang (int qty, final KeranjangAdapter.ViewHolder holder) {
        int n = 0;
        String hargaAsli = holder.harga.getText().toString();

        for(int i = 0; i < hargaAsli.length(); i++) {
            if (hargaAsli.charAt(i) >= '0' && hargaAsli.charAt(i) <= '9') {
                n = n * 10 + Character.getNumericValue(hargaAsli.charAt(i));
            }
        }

        String total = Integer.toString(n * qty);
        String hargaTotal = "";

        int temp = 0;
        for(int i = total.length() - 1; i >= 0; i--) {
            hargaTotal = total.charAt(i) + hargaTotal;
            if (temp % 3 == 2) hargaTotal = "." + hargaTotal;

            temp = (temp + 1) % 3;
        }

        return "Rp" + hargaTotal;
    }

    private void hapusDialog (final KeranjangAdapter.ViewHolder holder, final Barang barang, final int position) {
        final AlertDialog alert;
        final LinearLayout konten;
        final ProgressBar progress;

        Button tutup2;
        View viewDialog;
        TextView title;
        ImageView tutup1, icon;
        AlertDialog.Builder builder;

        builder = new AlertDialog.Builder(holder.view.getContext());
        viewDialog = LayoutInflater.from(holder.view.getContext()).inflate(R.layout.dialog_hapus, null);

        icon = viewDialog.findViewById(R.id.icon);
        title = viewDialog.findViewById(R.id.title);
        tutup1 = viewDialog.findViewById(R.id.tutup3);
        tutup2 = viewDialog.findViewById(R.id.tutup4);
        konten = viewDialog.findViewById(R.id.konten);
        progress = viewDialog.findViewById(R.id.show);

        icon.setImageResource(barang.getIcon());
        title.setText(barang.getTitle());

        builder.setView(viewDialog);
        alert = builder.create();
        alert.show();

        tutup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.cancel();
            }
        });
        tutup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                konten.setVisibility(View.GONE);
                progress.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        alert.cancel();

                        KeranjangBarang.buangBarang(barang.getIcon());
                        notifyDataSetChanged();

                        if (KeranjangBarang.barang.size() == 0) {
                            notFound.setVisibility(View.VISIBLE);
                            rv.setVisibility(View.GONE);
                        }
                        Toast toast = Toast.makeText(holder.view.getContext(), "Barang berhasil dihapus", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }, 1000);
            }
        });
    }
}
