package com.indah.tanyajava.fragments;

import android.content.Intent;
import android.os.Bundle;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.indah.tanyajava.R;

public class ExploreFragment extends Fragment {

    LinearLayout layout_koridor1, layout_koridor2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        layout_koridor1 = view.findViewById(R.id.layout_koridor1);
        layout_koridor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Koridor1Fragment koridor1Fragment = new Koridor1Fragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, koridor1Fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        layout_koridor2 = view.findViewById(R.id.layout_koridor2);
        layout_koridor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Koridor2Fragment koridor2Fragment = new Koridor2Fragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, koridor2Fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}