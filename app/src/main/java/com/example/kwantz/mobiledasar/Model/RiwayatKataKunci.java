package com.example.kwantz.mobiledasar.Model;

import android.util.Log;

import java.util.ArrayList;

public class RiwayatKataKunci {
    static public ArrayList<String> kataKunci = new ArrayList<>();

    static public void setKataKunci (String kata) {
        kataKunci.add(kata);
    }

    static public ArrayList<String> getLimaKataKunciTerakhir () {
        ArrayList<String> kataSimpanan = new ArrayList<>();

        int len = kataKunci.size();
        int size = Math.min(kataKunci.size(), 5);

        for(int i = len - 1; i >= len - size; i--) {
            Log.e("Data", len + " " + size + " " + i + " " + kataKunci.get(i));
            kataSimpanan.add(kataKunci.get(i));
        }

        return kataSimpanan;
    }
}
