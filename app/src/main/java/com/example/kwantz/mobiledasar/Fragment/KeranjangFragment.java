package com.example.kwantz.mobiledasar.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kwantz.mobiledasar.DeliveryActivity;
import com.example.kwantz.mobiledasar.R;

public class KeranjangFragment extends Fragment {

    public KeranjangFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_keranjang, container, false);
        View rootView = inflater.inflate(R.layout.fragment_keranjang, container, false);

        Button btnLanjut = (Button) rootView.findViewById(R.id.btn_lanjut);
        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DeliveryActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

}
