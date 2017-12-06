package com.example.kwantz.mobiledasar.Model;

import com.example.kwantz.mobiledasar.R;

import java.util.ArrayList;

public class ListBarang {
    private ArrayList<Barang> listBarang;

    public ListBarang () {
        this.listBarang = new ArrayList<>();

        this.listBarang.add(new Barang(R.drawable.produk1, "Digital Alliance G D4 Plus  EVO 7 with 2TB HDD  Black", "testing", "Rp6.599.000", "", "4.5", "3"));
        this.listBarang.add(new Barang(R.drawable.produk2, "Sandal karet wanita flat shoes | sepatu sendal cewek", "testing", "Rp55.000", "", "4", "74"));
        this.listBarang.add(new Barang(R.drawable.produk3, "PS3 FAT HARDISK 80GB FREE REQUEST GAME", "testing", "Rp1.300.000", "", "4.5", "26"));
        this.listBarang.add(new Barang(R.drawable.produk4, "ASUS ZENFONE 2 ZE550ML -RAM 2GB ROM 16GB -GARANSI RESMI", "testing", "Rp1.314.000", "", "4", "37"));
        this.listBarang.add(new Barang(R.drawable.produk5, "PROMO BASIC PENCIL SKIRT RK105", "testing", "Rp65.000", "Rp55.300", "5", "2"));
    }

    public ArrayList<Barang> getListBarang () {
        return this.listBarang;
    }
}
