package com.example.kwantz.mobiledasar.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.kwantz.mobiledasar.Adapter.KeranjangAdapter;
import com.example.kwantz.mobiledasar.DeliveryActivity;
import com.example.kwantz.mobiledasar.Model.Barang;
import com.example.kwantz.mobiledasar.Model.KeranjangBarang;
import com.example.kwantz.mobiledasar.R;

import java.util.ArrayList;

public class KeranjangFragment extends Fragment {
    private ArrayList<Barang> barangArrayList;

    public KeranjangFragment() {
        this.barangArrayList = KeranjangBarang.barang;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_keranjang, container, false);

        final RecyclerView rv = rootView.findViewById(R.id.rv);
        final LinearLayout notFound = rootView.findViewById(R.id.not_found);
        final ProgressBar progressBar = rootView.findViewById(R.id.progress_bar);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (barangArrayList.size() == 0) {
                    progressBar.setVisibility(View.GONE);
                    notFound.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                    rv.setVisibility(View.VISIBLE);
                }
            }
        }, 500);

        LinearLayoutManager llm = new LinearLayoutManager(this.getActivity());
        KeranjangAdapter ka = new KeranjangAdapter(this.barangArrayList, notFound, rv);


        rv.setLayoutManager(llm);
        rv.setAdapter(ka);

        return rootView;
    }

    public void wow () {}
}
