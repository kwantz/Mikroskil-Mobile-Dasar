package com.example.kwantz.mobiledasar;

import android.graphics.Color;
import android.net.LinkAddress;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import it.sephiroth.android.library.tooltip.Tooltip;

public class DeliveryActivity extends AppCompatActivity {
    private ImageView back , helpPelapak , helpPengganti, check, panahTransfer, panahIndomaret, icBca, icMandiri, icBri, icPermata, icBni;
    private TextView cttn, textPengiriman, textPembayaran , linePembayaran , garisBca, garisMandiri, garisBri, garisPermata,
            garisBni;
    private CheckBox checkPelapak, checkVoucher;
    private LinearLayout tabPengiriman, tabPembayaran, Pelapak, cttnPelapak, transfer, transferOpt, va, vaOpt, indomaret , indomaretOpt,
            btnKetentuTransfer, ketentuTransfer, btnKetentuIndo, ketentuIndo, infoBca, infoMandiri, infoBri, infoPermata, infoBni,
            bcaVa, mandiriVa, briVa, permataVa, bniVa, voucher;
    private ScrollView pengiriman, pembayaran;
    private Button lanjutBayar;
    private RadioButton rTransfer,rVa,rIndomaret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        cttnPelapak = (LinearLayout)findViewById(R.id.cttnPelapak);
        Pelapak = (LinearLayout)findViewById(R.id.pelapak);
        tabPengiriman = (LinearLayout)findViewById(R.id.tab_pengiriman);
        tabPembayaran = (LinearLayout)findViewById(R.id.tab_pembayaran);
        textPengiriman = (TextView)findViewById(R.id.tv_tabPengiriman);
        textPembayaran = (TextView)findViewById(R.id.tv_tabPembayaran);
        linePembayaran = (TextView)findViewById(R.id.line_pembayaran);
        pengiriman = (ScrollView)findViewById(R.id.pengiriman);
        pembayaran = (ScrollView)findViewById(R.id.pembayaran);
        lanjutBayar = (Button)findViewById(R.id.btn_pembayaran);

        View.OnClickListener bayar = new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                textPembayaran.setTextColor(Color.BLACK);
                textPengiriman.setTextColor(Color.rgb(220,220,220));
                check.setVisibility(View.VISIBLE);
                linePembayaran.setVisibility(View.VISIBLE);
                pembayaran.setVisibility(View.VISIBLE);
                pengiriman.setVisibility(View.GONE);
            }
        };
        tabPembayaran.setOnClickListener(bayar);
        lanjutBayar.setOnClickListener(bayar);

        tabPengiriman.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                textPembayaran.setTextColor(Color.rgb(220,220,220));
                textPengiriman.setTextColor(Color.BLACK);
                check.setVisibility(View.INVISIBLE);
                linePembayaran.setVisibility(View.INVISIBLE);
                pembayaran.setVisibility(View.GONE);
                pengiriman.setVisibility(View.VISIBLE);
            }
        });

        transfer = (LinearLayout)findViewById(R.id.transfer);
        va = (LinearLayout)findViewById(R.id.va);
        indomaret = (LinearLayout)findViewById(R.id.indomaret);
        transferOpt = (LinearLayout)findViewById(R.id.transfer_opt);
        vaOpt = (LinearLayout)findViewById(R.id.va_opt);
        indomaretOpt = (LinearLayout)findViewById(R.id.indomaret_opt);
        rTransfer = (RadioButton)findViewById(R.id.radio_transfer);
        rVa = (RadioButton)findViewById(R.id.radio_va);
        rIndomaret = (RadioButton)findViewById(R.id.radio_indomaret);

        transferOpt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                rTransfer.setChecked(true);
                rVa.setChecked(false);
                rIndomaret.setChecked(false);
                va.setVisibility(View.GONE);
                indomaret.setVisibility(View.GONE);
                vaOpt.setBackgroundColor(Color.rgb(247,242,242));
                indomaretOpt.setBackgroundColor(Color.rgb(247,242,242));
                transferOpt.setBackgroundColor(Color.WHITE);
                transfer.setVisibility(View.VISIBLE);
            }
        });

        vaOpt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                rVa.setChecked(true);
                rTransfer.setChecked(false);
                rIndomaret.setChecked(false);
                transfer.setVisibility(View.GONE);
                indomaret.setVisibility(View.GONE);
                transferOpt.setBackgroundColor(Color.rgb(247,242,242));
                indomaretOpt.setBackgroundColor(Color.rgb(247,242,242));
                vaOpt.setBackgroundColor(Color.WHITE);
                va.setVisibility(View.VISIBLE);
            }
        });

        indomaretOpt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                rIndomaret.setChecked(true);
                rTransfer.setChecked(false);
                rVa.setChecked(false);
                transferOpt.setBackgroundColor(Color.rgb(247,242,242));
                vaOpt.setBackgroundColor(Color.rgb(247,242,242));
                transfer.setVisibility(View.GONE);
                va.setVisibility(View.GONE);
                indomaretOpt.setBackgroundColor(Color.WHITE);
                indomaret.setVisibility(View.VISIBLE);
            }
        });

        check = (ImageView)findViewById(R.id.tab_checked);

        cttn = (TextView)findViewById(R.id.tv_cttnPelapak);
        cttn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                cttn.setVisibility(View.GONE);
                cttnPelapak.setVisibility(View.VISIBLE);
            }
        });

        back = (ImageView) findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                onBackPressed();
            }
        });

        checkPelapak = (CheckBox)findViewById(R.id.check_pelapak);
        checkPelapak.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true)
                    Pelapak.setVisibility(View.VISIBLE);
                else
                    Pelapak.setVisibility(View.GONE);
            }
        });

        voucher = (LinearLayout)findViewById(R.id.voucher);
        checkVoucher = (CheckBox)findViewById(R.id.check_voucher);
        checkVoucher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true)
                    voucher.setVisibility(View.VISIBLE);
                else
                    voucher.setVisibility(View.GONE);
            }
        });

        btnKetentuTransfer = (LinearLayout) findViewById(R.id.btn_ketentuanTransfer);
        ketentuTransfer = (LinearLayout) findViewById(R.id.ketentuan_transfer);
        panahTransfer = (ImageView) findViewById(R.id.panah_transfer);

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

        btnKetentuIndo = (LinearLayout) findViewById(R.id.btn_ketentuanIndo);
        ketentuIndo = (LinearLayout) findViewById(R.id.ketentuan_indo);
        panahIndomaret = (ImageView) findViewById(R.id.panah_indo);

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

        bcaVa = (LinearLayout)findViewById(R.id.bca_va);
        mandiriVa = (LinearLayout)findViewById(R.id.mandiri_va);
        briVa = (LinearLayout)findViewById(R.id.bri_va);
        permataVa = (LinearLayout)findViewById(R.id.permata_va);
        bniVa = (LinearLayout)findViewById(R.id.bni_va);
        infoBca = (LinearLayout)findViewById(R.id.info_bca);
        infoMandiri = (LinearLayout)findViewById(R.id.info_mandiri);
        infoBri = (LinearLayout)findViewById(R.id.info_bri);
        infoPermata = (LinearLayout)findViewById(R.id.info_permata);
        infoBni = (LinearLayout)findViewById(R.id.info_bni);
        garisBca = (TextView)findViewById(R.id.garis_bca);
        garisMandiri = (TextView)findViewById(R.id.garis_mandiri);
        garisBri = (TextView)findViewById(R.id.garis_bri);
        garisPermata = (TextView)findViewById(R.id.garis_permata);
        garisBni = (TextView)findViewById(R.id.garis_bni);
        icBca = (ImageView)findViewById(R.id.ic_bca);
        icMandiri = (ImageView)findViewById(R.id.ic_mandiri);
        icBri = (ImageView)findViewById(R.id.ic_bri);
        icPermata = (ImageView)findViewById(R.id.ic_permata);
        icBni = (ImageView)findViewById(R.id.ic_bni);

        View.OnClickListener showInfo = new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.bca_va){
                    infoBca.setVisibility(View.VISIBLE);
                    infoMandiri.setVisibility(View.GONE);
                    infoBni.setVisibility(View.GONE);
                    infoPermata.setVisibility(View.GONE);
                    infoBri.setVisibility(View.GONE);
                    garisMandiri.setVisibility(View.INVISIBLE);
                    icMandiri.setVisibility(View.INVISIBLE);
                    garisBni.setVisibility(View.INVISIBLE);
                    icBni.setVisibility(View.INVISIBLE);
                    garisPermata.setVisibility(View.INVISIBLE);
                    icPermata.setVisibility(View.INVISIBLE);
                    garisBri.setVisibility(View.INVISIBLE);
                    icBri.setVisibility(View.INVISIBLE);
                    if (garisBca.getVisibility()== View.INVISIBLE && icBca.getVisibility() == View.INVISIBLE){
                        icBca.setVisibility(View.VISIBLE);
                        garisBca.setVisibility(View.VISIBLE);
                    }
                    else{
                        garisBca.setVisibility(View.INVISIBLE);
                        icBca.setVisibility(View.INVISIBLE);
                    }
                } else if (view.getId() == R.id.mandiri_va){
                    infoMandiri.setVisibility(View.VISIBLE);
                    infoBca.setVisibility(View.GONE);
                    infoBni.setVisibility(View.GONE);
                    infoPermata.setVisibility(View.GONE);
                    infoBri.setVisibility(View.GONE);
                    garisBca.setVisibility(View.INVISIBLE);
                    icBca.setVisibility(View.INVISIBLE);
                    garisBni.setVisibility(View.INVISIBLE);
                    icBni.setVisibility(View.INVISIBLE);
                    garisPermata.setVisibility(View.INVISIBLE);
                    icPermata.setVisibility(View.INVISIBLE);
                    garisBri.setVisibility(View.INVISIBLE);
                    icBri.setVisibility(View.INVISIBLE);
                    if (garisMandiri.getVisibility()==View.INVISIBLE && icMandiri.getVisibility() == View.INVISIBLE){
                        garisMandiri.setVisibility(View.VISIBLE);
                        icMandiri.setVisibility(View.VISIBLE);
                    }
                    else{
                        garisMandiri.setVisibility(View.INVISIBLE);
                        icMandiri.setVisibility(View.INVISIBLE);
                    }
                } else if (view.getId() == R.id.bri_va){
                    infoBri.setVisibility(View.VISIBLE);
                    infoMandiri.setVisibility(View.GONE);
                    infoBni.setVisibility(View.GONE);
                    infoPermata.setVisibility(View.GONE);
                    infoBca.setVisibility(View.GONE);
                    garisMandiri.setVisibility(View.INVISIBLE);
                    icMandiri.setVisibility(View.INVISIBLE);
                    garisBni.setVisibility(View.INVISIBLE);
                    icBni.setVisibility(View.INVISIBLE);
                    garisPermata.setVisibility(View.INVISIBLE);
                    icPermata.setVisibility(View.INVISIBLE);
                    garisBca.setVisibility(View.INVISIBLE);
                    icBca.setVisibility(View.INVISIBLE);
                    if (garisBri.getVisibility()==View.INVISIBLE && icBri.getVisibility() == View.INVISIBLE){
                        garisBri.setVisibility(View.VISIBLE);
                        icBri.setVisibility(View.VISIBLE);
                    }
                    else{
                        garisBri.setVisibility(View.INVISIBLE);
                        icBri.setVisibility(View.INVISIBLE);
                    }
                } else if (view.getId() == R.id.permata_va){
                    infoPermata.setVisibility(View.VISIBLE);
                    infoMandiri.setVisibility(View.GONE);
                    infoBni.setVisibility(View.GONE);
                    infoBca.setVisibility(View.GONE);
                    infoBri.setVisibility(View.GONE);
                    garisMandiri.setVisibility(View.INVISIBLE);
                    icMandiri.setVisibility(View.INVISIBLE);
                    garisBni.setVisibility(View.INVISIBLE);
                    icBni.setVisibility(View.INVISIBLE);
                    garisBca.setVisibility(View.INVISIBLE);
                    icBca.setVisibility(View.INVISIBLE);
                    garisBri.setVisibility(View.INVISIBLE);
                    icBri.setVisibility(View.INVISIBLE);
                    if (garisPermata.getVisibility()==View.INVISIBLE && icPermata.getVisibility() == View.INVISIBLE){
                        garisPermata.setVisibility(View.VISIBLE);
                        icPermata.setVisibility(View.VISIBLE);
                    }
                    else{
                        garisPermata.setVisibility(View.INVISIBLE);
                        icPermata.setVisibility(View.INVISIBLE);
                    }
                } else if (view.getId() == R.id.bni_va){
                    infoBni.setVisibility(View.VISIBLE);
                    infoMandiri.setVisibility(View.GONE);
                    infoBca.setVisibility(View.GONE);
                    infoPermata.setVisibility(View.GONE);
                    infoBri.setVisibility(View.GONE);
                    garisMandiri.setVisibility(View.INVISIBLE);
                    icMandiri.setVisibility(View.INVISIBLE);
                    garisBca.setVisibility(View.INVISIBLE);
                    icBca.setVisibility(View.INVISIBLE);
                    garisPermata.setVisibility(View.INVISIBLE);
                    icPermata.setVisibility(View.INVISIBLE);
                    garisBri.setVisibility(View.INVISIBLE);
                    icBri.setVisibility(View.INVISIBLE);
                    if (garisBni.getVisibility()== View.INVISIBLE && icBni.getVisibility() == View.INVISIBLE){
                        garisBni.setVisibility(View.VISIBLE);
                        icBni.setVisibility(View.VISIBLE);
                    }
                    else{
                        garisBni.setVisibility(View.INVISIBLE);
                        icBni.setVisibility(View.INVISIBLE);
                    }
                }
            }
        };
        bcaVa.setOnClickListener(showInfo);
        mandiriVa.setOnClickListener(showInfo);
        briVa.setOnClickListener(showInfo);
        permataVa.setOnClickListener(showInfo);
        bniVa.setOnClickListener(showInfo);

        Spinner numSpinner = (Spinner) findViewById(R.id.order_quantity);
        Spinner deliverySpinner = (Spinner) findViewById(R.id.delivery_service);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.quantity_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.delivery_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        numSpinner.setAdapter(adapter);
        deliverySpinner.setAdapter(adapter2);
    }
    public void dialogHelpPelapak (View view){
        helpPelapak = (ImageView) findViewById(R.id.help_pelapak);
        Tooltip.make(this,
                new Tooltip.Builder(101)
                        .anchor(helpPelapak, Tooltip.Gravity.TOP)
                        .closePolicy(new Tooltip.ClosePolicy()
                                .insidePolicy(true, false)
                                .outsidePolicy(true, false), 4000)
                        .activateDelay(900)
                        .showDelay(400)
                        .text("Android PopupWindow with Tooltip Arrow Below Button or view or layout")
                        .maxWidth(600)
                        .withArrow(true)
                        .withOverlay(true).build()
        ).show();
    }
    public void dialogHelpPengganti (View view){
        helpPengganti = (ImageView) findViewById(R.id.help_pengganti);
        Tooltip.make(this,
                new Tooltip.Builder(101)
                        .anchor(helpPengganti, Tooltip.Gravity.TOP)
                        .closePolicy(new Tooltip.ClosePolicy()
                                .insidePolicy(true, false)
                                .outsidePolicy(true, false), 4000)
                        .activateDelay(900)
                        .showDelay(400)
                        .text("Android PopupWindow with Tooltip Arrow Below Button or view or layout")
                        .maxWidth(600)
                        .withArrow(true)
                        .withOverlay(true).build()
        ).show();
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton)view).isChecked();
        switch(view.getId()) {
            case R.id.radio_transfer:
                if (checked){
                    rVa.setChecked(false);
                    rIndomaret.setChecked(false);
                    va.setVisibility(View.GONE);
                    indomaret.setVisibility(View.GONE);
                    vaOpt.setBackgroundColor(Color.rgb(247,242,242));
                    indomaretOpt.setBackgroundColor(Color.rgb(247,242,242));
                    transferOpt.setBackgroundColor(Color.WHITE);
                    transfer.setVisibility(View.VISIBLE);
                    break;
                }
            case R.id.radio_va:
                if (checked) {
                    rTransfer.setChecked(false);
                    rIndomaret.setChecked(false);
                    transfer.setVisibility(View.GONE);
                    indomaret.setVisibility(View.GONE);
                    transferOpt.setBackgroundColor(Color.rgb(247,242,242));
                    indomaretOpt.setBackgroundColor(Color.rgb(247,242,242));
                    vaOpt.setBackgroundColor(Color.WHITE);
                    va.setVisibility(View.VISIBLE);
                    break;
                }
            case R.id.radio_indomaret:
                if (checked){
                    rTransfer.setChecked(false);
                    rVa.setChecked(false);
                    transferOpt.setBackgroundColor(Color.rgb(247,242,242));
                    vaOpt.setBackgroundColor(Color.rgb(247,242,242));
                    transfer.setVisibility(View.GONE);
                    va.setVisibility(View.GONE);
                    indomaretOpt.setBackgroundColor(Color.WHITE);
                    indomaret.setVisibility(View.VISIBLE);
                    break;
                }
        }
    }

}
