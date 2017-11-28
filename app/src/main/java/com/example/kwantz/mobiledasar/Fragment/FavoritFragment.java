package com.example.kwantz.mobiledasar.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kwantz.mobiledasar.R;

public class FavoritFragment extends Fragment {

    private View view;
    private ImageView notifBtn, chatBtn;

    public FavoritFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initializationVariable();
        initializationEvent();

        return view;
    }

    private void initializationVariable () {
        notifBtn = (ImageView) view.findViewById(R.id.btn_notif);
        chatBtn = (ImageView) view.findViewById(R.id.btn_chat);
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
    }
}
