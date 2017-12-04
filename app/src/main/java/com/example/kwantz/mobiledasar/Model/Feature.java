package com.example.kwantz.mobiledasar.Model;

public class Feature {
    private String title;
    private int icon;

    public Feature (String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    public String getTitle () {
        return this.title;
    }

    public int getIcon () {
        return this.icon;
    }
}
