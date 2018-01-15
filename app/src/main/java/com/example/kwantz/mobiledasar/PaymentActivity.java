package com.example.kwantz.mobiledasar;

import android.app.Dialog;
import android.content.Context;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.kwantz.mobiledasar.R.layout.dialog_waspada;


public class PaymentActivity extends AppCompatActivity {
    final Context context = this;
    TextView detail, salinHarga, salinBca, salinMandiri, salinSyariah, salinBni, salinBri;
    ImageView closeDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        detail = (TextView) findViewById(R.id.detail);
        salinHarga = (TextView) findViewById(R.id.salin_harga);
        salinBca = (TextView) findViewById(R.id.salin_bca);
        salinMandiri = (TextView) findViewById(R.id.salin_mandiri);
        salinSyariah = (TextView) findViewById(R.id.salin_syariah);
        salinBni = (TextView) findViewById(R.id.salin_bni);
        salinBri = (TextView) findViewById(R.id.salin_bri);

        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // custom dialog
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                final ImageView closeDialog = dialog.findViewById(R.id.close_dialog);
                closeDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (dialog != null && dialog.isShowing())
                            dialog.dismiss();
                    }
                });
                dialog.setContentView(dialog_waspada);
                dialog.show();
            }
        });

        salinHarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Toast toast = Toast.makeText(PaymentActivity.this, "Berhasil salin nominal pembayaran", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        View.OnClickListener salinRek = new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(PaymentActivity.this, "Berhasil salin no rekening bank", Toast.LENGTH_SHORT);
                toast.show();
            }
        };

        salinBca.setOnClickListener(salinRek);
        salinMandiri.setOnClickListener(salinRek);
        salinSyariah.setOnClickListener(salinRek);
        salinBni.setOnClickListener(salinRek);
        salinBri.setOnClickListener(salinRek);

    }
}
