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
import com.example.kwantz.mobiledasar.Model.PembelianBarang;
import com.example.kwantz.mobiledasar.R;
import com.example.kwantz.mobiledasar.Transaksi.Adapter.PembelianAdapter;

import java.util.ArrayList;

public class PembelianFragment extends Fragment {
    private ArrayList<PembelianBarang> pembelianBarang = new ArrayList<>();
    private String status;

    private View view;
    private Button filter;
    private ProgressBar progressBar;
    private ImageView konten;
    private LinearLayout notFound;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Boolean isSemuaBarangAtauBarangSelesai(int idBarang) {
        return (idBarang > 3) && (idBarang % 4 == 0) && (this.status.equals("SEMUA") || this.status.equals("SELESAI"));
    }

    private Boolean isSemuaBarangAtauBarangDikembalikan(int idBarang) {
        return (idBarang > 3) && (idBarang % 4 == 1) && (this.status.equals("SEMUA") || this.status.equals("DIKEMBALIKAN"));
    }

    private Boolean isSemuaBarangAtauBarangSedangDikirim(int idBarang) {
        return (idBarang > 3) && (idBarang % 4 == 2) && (this.status.equals("SEMUA") || this.status.equals("DIKIRIM"));
    }

    private Boolean isSemuaBarangAtauBarangSedangDiterima(int idBarang) {
        return (idBarang > 3) && (idBarang % 4 == 3) && (this.status.equals("SEMUA") || this.status.equals("DITERIMA"));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pembelian, container, false);

        initializationView();
        initializationProgressBar();
        initializationRecycleView();
        initializationEvent();

        return view;
    }

    private void initializationView () {
        filter = view.findViewById(R.id.filter);
        progressBar = view.findViewById(R.id.progress);
        mRecyclerView = view.findViewById(R.id.pembelian_rv);
        konten = view.findViewById(R.id.konten);
        notFound = view.findViewById(R.id.not_found);
    }

    private void initPembelianArray (String status) {
        int step = 1;
        this.status = status;
        this.pembelianBarang = new ArrayList<>();

        for (Barang barang : ListBarang.listBarang) {
            if (isSemuaBarangAtauBarangSedangDikirim(step)) {
                this.pembelianBarang.add(new PembelianBarang(barang, "DIKIRIM"));
            }
            else if (isSemuaBarangAtauBarangSedangDiterima(step)) {
                this.pembelianBarang.add(new PembelianBarang(barang, "DITERIMA"));
            }
            else if (isSemuaBarangAtauBarangSelesai(step)) {
                this.pembelianBarang.add(new PembelianBarang(barang, "SELESAI"));
            }
            else if (isSemuaBarangAtauBarangDikembalikan(step)) {
                this.pembelianBarang.add(new PembelianBarang(barang, "DIKEMBALIKAN"));
            }

            step++;
            if (step == 8) break;
        }
    }

    private void initializationProgressBar () {
        progressBar.setVisibility(View.GONE);
    }

    private void initializationRecycleView () {
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        initPembelianArray("SEMUA");
        mAdapter = new PembelianAdapter(this.pembelianBarang);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initializationEvent () {
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                final View viewDialog = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_pembelian_filter, null);

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
        initPembelianArray("");
        mAdapter = new PembelianAdapter(this.pembelianBarang);
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
                if (pembelianBarang.size() != 0)
                    konten.setVisibility(View.VISIBLE);
                else
                    notFound.setVisibility(View.VISIBLE);
            }
        }, 1000);
    }

    private void setFilterButtonText (RadioButton radio) {
        initPembelianArray(radio.getText().toString().toUpperCase());
        mAdapter = new PembelianAdapter(this.pembelianBarang);
        mRecyclerView.setAdapter(mAdapter);

        filter.setText(radio.getText().toString().toUpperCase());
    }
}
