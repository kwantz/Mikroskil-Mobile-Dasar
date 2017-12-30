package com.example.kwantz.mobiledasar;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.kwantz.mobiledasar.Model.ListBarang;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run()
            {
                Intent homeIntent = new Intent(MainActivity.this, HomepageActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, 4000);
    }
}
