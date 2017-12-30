package com.example.kwantz.mobiledasar.DIalog;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.kwantz.mobiledasar.DeliveryActivity;
import com.example.kwantz.mobiledasar.Model.Barang;
import com.example.kwantz.mobiledasar.Model.KeranjangBarang;
import com.example.kwantz.mobiledasar.Model.ListBarang;
import com.example.kwantz.mobiledasar.R;

public class BeliDialog {
    private Barang barang;
    private View viewDialog;
    private AlertDialog alert;
    private AlertDialog.Builder builder;
    private ProgressBar show;
    private Spinner dropdown;
    private LinearLayout konten;
    private ImageView hapus, tutup1, icon;
    private TextView title, harga, totalHarga;
    private Button tutup2, bayar;

    public BeliDialog (Activity activity, int imgBarang) {
        barang = ListBarang.getBarangByImage(imgBarang);
        KeranjangBarang.tambahBarang(barang);

        builder = new AlertDialog.Builder(activity);
        viewDialog = LayoutInflater.from(activity).inflate(R.layout.dialog_beli, null);

        initializationVariable();
        dropdown.setAdapter(getBeliDialogSpinnerAdapter(activity));

        builder.setView(viewDialog);
        alert = builder.create();
        alert.show();

        initializationEvent(activity);
    }

    private void initializationVariable () {
        viewDialog.findViewById(R.id.hapus);
        show = viewDialog.findViewById(R.id.show);
        icon = viewDialog.findViewById(R.id.icon);
        bayar = viewDialog.findViewById(R.id.bayar);
        title = viewDialog.findViewById(R.id.title);
        harga = viewDialog.findViewById(R.id.harga);
        hapus = viewDialog.findViewById(R.id.hapus);
        konten = viewDialog.findViewById(R.id.konten);
        tutup1 = viewDialog.findViewById(R.id.tutup1);
        tutup2 = viewDialog.findViewById(R.id.tutup2);
        dropdown = viewDialog.findViewById(R.id.dropdown);
        totalHarga = viewDialog.findViewById(R.id.total_harga);

        icon.setImageResource(barang.getIcon());
        title.setText(barang.getTitle());

        if (barang.isHargaNormal()) {
            harga.setText(barang.getHargaAsli());
            totalHarga.setText(barang.getHargaAsli());
        } else {
            harga.setText(barang.getHargaDiskon());
            totalHarga.setText(barang.getHargaDiskon());
        }
    }

    private ArrayAdapter<String> getBeliDialogSpinnerAdapter (Activity activity) {
        String[] items = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        return new ArrayAdapter<String>(activity.getBaseContext(), android.R.layout.simple_spinner_dropdown_item, items);
    }

    private void initializationEvent (final Activity activity) {
        konten.setVisibility(View.GONE);
        show.setVisibility(View.VISIBLE);

        tutup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.cancel();
            }
        });
        tutup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.cancel();
            }
        });
        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { new HapusDialog(activity, alert, barang); }
        });

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) { totalHarga.setText(getHargaTotalBarang(i + 1)); }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DeliveryActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                show.setVisibility(View.GONE);
                konten.setVisibility(View.VISIBLE);
            }
        }, 1000);
    }

    private String getHargaTotalBarang (int qty) {
        int n = 0;
        String hargaAsli = harga.getText().toString();

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
}
