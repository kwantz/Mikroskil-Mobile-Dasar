package com.example.kwantz.mobiledasar.Model;

public class TransaksiBarang {
    private Barang barang;
    private String status;

    public TransaksiBarang (Barang barang, String status) {
        this.barang = barang;
        this.status = status;
    }

    public Barang getBarang () {
        return this.barang;
    }

    public String getStatus () {
        return this.status;
    }
}
