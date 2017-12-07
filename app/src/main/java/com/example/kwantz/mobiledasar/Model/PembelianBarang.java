package com.example.kwantz.mobiledasar.Model;

public class PembelianBarang {
    private Barang barang;
    private String status;
    private Boolean pending, paid, send, take, finish;

    public PembelianBarang(Barang barang, String status) {
        this.barang = barang;

        switch (status) {
            case "SELESAI":
                this.pending = true;
                this.paid = true;
                this.send = true;
                this.take = true;
                this.finish = true;
                this.status = "Selesai";
                break;
            case "MENUNGGU":
                this.pending = true;
                this.paid = false;
                this.send = false;
                this.take = false;
                this.finish = false;
                this.status = "";
                break;
            case "DIBAYAR":
                this.pending = true;
                this.paid = true;
                this.send = false;
                this.take = false;
                this.finish = false;
                this.status = "";
                break;
            case "DIKIRIM":
                this.pending = true;
                this.paid = true;
                this.send = true;
                this.take = false;
                this.finish = false;
                this.status = "";
                break;
            case "DITERIMA":
                this.pending = true;
                this.paid = true;
                this.send = true;
                this.take = true;
                this.finish = false;
                this.status = "";
                break;
            case "DIKEMBALIKAN":
                this.pending = true;
                this.paid = true;
                this.send = false;
                this.take = false;
                this.finish = true;
                this.status = "Dikembalikan";
                break;
        }
    }

    public Barang getBarang() {
        return this.barang;
    }

    public String getStatus() { return this.status; }

    public Boolean isPending() { return this.pending; }

    public Boolean isSend() { return this.send; }

    public Boolean isTake() { return this.take; }

    public Boolean isPaid() { return this.paid; }

    public Boolean isFinish() { return this.finish; }
}