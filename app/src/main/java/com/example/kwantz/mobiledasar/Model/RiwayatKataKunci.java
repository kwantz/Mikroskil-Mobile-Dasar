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
            boolean status = true;
            for(int j = 0; j < kataSimpanan.size(); j++) {
                if(kataSimpanan.get(j).equals(kataKunci.get(i))) {
                    status = false;
                    break;
                }
            }

            if (status) kataSimpanan.add(kataKunci.get(i));
        }

        return kataSimpanan;
    }
}
