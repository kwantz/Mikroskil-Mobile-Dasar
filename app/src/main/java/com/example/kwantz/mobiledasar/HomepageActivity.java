package com.example.kwantz.mobiledasar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import java.lang.reflect.Field;

public class HomepageActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_favorit:
                    mTextMessage.setText(R.string.title_favorit);
                    return true;
                case R.id.navigation_keranjang:
                    mTextMessage.setText(R.string.title_keranjang);
                    return true;
                case R.id.navigation_transaksi:
                    mTextMessage.setText(R.string.title_transaksi);
                    return true;
                case R.id.navigation_akun:
                    mTextMessage.setText(R.string.title_akun);
                    return true;
            }
            return false;
        }

    };

    /*
    * Fungsi khusus ini digunakan untuk menampilkan title beserta icon kedalam bottom nav
    * Karena secara default, android hanya menampilkan title + icon hanya boleh maks. 3 btn
    * Lebih dari itu, hanya tombol aktif yang menampilkan title + icon, sisanya icon
    * */
    public static void disableShiftMode (BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                //noinspection RestrictedApi
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                //noinspection RestrictedApi
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        initializationVariable();
        initializationEvent();
    }

    private void initializationVariable () {
        navigation = (BottomNavigationView) findViewById(R.id.navigation);

        mTextMessage = (TextView) findViewById(R.id.message);
    }

    private void initializationEvent () {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        disableShiftMode(navigation);
    }
}
