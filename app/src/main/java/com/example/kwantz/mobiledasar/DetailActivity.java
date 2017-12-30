package com.example.kwantz.mobiledasar;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kwantz.mobiledasar.DIalog.BeliDialog;
import com.example.kwantz.mobiledasar.Model.Barang;
import com.example.kwantz.mobiledasar.Model.ListBarang;
import com.example.kwantz.mobiledasar.Model.RiwayatBarang;

import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private ImageView back, gambar;
    private TextView title, hargaDiskon, hargaAsli, kategori, berat, titleBar;
    private LinearLayout kurir, detailKurir;
    private Button beli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        back = (ImageView) findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                onBackPressed();
            }
        });

        int posisi = Integer.parseInt(getIntent().getExtras().getString("Posisi"));
        final Barang barang;

        if (ListBarang.getBarangByImage(posisi) == null) {
            barang = ListBarang.listBarang.get(posisi);
        } else {
            barang = ListBarang.getBarangByImage(posisi);
        }

        RiwayatBarang.setBarang(barang);

        gambar = (ImageView) findViewById(R.id.gambar);
        title = (TextView) findViewById(R.id.title);
        hargaDiskon = (TextView) findViewById(R.id.harga_diskon);
        hargaAsli = (TextView) findViewById(R.id.harga_asli);
        kategori = (TextView) findViewById(R.id.kategori);
        berat = (TextView) findViewById(R.id.berat);
        titleBar = (TextView) findViewById(R.id.title_bar);
        kurir = (LinearLayout) findViewById(R.id.kurir);
        detailKurir = (LinearLayout) findViewById(R.id.detail_kurir);
        beli = (Button) findViewById(R.id.beli);

        kurir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(detailKurir.getVisibility() == View.GONE)
                    detailKurir.setVisibility(View.VISIBLE);
                else
                    detailKurir.setVisibility(View.GONE);
            }
        });

        final Activity activity = this;
        beli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new BeliDialog(activity, barang.getIcon());
            }
        });

        gambar.setImageResource(barang.getIcon());
        title.setText(barang.getTitle());
        titleBar.setText(barang.getTitle());

        if (barang.isHargaNormal()) {
            hargaDiskon.setText("");
            hargaAsli.setText(barang.getHargaAsli());
        } else {
            hargaDiskon.setText(barang.getHargaAsli());
            hargaAsli.setText(barang.getHargaDiskon());
        }
    }
}
