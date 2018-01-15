package com.example.kwantz.mobiledasar.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.kwantz.mobiledasar.Model.ListBarang;
import com.example.kwantz.mobiledasar.R;

public class PembayaranFragment extends Fragment {

    View view;
    LinearLayout ketentuTransfer, btnKetentuTransfer, voucher, tabPengiriman, transferOpt, va, indomaret, transfer, vaOpt, indomaretOpt, btnKetentuIndo, ketentuIndo, bcaVa, mandiriVa, briVa, permataVa, bniVa, infoBca, infoMandiri, infoBri, infoPermata, infoBni;
    ImageView panahTransfer, btnBack, panahIndomaret, icBca, icMandiri, icBri, icPermata, icBni;
    RadioButton rTransfer, rVa, rIndomaret;
    TextView garisBca, garisMandiri, garisBri, garisPermata, garisBni, tvHargaBarang, tvHargaKirim, tvHargaTotal;
    CheckBox checkVoucher;
    String hargaBarang, hargaKirim;

    public PembayaranFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.fragment_pembayaran, container, false);

        this.hargaBarang = getArguments().getString("hargaBarang");
        this.hargaKirim = getArguments().getString("hargaKirim");

        initializationVariable();
        initializationEvent();
        return this.view;
    }

    private void initializationVariable() {
        btnBack = view.findViewById(R.id.back_btn);
        tabPengiriman = view.findViewById(R.id.tab_pengiriman);
        transferOpt = view.findViewById(R.id.transfer_opt);
        rTransfer = view.findViewById(R.id.radio_transfer);
        rVa = view.findViewById(R.id.radio_va);
        rIndomaret = view.findViewById(R.id.radio_indomaret);
        va = view.findViewById(R.id.va);
        indomaret = view.findViewById(R.id.indomaret);
        transfer = view.findViewById(R.id.transfer);
        vaOpt = view.findViewById(R.id.va_opt);
        indomaretOpt = view.findViewById(R.id.indomaret_opt);

        btnKetentuTransfer = view.findViewById(R.id.btn_ketentuanTransfer);
        ketentuTransfer = view.findViewById(R.id.ketentuan_transfer);
        panahTransfer = view.findViewById(R.id.panah_transfer);

        btnKetentuIndo = view.findViewById(R.id.btn_ketentuanIndo);
        ketentuIndo = view.findViewById(R.id.ketentuan_indo);
        panahIndomaret = view.findViewById(R.id.panah_indo);

        bcaVa = view.findViewById(R.id.bca_va);
        mandiriVa = view.findViewById(R.id.mandiri_va);
        briVa = view.findViewById(R.id.bri_va);
        permataVa = view.findViewById(R.id.permata_va);
        bniVa = view.findViewById(R.id.bni_va);
        infoBca = view.findViewById(R.id.info_bca);
        infoMandiri = view.findViewById(R.id.info_mandiri);
        infoBri = view.findViewById(R.id.info_bri);
        infoPermata = view.findViewById(R.id.info_permata);
        infoBni = view.findViewById(R.id.info_bni);
        garisBca = view.findViewById(R.id.garis_bca);
        garisMandiri = view.findViewById(R.id.garis_mandiri);
        garisBri = view.findViewById(R.id.garis_bri);
        garisPermata = view.findViewById(R.id.garis_permata);
        garisBni = view.findViewById(R.id.garis_bni);
        icBca = view.findViewById(R.id.ic_bca);
        icMandiri = view.findViewById(R.id.ic_mandiri);
        icBri = view.findViewById(R.id.ic_bri);
        icPermata = view.findViewById(R.id.ic_permata);
        icBni = view.findViewById(R.id.ic_bni);
        checkVoucher = view.findViewById(R.id.check_voucher);
        voucher = view.findViewById(R.id.voucher);

        tvHargaBarang = view.findViewById(R.id.harga_barang);
        tvHargaKirim = view.findViewById(R.id.harga_kirim);
        tvHargaTotal = view.findViewById(R.id.harga_total);

        tvHargaBarang.setText(this.hargaBarang);
        tvHargaKirim.setText(this.hargaKirim);
        tvHargaTotal.setText(this.getHargaTotalBarang());
    }

    private void initializationEvent() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                (getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.konten, new PengirimanFragment()).commit();
            }
        });

        tabPengiriman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                (getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.konten, new PengirimanFragment()).commit();
            }
        });

        transferOpt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onRadioButtonChange("transfer");
            }
        });

        vaOpt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onRadioButtonChange("va");
            }
        });

        indomaretOpt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onRadioButtonChange("indomaret");
            }
        });

        btnKetentuTransfer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (ketentuTransfer.getVisibility() == View.GONE){
                    ketentuTransfer.setVisibility(View.VISIBLE);
                    panahTransfer.setImageResource(R.drawable.ic_arrow_drop_up_black_24dp);
                }
                else{
                    ketentuTransfer.setVisibility(View.GONE);
                    panahTransfer.setImageResource(R.drawable.ic_arrow_drop_down_pink);
                }
            }
        });

        btnKetentuIndo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (ketentuIndo.getVisibility() == View.GONE){
                    ketentuIndo.setVisibility(View.VISIBLE);
                    panahIndomaret.setImageResource(R.drawable.ic_arrow_drop_up_black_24dp);
                }
                else{
                    ketentuIndo.setVisibility(View.GONE);
                    panahIndomaret.setImageResource(R.drawable.ic_arrow_drop_down_pink);
                }
            }
        });

        bcaVa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onVAChange("BCA");
            }
        });
        mandiriVa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onVAChange("Mandiri");
            }
        });
        briVa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onVAChange("BRI");
            }
        });
        permataVa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onVAChange("Permata");
            }
        });
        bniVa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onVAChange("BNI");
            }
        });

        checkVoucher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true)
                    voucher.setVisibility(View.VISIBLE);
                else
                    voucher.setVisibility(View.GONE);
            }
        });
    }

    private void onVAChange (String radio) {
        setBCA(radio);
        setMandiri(radio);
        setBNI(radio);
        setPermata(radio);
        setBRI(radio);
    }

    private void setBCA (String radio) {
        if (radio.equals("BCA")) {
            infoBca.setVisibility(View.VISIBLE);
            if (garisBca.getVisibility()== View.INVISIBLE && icBca.getVisibility() == View.INVISIBLE){
                icBca.setVisibility(View.VISIBLE);
                garisBca.setVisibility(View.VISIBLE);
            }
            else{
                garisBca.setVisibility(View.INVISIBLE);
                icBca.setVisibility(View.INVISIBLE);
            }
        } else {
            infoBca.setVisibility(View.GONE);
            garisBca.setVisibility(View.INVISIBLE);
            icBca.setVisibility(View.INVISIBLE);
        }
    }

    private void setMandiri (String radio) {
        if (radio.equals("Mandiri")) {
            infoMandiri.setVisibility(View.VISIBLE);
            if (garisMandiri.getVisibility()== View.INVISIBLE && icMandiri.getVisibility() == View.INVISIBLE){
                icMandiri.setVisibility(View.VISIBLE);
                garisMandiri.setVisibility(View.VISIBLE);
            }
            else{
                garisMandiri.setVisibility(View.INVISIBLE);
                icMandiri.setVisibility(View.INVISIBLE);
            }
        } else {
            infoMandiri.setVisibility(View.GONE);
            garisMandiri.setVisibility(View.INVISIBLE);
            icMandiri.setVisibility(View.INVISIBLE);
        }
    }

    private void setBNI (String radio) {
        if (radio.equals("BNI")) {
            infoBni.setVisibility(View.VISIBLE);
            if (garisBni.getVisibility()== View.INVISIBLE && icBni.getVisibility() == View.INVISIBLE){
                icBni.setVisibility(View.VISIBLE);
                garisBni.setVisibility(View.VISIBLE);
            }
            else{
                garisBni.setVisibility(View.INVISIBLE);
                icBni.setVisibility(View.INVISIBLE);
            }
        } else {
            infoBni.setVisibility(View.GONE);
            garisBni.setVisibility(View.INVISIBLE);
            icBni.setVisibility(View.INVISIBLE);
        }
    }

    private void setPermata (String radio) {
        if (radio.equals("Permata")) {
            infoPermata.setVisibility(View.VISIBLE);
            if (garisPermata.getVisibility() == View.INVISIBLE && icPermata.getVisibility() == View.INVISIBLE) {
                icPermata.setVisibility(View.VISIBLE);
                garisPermata.setVisibility(View.VISIBLE);
            } else {
                icPermata.setVisibility(View.INVISIBLE);
                garisPermata.setVisibility(View.INVISIBLE);
            }
        } else {
            infoPermata.setVisibility(View.GONE);
            icPermata.setVisibility(View.INVISIBLE);
            garisPermata.setVisibility(View.INVISIBLE);
        }
    }

    private void setBRI (String radio) {
        if (radio.equals("BRI")) {
            infoBri.setVisibility(View.VISIBLE);
            if (garisBri.getVisibility() == View.INVISIBLE && icBri.getVisibility() == View.INVISIBLE) {
                icBri.setVisibility(View.VISIBLE);
                garisBri.setVisibility(View.VISIBLE);
            } else {
                icBri.setVisibility(View.INVISIBLE);
                garisBri.setVisibility(View.INVISIBLE);
            }
        } else {
            infoBri.setVisibility(View.GONE);
            icBri.setVisibility(View.INVISIBLE);
            garisBri.setVisibility(View.INVISIBLE);
        }
    }


    private void onRadioButtonChange (String radio) {
        setVA(radio);
        setTransfer(radio);
        setIndomaret(radio);
    }

    private void setTransfer (String radio) {
        if (radio.equals("transfer")) {
            rTransfer.setChecked(true);
            transfer.setVisibility(View.VISIBLE);
            transferOpt.setBackgroundColor(Color.WHITE);
        } else {
            rTransfer.setChecked(false);
            transfer.setVisibility(View.GONE);
            transferOpt.setBackgroundColor(Color.rgb(247,242,242));
        }
    }

    private void setVA (String radio) {
        if (radio.equals("va")) {
            rVa.setChecked(true);
            va.setVisibility(View.VISIBLE);
            vaOpt.setBackgroundColor(Color.WHITE);
        } else {
            rVa.setChecked(false);
            va.setVisibility(View.GONE);
            vaOpt.setBackgroundColor(Color.rgb(247,242,242));
        }
    }

    private void setIndomaret (String radio) {
        if (radio.equals("indomaret")) {
            rIndomaret.setChecked(true);
            indomaret.setVisibility(View.VISIBLE);
            indomaretOpt.setBackgroundColor(Color.WHITE);
        } else {
            rIndomaret.setChecked(false);
            indomaret.setVisibility(View.GONE);
            indomaretOpt.setBackgroundColor(Color.rgb(247,242,242));
        }
    }

    private String getHargaTotalBarang () {
        int barang = 0, kirim = 0;

        for(int i = 0; i < this.hargaBarang.length(); i++) {
            if (this.hargaBarang.charAt(i) >= '0' && this.hargaBarang.charAt(i) <= '9') {
                barang = barang * 10 + Character.getNumericValue(this.hargaBarang.charAt(i));
            }
        }

        for(int i = 0; i < this.hargaKirim.length(); i++) {
            if (this.hargaKirim.charAt(i) >= '0' && this.hargaKirim.charAt(i) <= '9') {
                kirim = kirim * 10 + Character.getNumericValue(this.hargaKirim.charAt(i));
            }
        }

        String total = Integer.toString(barang + kirim);
        String hargaTotal = "";

        int temp = 0;
        for(int i = total.length() - 1; i >= 0; i--) {
            hargaTotal = total.charAt(i) + hargaTotal;
            if (temp % 3 == 2) hargaTotal = "." + hargaTotal;

            temp = (temp + 1) % 3;
        }

        return "Rp" + hargaTotal;
    }
}
