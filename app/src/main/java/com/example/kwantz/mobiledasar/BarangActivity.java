package com.example.kwantz.mobiledasar;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.kwantz.mobiledasar.Adapter.BarangAdapter;
import com.example.kwantz.mobiledasar.Model.Barang;
import com.example.kwantz.mobiledasar.Model.ListBarang;
import com.example.kwantz.mobiledasar.Model.RiwayatKataKunci;

import java.util.ArrayList;

public class BarangActivity extends AppCompatActivity {
    private ArrayList<Barang> arrayBarang = new ArrayList<>();
    private RecyclerView grid;
    private ImageView back;
    private TextView input;
    private ProgressBar progress;
    private LinearLayout notFound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang);

        initializationVariable();
        getExtraIntent();
        GridRecycleViewWithBarangAdapter(grid, 2);
        initializationEvent();
    }

    private void initializationVariable () {
        grid = (RecyclerView) findViewById(R.id.grid);
        input = (TextView) findViewById(R.id.search_input);
        back = (ImageView) findViewById(R.id.back_btn);
        progress = (ProgressBar) findViewById(R.id.progress);
        notFound = (LinearLayout) findViewById(R.id.not_found);
    }

    private void initializationEvent () {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                onBackPressed();
            }
        });

        final Handler handler = new Handler();
        boolean ok = handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progress.setVisibility(View.GONE);
                if (arrayBarang.size() != 0)
                    grid.setVisibility(View.VISIBLE);
                else
                    notFound.setVisibility(View.VISIBLE);
            }
        }, 1000);
    }

    private void GridRecycleViewWithBarangAdapter (RecyclerView rv, int column) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, column);
        RecyclerView.Adapter adapter = new BarangAdapter(this.arrayBarang);

        rv.setLayoutManager(gridLayoutManager);
        rv.setAdapter(adapter);
    }

    private void getExtraIntent () {
        input.setText(getIntent().getExtras().getString("Input"));
        this.arrayBarang = ListBarang.getBarangWithTitle(input.getText().toString());

        RiwayatKataKunci.setKataKunci(input.getText().toString());
    }
}
