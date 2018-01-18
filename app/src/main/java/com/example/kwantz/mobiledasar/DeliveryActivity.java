package com.example.kwantz.mobiledasar;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.kwantz.mobiledasar.Fragment.PengirimanFragment;

public class DeliveryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        changeIntoFragment();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().findFragmentByTag("PembayaranFragment") != null) {
            changeIntoFragment();
        } else {
            super.onBackPressed();
        }
    }

    private void changeIntoFragment()
    {
        Bundle bundle = new Bundle();
        bundle.putString("icon", getIntent().getExtras().getString("icon"));
        PengirimanFragment pengirimanFragment = new PengirimanFragment();
        pengirimanFragment.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.konten, pengirimanFragment, "PengirimanFragment")
                .commit();
    }
}
