package com.example.kwantz.mobiledasar.Fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kwantz.mobiledasar.R;
import com.example.kwantz.mobiledasar.Transaksi.Fragment.PembelianFragment;
import com.example.kwantz.mobiledasar.Transaksi.Fragment.PenjualanFragment;
import com.example.kwantz.mobiledasar.Transaksi.Fragment.TagihanFragment;
import com.example.kwantz.mobiledasar.Transaksi.TransaksiPagerAdapter;

public class TransaksiFragment extends Fragment {

    private View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TransaksiPagerAdapter adapter;

    public TransaksiFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_transaksi, container, false);
        initializationVariable();
        initializationViewPager();

        return view;
    }

    private void initializationVariable () {
        viewPager = (ViewPager) view.findViewById(R.id.pager);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);

    }

    private  void initializationViewPager () {
        Log.e("Testing - 1", Boolean.toString(adapter == null) );
        adapter = new TransaksiPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new TagihanFragment(), "TAGIHAN");
        adapter.addFragment(new PembelianFragment(), "PEMBELIAN");
        adapter.addFragment(new PenjualanFragment(), "PENJUALAN");
        Log.e("Testing - 2", Boolean.toString(adapter == null) );

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
