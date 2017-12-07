package com.example.kwantz.mobiledasar.Transaksi.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.kwantz.mobiledasar.R;
import com.example.kwantz.mobiledasar.Transaksi.Adapter.PembelianAdapter;

public class PenjualanFragment extends Fragment {
    private View view;
    private Button filter;
    private ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_penjualan, container, false);
        filter = (Button) view.findViewById(R.id.filter);
        progressBar = (ProgressBar) view.findViewById(R.id.progress);

        initializationEvent();
        progressBar.setVisibility(View.GONE);
        
        return view;
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

                        runProgressBar();
                        dialogInterface.dismiss();
                    }
                });

                builder.create().show();
            }
        });
    }

    private void runProgressBar () {
        progressBar.setVisibility(View.VISIBLE);

        final Handler handler = new Handler();

        boolean ok = handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        }, 1000);
    }
}
