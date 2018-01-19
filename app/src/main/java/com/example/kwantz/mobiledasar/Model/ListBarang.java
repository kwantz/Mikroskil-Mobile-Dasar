package com.example.kwantz.mobiledasar.Model;

import com.example.kwantz.mobiledasar.R;

import java.util.ArrayList;

public class ListBarang {
    static public ArrayList<Barang> listBarang = new ArrayList<>();

    static public void initList () {
        listBarang = new ArrayList<>();

        listBarang.add(new Barang(R.drawable.produk1, "Digital Alliance G D4 Plus  EVO 7 with 2TB HDD  Black", "testing", "Rp6.599.000", "", "4.5", "3", true));
        listBarang.add(new Barang(R.drawable.produk2, "Sandal karet wanita flat shoes | sepatu sendal cewek", "testing", "Rp55.000", "", "4", "74", false));
        listBarang.add(new Barang(R.drawable.produk3, "PS3 FAT HARDISK 80GB FREE REQUEST GAME", "testing", "Rp1.300.000", "", "4.5", "26", true));
        listBarang.add(new Barang(R.drawable.produk4, "ASUS ZENFONE 2 ZE550ML -RAM 2GB ROM 16GB -GARANSI RESMI", "testing", "Rp1.314.000", "", "4", "37", false));
        listBarang.add(new Barang(R.drawable.produk5, "PROMO BASIC PENCIL SKIRT RK105", "testing", "Rp65.000", "Rp55.300", "5", "2", false));
        listBarang.add(new Barang(R.drawable.produk6, "Celana Jeans Fashion Wanita HIGHWAIST Sobek code 9840", "testing", "Rp140.000", "", "4", "1", false));
        listBarang.add(new Barang(R.drawable.produk7, "OTG Sandisk Ultra Dual Drive M 3.0 16gb Usb 3.0", "testing", "Rp100.500", "", "4.5", "73", false));
        listBarang.add(new Barang(R.drawable.produk6, "Celana Jeans Fashion Wanita HIGHWAIST Sobek code 9840", "testing", "Rp140.000", "", "4", "1", false));
        listBarang.add(new Barang(R.drawable.produk11, "Laptop Asus x200m Mulus like new", "", "Rp2.400.000", "", "4", "1", false));
        listBarang.add(new Barang(R.drawable.produk12, "Laptop Asus X441UV Core I3 6006 Colour Windows 10 original garansi resmi 1TAHUN", "", "Rp7.914.200", "", "4", "1", false ));
        listBarang.add(new Barang(R.drawable.produk13, "Laptop Lenovo Ideapad s300s mulus fullset", "", "Rp2.300.000", "", "4", "1", false));
    }

    static public void setRiwayatBarang (int img) {
        for (Barang barang : listBarang) {
            if (barang.getIcon() == img) {
                barang.setSeen(true);
            }
        }
    }

    static public ArrayList<Barang> getTigaRiwayatBarangTerakhir () {
        ArrayList<Barang> barangSimpanan = new ArrayList<>();

        for (int i = listBarang.size() - 1; i >= 0; i--) {
            if (listBarang.get(i).isSeen())
                barangSimpanan.add(listBarang.get(i));
            if (barangSimpanan.size() == 3) break;
        }

        return barangSimpanan;
    }

    static public Barang getBarangByImage (int img) {
        for (Barang barang : listBarang) {
            if (barang.getIcon() == img) {
                return barang;
            }
        }
        return null;
    }

    static public ArrayList<Barang> getBarangWithTitle (String title) {
        ArrayList<Barang> barangSimpanan = new ArrayList<>();
        String[] arrayTitle = title.split(" ");

        for (Barang barang : listBarang) {
            boolean status = false;
            for (int i = 0; i < arrayTitle.length; i++) {
                String text1 = barang.getTitle().toLowerCase();
                String text2 = arrayTitle[i].toLowerCase();
                int isFound = text1.indexOf(text2);

                status = (isFound != -1);
                if (!status) { break; }
            }

            if (status) barangSimpanan.add(barang);
        }

        return barangSimpanan;
    }
}
