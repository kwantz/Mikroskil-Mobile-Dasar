package com.example.kwantz.mobiledasar.Model;

import java.util.ArrayList;

public class RiwayatKataKunci {
    private ArrayList<String> kataKunci;

    public RiwayatKataKunci () {
        kataKunci = new ArrayList<>();
    }

    public void setKataKunci (String kata) {
        kataKunci.add(kata);
    }

    public ArrayList<String> getLimaKataKunciTerakhir () {
        ArrayList<String> kataSimpanan = new ArrayList<>();

        int len = kataKunci.size();
        int size = Math.min(kataKunci.size(), 5);

        for(int i = len - 1; i >= len - size; i--) {
            kataSimpanan.add(kataKunci.get(i));
        }

        return kataSimpanan;
    }
}
