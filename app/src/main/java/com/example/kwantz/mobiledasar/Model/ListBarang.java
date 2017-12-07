package com.example.kwantz.mobiledasar.Model;

import com.example.kwantz.mobiledasar.R;

import java.util.ArrayList;

public class ListBarang {
    private ArrayList<Barang> listBarang;

    public ListBarang () {
        this.listBarang = new ArrayList<>();

        this.listBarang.add(new Barang(R.drawable.produk1, "Digital Alliance G D4 Plus  EVO 7 with 2TB HDD  Black", "testing", "Rp6.599.000", "", "4.5", "3", true));
        this.listBarang.add(new Barang(R.drawable.produk2, "Sandal karet wanita flat shoes | sepatu sendal cewek", "testing", "Rp55.000", "", "4", "74", false));
        this.listBarang.add(new Barang(R.drawable.produk3, "PS3 FAT HARDISK 80GB FREE REQUEST GAME", "testing", "Rp1.300.000", "", "4.5", "26", true));
        this.listBarang.add(new Barang(R.drawable.produk4, "ASUS ZENFONE 2 ZE550ML -RAM 2GB ROM 16GB -GARANSI RESMI", "testing", "Rp1.314.000", "", "4", "37", false));
        this.listBarang.add(new Barang(R.drawable.produk5, "PROMO BASIC PENCIL SKIRT RK105", "testing", "Rp65.000", "Rp55.300", "5", "2", false));
        this.listBarang.add(new Barang(R.drawable.produk6, "Celana Jeans Fashion Wanita HIGHWAIST Sobek code 9840", "testing", "Rp140.000", "", "4", "1", false));
        this.listBarang.add(new Barang(R.drawable.produk7, "OTG Sandisk Ultra Dual Drive M 3.0 16gb Usb 3.0", "testing", "Rp100.500", "", "4.5", "73", false));
    }

    public ArrayList<Barang> getListBarang () {
        return this.listBarang;
    }

    public void setRiwayatBarang (String title) {
        for (Barang barang : listBarang) {
            if (barang.isSameTitle(title)) {
                barang.setSeen(true);
            }
        }
    }

    public ArrayList<Barang> getLimaRiwayatBarangTerakhir () {
        ArrayList<Barang> barangSimpanan = new ArrayList<>();

        for (int i = listBarang.size() - 1; i >= 0; i--) {
            barangSimpanan.add(listBarang.get(i));
            if (barangSimpanan.size() == 5) break;
        }

        return barangSimpanan;
    }
}
