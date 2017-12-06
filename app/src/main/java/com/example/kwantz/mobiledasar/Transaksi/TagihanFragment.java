package com.example.kwantz.mobiledasar.Transaksi;

import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.kwantz.mobiledasar.R;

public class TagihanFragment extends Fragment {
    private View view;
    private Button filter;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public TagihanFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tagihan, container, false);

        filter = (Button) view.findViewById(R.id.filter);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.tagihan_rv);

        mLayoutManager = new LinearLayoutManager(this.getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new TagihanAdapter("SEMUA");
        mRecyclerView.setAdapter(mAdapter);

        initializationEvent();
        return view;
    }

    private void initializationEvent () {
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                AlertDialog.Builder ab = new AlertDialog.Builder(getActivity());
                final View viewDialog = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_transaksi_filter, null);

                ab.setView(viewDialog);
                ab.setPositiveButton("FILTER", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        RadioGroup radioGroup = viewDialog.findViewById(R.id.radio_grup);
                        RadioButton radioButton = (RadioButton) viewDialog.findViewById(radioGroup.getCheckedRadioButtonId());

                        if (radioButton.getText().equals("Semua")) {
                            mAdapter = new TagihanAdapter("SEMUA");
                            mRecyclerView.setAdapter(mAdapter);
                            filter.setText("SEMUA");
                        } else if (radioButton.getText().equals("Dibayar")) {
                            mAdapter = new TagihanAdapter("DIBAYAR");
                            mRecyclerView.setAdapter(mAdapter);
                            filter.setText("DIBAYAR");
                        } else if (radioButton.getText().equals("Menunggu Konfirmasi") ) {
                            mAdapter = new TagihanAdapter("MENUNGGU");
                            mRecyclerView.setAdapter(mAdapter);
                            filter.setText("MENUNGGU");
                        }

                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog = ab.create();
                dialog.show();
            }
        });
    }

    private void getFilterName (View view) {
        RadioButton radio1 = view.findViewById(R.id.radio1);
        RadioButton radio2 = view.findViewById(R.id.radio2);
        RadioButton radio3 = view.findViewById(R.id.radio3);

        radio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {

            }
        });

        radio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {}
        });

        radio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {}
        });
    }
}
