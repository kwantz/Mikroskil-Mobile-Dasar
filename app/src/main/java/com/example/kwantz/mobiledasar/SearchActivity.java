package com.example.kwantz.mobiledasar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kwantz.mobiledasar.Model.RiwayatKataKunci;
import com.example.kwantz.mobiledasar.Search.BarangAdapter;
import com.example.kwantz.mobiledasar.Search.SearchAdapter;
import com.example.kwantz.mobiledasar.Transaksi.Adapter.PembelianAdapter;

import org.w3c.dom.Text;

public class SearchActivity extends AppCompatActivity {
    private ImageView back;
    private EditText input;
    private RecyclerView rvKataKunci, rvRiwayatBarang;
    private TextView cari1, cari2, cari3, cari4, cari5, cari6, cari7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initializationVariable();
        LinearRecycleViewWithSearchAdapter(rvKataKunci);
        LinearRecycleViewWithBarangAdapter(rvRiwayatBarang);
        initializationEvent();
    }

    @Override
    protected void onStart() {
        super.onStart();
        LinearRecycleViewWithSearchAdapter(rvKataKunci);
        LinearRecycleViewWithBarangAdapter(rvRiwayatBarang);
    }

    private void initializationVariable () {
        cari1 = (TextView) findViewById(R.id.cari1);
        cari2 = (TextView) findViewById(R.id.cari2);
        cari3 = (TextView) findViewById(R.id.cari3);
        cari4 = (TextView) findViewById(R.id.cari4);
        cari5 = (TextView) findViewById(R.id.cari5);
        cari6 = (TextView) findViewById(R.id.cari6);
        cari7 = (TextView) findViewById(R.id.cari7);
        back = (ImageView) findViewById(R.id.back_btn);
        input = (EditText) findViewById(R.id.search_input);
        rvKataKunci = (RecyclerView) findViewById(R.id.kata_kunci);
        rvRiwayatBarang = (RecyclerView) findViewById(R.id.riwayat_barang);
    }

    private void LinearRecycleViewWithBarangAdapter (RecyclerView rv) {
        BarangAdapter adapter = new BarangAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically () { return false; }
        };

        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);
    }

    private void LinearRecycleViewWithSearchAdapter (RecyclerView rv) {
        SearchAdapter adapter = new SearchAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically () { return false; }
        };

        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);
    }

    private void initializationEvent () {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                onBackPressed();
            }
        });

        input.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_UP && keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {

                    InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                    if (!input.getText().toString().equals("")) {
                        Intent intent = new Intent(view.getContext(), BarangActivity.class);
                        intent.putExtra("Input", input.getText().toString());
                        view.getContext().startActivity(intent);
                    }
                }
                return false;
            }
        });

        cari1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), BarangActivity.class);
                intent.putExtra("Input", cari1.getText());
                view.getContext().startActivity(intent);
            }
        });

        cari2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), BarangActivity.class);
                intent.putExtra("Input", cari2.getText());
                view.getContext().startActivity(intent);
            }
        });

        cari3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), BarangActivity.class);
                intent.putExtra("Input", cari3.getText());
                view.getContext().startActivity(intent);
            }
        });

        cari4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), BarangActivity.class);
                intent.putExtra("Input", cari4.getText());
                view.getContext().startActivity(intent);
            }
        });

        cari5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), BarangActivity.class);
                intent.putExtra("Input", cari5.getText());
                view.getContext().startActivity(intent);
            }
        });

        cari6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), BarangActivity.class);
                intent.putExtra("Input", cari6.getText());
                view.getContext().startActivity(intent);
            }
        });

        cari7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), BarangActivity.class);
                intent.putExtra("Input", cari7.getText());
                view.getContext().startActivity(intent);
            }
        });
    }
}
