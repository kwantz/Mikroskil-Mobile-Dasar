package com.example.kwantz.mobiledasar;

import android.app.Dialog;
import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kwantz.mobiledasar.Model.Barang;
import com.example.kwantz.mobiledasar.Model.ListBarang;

import static com.example.kwantz.mobiledasar.R.layout.dialog_waspada;

public class DetailTagihanActivity extends AppCompatActivity {
    final Context context = this;
    private TextView detail, salinBca, salinMandiri, salinSyariah, salinBni, salinBri;
    private ImageView closeDialog, panah, back;
    private Button salinHarga;
    private LinearLayout detailTotal, detailHarga;
    private Barang barang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tagihan);

        detail = (TextView) findViewById(R.id.detail);
        salinHarga = (Button) findViewById(R.id.salin_harga);
        salinBca = (TextView) findViewById(R.id.salin_bca);
        salinMandiri = (TextView) findViewById(R.id.salin_mandiri);
        salinSyariah = (TextView) findViewById(R.id.salin_syariah);
        salinBni = (TextView) findViewById(R.id.salin_bni);
        salinBri = (TextView) findViewById(R.id.salin_bri);

        this.barang = ListBarang.getBarangByImage(Integer.parseInt(getIntent().getExtras().getString("icon")));

        back = (ImageView) findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                onBackPressed();
            }
        });

        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // custom dialog
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

                dialog.setContentView(dialog_waspada);
                dialog.show();
                final ImageView closeDialog = dialog.findViewById(R.id.close_dialog);
                closeDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (dialog != null && dialog.isShowing())
                            dialog.dismiss();
                    }
                });

            }
        });

        salinHarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Toast toast = Toast.makeText(DetailTagihanActivity.this, "Berhasil salin nominal pembayaran", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        View.OnClickListener salinRek = new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(DetailTagihanActivity.this, "Berhasil salin no rekening bank", Toast.LENGTH_SHORT);
                toast.show();
            }
        };

        salinBca.setOnClickListener(salinRek);
        salinMandiri.setOnClickListener(salinRek);
        salinSyariah.setOnClickListener(salinRek);
        salinBni.setOnClickListener(salinRek);
        salinBri.setOnClickListener(salinRek);

        panah = (ImageView)findViewById(R.id.panah);
        detailTotal = (LinearLayout)findViewById(R.id.detail_total);
        detailHarga = (LinearLayout)findViewById(R.id.detail_harga);
        detailTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (detailHarga.getVisibility()==View.GONE){
                    detailHarga.setVisibility(View.VISIBLE);
                    panah.setImageResource(R.drawable.ic_expand_less_black_24dp);
                }
                else{
                    detailHarga.setVisibility(View.GONE);
                    panah.setImageResource(R.drawable.ic_expand_more_grey);
                }
            }
        });
    }
}
