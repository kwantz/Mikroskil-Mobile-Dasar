package com.example.kwantz.mobiledasar.Model;

import android.util.Log;

import java.util.ArrayList;

public class RiwayatBarang {
    static public ArrayList<Barang> barang = new ArrayList<>();

    static public void setBarang (Barang brg) { barang.add(brg); }

    static public ArrayList<Barang> getRiwayatBarang () {
        ArrayList<Barang> temp = new ArrayList<>();

        int len = barang.size();
        int size = Math.min(barang.size(), 5);

        for(int i = len - 1; i >= len - size; i--) {
            boolean status = true;
            for(int j = 0; j < temp.size(); j++) {
                if (barang.get(i).getIcon() == temp.get(j).getIcon()) {
                    status = false;
                    break;
                }
            }

            if (status) temp.add(barang.get(i));
        }

        return temp;
    }
}
