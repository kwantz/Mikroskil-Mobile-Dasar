package com.example.kwantz.mobiledasar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.TextView;

import com.example.kwantz.mobiledasar.Adapter.HomepageGridAdapter;
import com.example.kwantz.mobiledasar.Fragment.AkunFragment;
import com.example.kwantz.mobiledasar.Fragment.FavoritFragment;
import com.example.kwantz.mobiledasar.Fragment.HomeFragment;
import com.example.kwantz.mobiledasar.Fragment.KeranjangFragment;
import com.example.kwantz.mobiledasar.Fragment.TransaksiFragment;

import java.lang.reflect.Field;

public class HomepageActivity extends AppCompatActivity {

    private BottomNavigationView navigation;
    private GridView gridView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, new HomeFragment()).commit();
                    return true;
                case R.id.navigation_favorit:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, new FavoritFragment()).commit();
                    return true;
                case R.id.navigation_keranjang:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, new KeranjangFragment()).commit();
                    return true;
                case R.id.navigation_transaksi:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, new TransaksiFragment()).commit();
                    return true;
                case R.id.navigation_akun:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, new AkunFragment()).commit();
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

        // Jalankan Fragement untuk pertama kali dibuka (kalau nggk, nnt jdi kosong)
        getSupportFragmentManager().beginTransaction().replace(R.id.content, new HomeFragment()).commit();
    }

    private void initializationVariable () {
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
    }

    private void initializationEvent () {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        disableShiftMode(navigation);
    }
}
