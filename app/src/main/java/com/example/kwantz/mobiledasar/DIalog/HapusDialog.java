package com.example.kwantz.mobiledasar.DIalog;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kwantz.mobiledasar.Model.Barang;
import com.example.kwantz.mobiledasar.Model.KeranjangBarang;
import com.example.kwantz.mobiledasar.R;

public class HapusDialog {
    private Barang barang;
    private View viewDialog;
    private AlertDialog alert, parent;
    private AlertDialog.Builder builder;
    private LinearLayout konten;
    private ProgressBar progress;
    private ImageView tutup1, icon;
    private TextView title;
    private Button tutup2;

    public HapusDialog (Activity activity, AlertDialog parent, Barang barang) {
        this.parent = parent;
        this.barang = barang;

        builder = new AlertDialog.Builder(activity);
        viewDialog = LayoutInflater.from(activity).inflate(R.layout.dialog_hapus, null);

        initializationVariable();

        builder.setView(viewDialog);
        alert = builder.create();
        alert.show();

        initializationEvent(activity);
    }

    private void initializationVariable () {
        icon = viewDialog.findViewById(R.id.icon);
        title = viewDialog.findViewById(R.id.title);
        tutup1 = viewDialog.findViewById(R.id.tutup3);
        tutup2 = viewDialog.findViewById(R.id.tutup4);
        konten = viewDialog.findViewById(R.id.konten);
        progress = viewDialog.findViewById(R.id.show);

        icon.setImageResource(barang.getIcon());
        title.setText(barang.getTitle());
    }

    private void initializationEvent (final Activity activity) {
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
                        if(parent != null) parent.cancel();

                        KeranjangBarang.buangBarang(barang.getIcon());
                        Toast toast = Toast.makeText(activity, "Barang berhasil dihapus", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }, 1000);
            }
        });
    }
}
