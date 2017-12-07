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
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.kwantz.mobiledasar.R;
import com.example.kwantz.mobiledasar.Transaksi.Adapter.TagihanAdapter;

public class TagihanFragment extends Fragment {
    private View view;
    private Button filter;
    private ProgressBar progressBar;
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

    private void initializationView () {
        filter = (Button) view.findViewById(R.id.filter);
        progressBar = (ProgressBar) view.findViewById(R.id.progress);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.tagihan_rv);
    }

    private void initializationProgressBar () {
        progressBar.setVisibility(View.GONE);
    }

    private void initializationRecycleView () {
        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new TagihanAdapter("SEMUA");
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
        mAdapter = new TagihanAdapter("");
        mRecyclerView.setAdapter(mAdapter);

        progressBar.setVisibility(View.VISIBLE);

        final Handler handler = new Handler();
        final RadioButton radio = radioButton;

        boolean ok = handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setFilterButtonText(radio);
                progressBar.setVisibility(View.GONE);
            }
        }, 1000);
    }

    private void setFilterButtonText (RadioButton radio) {
        if (radio.getText().equals("Semua")) {
            mAdapter = new TagihanAdapter("SEMUA");
            mRecyclerView.setAdapter(mAdapter);
            filter.setText("SEMUA");
        } else if (radio.getText().equals("Dibayar")) {
            mAdapter = new TagihanAdapter("DIBAYAR");
            mRecyclerView.setAdapter(mAdapter);
            filter.setText("DIBAYAR");
        } else if (radio.getText().equals("Menunggu Konfirmasi") ) {
            mAdapter = new TagihanAdapter("MENUNGGU");
            mRecyclerView.setAdapter(mAdapter);
            filter.setText("MENUNGGU");
        }
    }
}
