package com.example.kwantz.mobiledasar.Model;

import java.util.ArrayList;

/**
 * Created by axios on 30/12/17.
 */

public class KeranjangBarang {
    static public ArrayList<Barang> barang = new ArrayList<>();

    static public void buangBarang (int imgBarang) {
        for (int i = 0; i < barang.size(); i++) {
            if( barang.get(i).getIcon() == imgBarang ) {
                barang.remove(i);
            }
        }
    }

    static public void tambahBarang (Barang brg) {
        boolean status = true;
        for (int i = 0; i < barang.size(); i++) {
            if (barang.get(i).getIcon() == brg.getIcon()) {
                status = false;
                break;
            }
        }

        if (status) barang.add(brg);
    }
}
