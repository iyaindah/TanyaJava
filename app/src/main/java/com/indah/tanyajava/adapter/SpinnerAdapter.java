package com.indah.tanyajava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.indah.tanyajava.R;

public class SpinnerAdapter extends BaseAdapter {
    String[] koridor;
    int[] imageBus;
    LayoutInflater layoutInflater;
    Context context;

    public SpinnerAdapter(String[] koridor, int[] imageBus, Context context) {
        this.koridor = koridor;
        this.imageBus = imageBus;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return koridor.length;
    }

    @Override
    public Object getItem(int i) {
        return koridor[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = layoutInflater.inflate(R.layout.koridor_layout, null);
        ImageView image = (ImageView) view.findViewById(R.id.spinner_image);
        TextView text = (TextView) view.findViewById(R.id.spinner_text);

        image.setImageResource(imageBus[i]);
        text.setText(koridor[i]);

        return view;
    }

}
