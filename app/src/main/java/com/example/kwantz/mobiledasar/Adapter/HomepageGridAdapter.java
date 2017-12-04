package com.example.kwantz.mobiledasar.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kwantz.mobiledasar.Model.Feature;
import com.example.kwantz.mobiledasar.R;

import java.util.ArrayList;

public class HomepageGridAdapter extends BaseAdapter {
    private final Context mContext;
    private final ArrayList<Feature> features;

    public HomepageGridAdapter(Context context) {
        this.mContext = context;
        this.features = new ArrayList<>();

        this.features.add(new Feature("BUKALAPAK\nCREDITS", R.drawable.icon9));
        this.features.add(new Feature("PULSA", R.drawable.icon10));
        this.features.add(new Feature("PAKET DATA", R.drawable.icon12));
        this.features.add(new Feature("LISTRIK", R.drawable.icon11));
        this.features.add(new Feature("KERETA", R.drawable.icon14));
        this.features.add(new Feature("PESAWAT", R.drawable.icon13));
        this.features.add(new Feature("BUKAEMAS", R.drawable.icon16));
        this.features.add(new Feature("ZAKAT PROFESI", R.drawable.icon11));
    }

    @Override
    public int getCount() {
        return features.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Feature feature = this.features.get(position);

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.fragment_feature, null);
        }

        final ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
        final TextView title = (TextView) convertView.findViewById(R.id.title);

        icon.setImageResource(feature.getIcon());
        title.setText(feature.getTitle());

        return convertView;
    }
}
