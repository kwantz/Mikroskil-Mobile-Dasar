package com.example.kwantz.mobiledasar.Model;

public class Barang {
    private int icon;
    private String title;
    private String deskripsi;
    private String hargaAsli;
    private String hargaDiskon;
    private String rate;
    private String feed;
    private Boolean seen;
    private String kategori;
    private String berat;

    public Barang (int icon, String title, String deskripsi, String hargaAsli, String hargaDiskon, String rate, String feed, Boolean seen) {
        this.icon = icon;
        this.title = title;
        this.deskripsi = deskripsi;
        this.hargaAsli = hargaAsli;
        this.hargaDiskon = hargaDiskon;
        this.rate = rate;
        this.feed = feed;
        this.seen = seen;
    }

    public void setSeen (Boolean seen) {
        this.seen = seen;
    }

    public int getIcon () {
        return this.icon;
    }

    public String getTitle () {
        return this.title;
    }

    public String getDeskripsi () {
        return this.deskripsi;
    }

    public String getHargaAsli () {
        return this.hargaAsli;
    }

    public String getHargaDiskon () {
        return this.hargaDiskon;
    }

    public String getRate () {
        return this.rate;
    }

    public String getFeed () {
        return this.feed;
    }

    public Boolean isHargaNormal () { return this.hargaDiskon.equals(""); }

    public Boolean isSeen() { return this.seen; }

    public Boolean isSameTitle (String title) { return this.title.equals(title); }
}
