package com.example.kwantz.mobiledasar.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.kwantz.mobiledasar.R;

import it.sephiroth.android.library.tooltip.Tooltip;

public class PengirimanFragment extends Fragment {

    View view;
    Button btnPembayaran;
    LinearLayout tabPembayaran, bgProgress, Pelapak, cttnPelapak;
    ProgressBar barProgress;
    CheckBox checkPelapak;
    ImageView helpPelapak, helpPengganti;
    Spinner numSpinner, deliverySpinner;
    TextView cttn;

    public PengirimanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.fragment_pengiriman, container, false);
        initializationVariable();
        initializationEvent();
        return view;
    }

    private void initializationVariable() {
        btnPembayaran = view.findViewById(R.id.btn_pembayaran);
        tabPembayaran = view.findViewById(R.id.tab_pembayaran);
        bgProgress = view.findViewById(R.id.bg_progress);
        barProgress = view.findViewById(R.id.bar_progress);
        checkPelapak = view.findViewById(R.id.check_pelapak);
        Pelapak = view.findViewById(R.id.pelapak);
        helpPelapak = view.findViewById(R.id.help_pelapak);
        numSpinner = view.findViewById(R.id.order_quantity);
        deliverySpinner = view.findViewById(R.id.delivery_service);
        cttn = view.findViewById(R.id.tv_cttnPelapak);
        cttnPelapak = view.findViewById(R.id.cttnPelapak);
        helpPengganti = view.findViewById(R.id.help_pengganti);
    }

    private void initializationEvent() {
        bgProgress.setVisibility(View.GONE);
        barProgress.setVisibility(View.GONE);

        helpPelapak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tooltip.make(getActivity(), new Tooltip.Builder(101)
                        .anchor(helpPelapak, Tooltip.Gravity.TOP)
                        .closePolicy(new Tooltip.ClosePolicy()
                                .insidePolicy(true, false)
                                .outsidePolicy(true, false), 4000)
                        .activateDelay(900)
                        .showDelay(400)
                        .text("Pilihan ini dapat digunakan untuk pengiriman sebagai dropshipper.\n\nTips: Chat pelapak terlebih dahulu untuk membuat kesepakatan terkait pengriminan")
                        .maxWidth(600)
                        .withArrow(true)
                        .withOverlay(true).build()
                ).show();
            }
        });

        helpPengganti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tooltip.make(getActivity(), new Tooltip.Builder(101)
                        .anchor(helpPengganti, Tooltip.Gravity.TOP)
                        .closePolicy(new Tooltip.ClosePolicy()
                                .insidePolicy(true, false)
                                .outsidePolicy(true, false), 4000)
                        .showDelay(400)
                        .text("1.\tPenggantian barang dilakukan dengan barang yang sama dari pelapak lain oleh Bukalapak jika pesanan ditolak/tidak ditanggapi pelapak.\n2.\tPenggantian barang dilakukan tergantung ketersediaan barang di Bukalapak.\n3.\tSelisih harga penggantian barang (bila ada) ditanggung oleh Bukalapak.\n4.\tSyarat dan ketentuan berlaku.")
                        .maxWidth(600)
                        .withArrow(true)
                        .withOverlay(true).build()
                ).show();
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.quantity_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numSpinner.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(), R.array.delivery_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        deliverySpinner.setAdapter(adapter2);

        cttn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                cttn.setVisibility(View.GONE);
                cttnPelapak.setVisibility(View.VISIBLE);
            }
        });

        btnPembayaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bgProgress.setVisibility(View.VISIBLE);
                barProgress.setVisibility(View.VISIBLE);

                final Handler handler = new Handler();
                boolean ok = handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        barProgress.setVisibility(View.GONE);
                        bgProgress.setVisibility(View.GONE);
                        (getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.konten, new PembayaranFragment()).commit();
                    }
                }, 1000);
            }
        });

        tabPembayaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bgProgress.setVisibility(View.VISIBLE);
                barProgress.setVisibility(View.VISIBLE);

                final Handler handler = new Handler();
                boolean ok = handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        barProgress.setVisibility(View.GONE);
                        bgProgress.setVisibility(View.GONE);
                        (getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.konten, new PembayaranFragment()).commit();
                    }
                }, 1000);
            }
        });

        checkPelapak.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true)
                    Pelapak.setVisibility(View.VISIBLE);
                else
                    Pelapak.setVisibility(View.GONE);
            }
        });
    }
}
