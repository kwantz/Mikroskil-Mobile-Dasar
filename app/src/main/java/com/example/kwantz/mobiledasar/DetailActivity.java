package com.example.kwantz.mobiledasar;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kwantz.mobiledasar.Model.Barang;
import com.example.kwantz.mobiledasar.Model.ListBarang;

import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private ImageView back, gambar;
    private TextView title, hargaDiskon, hargaAsli, kategori, berat, titleBar;

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
        Barang barang = ListBarang.getBarangByImage(posisi);

        if (barang == null) {
            barang = ListBarang.listBarang.get(posisi);
        }

        ListBarang.setRiwayatBarang(barang.getIcon());

        gambar = (ImageView) findViewById(R.id.gambar);
        title = (TextView) findViewById(R.id.title);
        hargaDiskon = (TextView) findViewById(R.id.harga_diskon);
        hargaAsli = (TextView) findViewById(R.id.harga_asli);
        kategori = (TextView) findViewById(R.id.kategori);
        berat = (TextView) findViewById(R.id.berat);
        titleBar = (TextView) findViewById(R.id.title_bar);

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
