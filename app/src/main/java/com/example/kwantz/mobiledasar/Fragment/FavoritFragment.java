package com.example.kwantz.mobiledasar.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kwantz.mobiledasar.DetailActivity;
import com.example.kwantz.mobiledasar.R;
import com.example.kwantz.mobiledasar.SearchActivity;

public class FavoritFragment extends Fragment {

    private View view;
    private ImageView notifBtn, chatBtn;
    private LinearLayout barang1, barang5, search;

    public FavoritFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_favorit, container, false);
        initializationVariable();
        initializationEvent();

        return view;
    }

    private void initializationVariable () {
        notifBtn = view.findViewById(R.id.btn_notif);
        chatBtn = view.findViewById(R.id.btn_chat);
        barang1 = view.findViewById(R.id.barang1);
        barang5 = view.findViewById(R.id.barang5);
        search = view.findViewById(R.id.search);
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

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                getContext().startActivity(intent);
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

        barang1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("Posisi", Integer.toString(0));
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
    }
}
