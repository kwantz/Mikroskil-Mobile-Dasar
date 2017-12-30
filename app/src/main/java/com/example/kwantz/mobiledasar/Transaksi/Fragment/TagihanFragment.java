package com.example.kwantz.mobiledasar.Transaksi.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.kwantz.mobiledasar.Model.Barang;
import com.example.kwantz.mobiledasar.Model.ListBarang;
import com.example.kwantz.mobiledasar.Model.TransaksiBarang;
import com.example.kwantz.mobiledasar.R;
import com.example.kwantz.mobiledasar.Transaksi.Adapter.TagihanAdapter;

import java.util.ArrayList;

public class TagihanFragment extends Fragment {
    private ArrayList<TransaksiBarang> listBarang = new ArrayList<>();
    private String status;
    private View view;
    private Button filter;
    private ProgressBar progressBar;
    private ImageView konten;
    private LinearLayout notFound;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tagihan, container, false);

        initializationView();
        initializationProgressBar();
        initializationRecycleView();
        initializationEvent();

        return view;
    }

    private Boolean isSemuaBarangAtauBarangSudahDibayar (int idBarang) {
        return (idBarang % 3 == 0) && (this.status.equals("SEMUA") || this.status.equals("DIBAYAR"));
    }

    private Boolean isSemuaBarangAtauBarangPending (int idBarang) {
        return (idBarang % 3 == 1) && (this.status.equals("SEMUA") || this.status.equals("MENUNGGU"));
    }

    private Boolean isSemuaBarang (int idBarang) {
        return (idBarang % 3 == 2) && this.status.equals("SEMUA");
    }

    private void initListBarang (String status) {
        int step = 1;
        this.status = status;
        this.listBarang = new ArrayList<>();

        for (Barang barang : ListBarang.listBarang) {
            if (isSemuaBarangAtauBarangSudahDibayar(step)) {
                this.listBarang.add(new TransaksiBarang(barang, "DIBAYAR"));
            }
            else if (isSemuaBarangAtauBarangPending(step)) {
                this.listBarang.add(new TransaksiBarang(barang, "MENUNGGU"));
            }
            else if (isSemuaBarang(step)){
                this.listBarang.add(new TransaksiBarang(barang, "KEDALUWARSA"));
            }

            step++;
            if (step == 4) break;
        }
    }

    private void initializationView () {
        filter = view.findViewById(R.id.filter);
        progressBar = view.findViewById(R.id.progress);
        mRecyclerView = view.findViewById(R.id.tagihan_rv);
        konten = view.findViewById(R.id.konten);
        notFound = view.findViewById(R.id.not_found);
    }

    private void initializationProgressBar () {
        progressBar.setVisibility(View.GONE);
    }

    private void initializationRecycleView () {
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        initListBarang("SEMUA");
        mAdapter = new TagihanAdapter(this.listBarang);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initializationEvent () {
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                final View viewDialog = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_transaksi_filter, null);

                builder.setView(viewDialog);
                builder.setPositiveButton("FILTER", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        RadioGroup radioGroup = viewDialog.findViewById(R.id.radio_grup);
                        RadioButton radioButton = (RadioButton) viewDialog.findViewById(radioGroup.getCheckedRadioButtonId());

                        runProgressBar(radioButton);
                        dialogInterface.dismiss();
                    }
                });

                builder.create().show();
            }
        });
    }

    private void runProgressBar (RadioButton radioButton) {
        initListBarang("");
        mAdapter = new TagihanAdapter(this.listBarang);
        mRecyclerView.setAdapter(mAdapter);

        konten.setVisibility(View.GONE);
        notFound.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        final Handler handler = new Handler();
        final RadioButton radio = radioButton;

        boolean ok = handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setFilterButtonText(radio);
                progressBar.setVisibility(View.GONE);
                if(listBarang.size() != 0)
                    konten.setVisibility(View.VISIBLE);
                else
                    notFound.setVisibility(View.VISIBLE);
            }
        }, 1000);
    }

    private void setFilterButtonText (RadioButton radio) {
        if (radio.getText().equals("Semua")) {
            initListBarang("SEMUA");
            filter.setText("SEMUA");
        } else if (radio.getText().equals("Dibayar")) {
            initListBarang("DIBAYAR");
            filter.setText("DIBAYAR");
        } else if (radio.getText().equals("Menunggu Konfirmasi") ) {
            initListBarang("MENUNGGU");
            filter.setText("MENUNGGU");
        }
        mAdapter = new TagihanAdapter(this.listBarang);
        mRecyclerView.setAdapter(mAdapter);
    }
}
