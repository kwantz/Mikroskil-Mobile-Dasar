package com.example.kwantz.mobiledasar;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class DeliveryActivity extends AppCompatActivity {
    private ImageView back;
    private TextView cttn;
    private CheckBox checkPelapak;
    private LinearLayout Pelapak, cttnPelapak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        cttnPelapak = (LinearLayout)findViewById(R.id.cttnPelapak);
        Pelapak = (LinearLayout)findViewById(R.id.pelapak);

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
}
