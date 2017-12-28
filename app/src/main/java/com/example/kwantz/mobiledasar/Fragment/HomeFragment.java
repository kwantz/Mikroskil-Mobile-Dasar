package com.example.kwantz.mobiledasar.Fragment;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kwantz.mobiledasar.Adapter.HomepageGridAdapter;
import com.example.kwantz.mobiledasar.DetailActivity;
import com.example.kwantz.mobiledasar.R;
import com.example.kwantz.mobiledasar.SearchActivity;

public class HomeFragment extends Fragment {

    private View view;
    private LinearLayout search, barang1, barang2, barang3, barang4, barang5, barang6;
    private ImageView notifBtn, chatBtn;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initializationVariable();
        initializationEvent();

        return view;
    }

    private void initializationVariable () {
        notifBtn = (ImageView) view.findViewById(R.id.btn_notif);
        chatBtn = (ImageView) view.findViewById(R.id.btn_chat);
        search = (LinearLayout) view.findViewById(R.id.search);
        barang1 = (LinearLayout) view.findViewById(R.id.barang1);
        barang2 = (LinearLayout) view.findViewById(R.id.barang2);
        barang3 = (LinearLayout) view.findViewById(R.id.barang3);
        barang4 = (LinearLayout) view.findViewById(R.id.barang4);
        barang5 = (LinearLayout) view.findViewById(R.id.barang5);
        barang6 = (LinearLayout) view.findViewById(R.id.barang6);
    }

    private void initializationEvent () {
        notifBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick (View view) {
                Toast toast = Toast.makeText(getActivity(), "Notifikasi", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            }
        });

        chatBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick (View view) {
                Toast toast = Toast.makeText(getActivity(), "Chat", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                getContext().startActivity(intent);
            }
        });

        barang1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("Posisi", Integer.toString(0));
                view.getContext().startActivity(intent);
            }
        });

        barang2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("Posisi", Integer.toString(1));
                view.getContext().startActivity(intent);
            }
        });

        barang3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("Posisi", Integer.toString(2));
                view.getContext().startActivity(intent);
            }
        });

        barang4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("Posisi", Integer.toString(3));
                view.getContext().startActivity(intent);
            }
        });

        barang5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("Posisi", Integer.toString(4));
                view.getContext().startActivity(intent);
            }
        });

        barang6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("Posisi", Integer.toString(5));
                view.getContext().startActivity(intent);
            }
        });
    }
}
