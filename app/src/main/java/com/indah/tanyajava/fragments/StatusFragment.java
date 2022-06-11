package com.indah.tanyajava.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.indah.tanyajava.R;

public class StatusFragment extends Fragment {

    TextView txt_beli;
    ImageView barcode_stts;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_status, container, false);

        txt_beli = view.findViewById(R.id.txt_beli);
        txt_beli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TicketFragment ticketFragment = new TicketFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, ticketFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        barcode_stts = view.findViewById(R.id.barcode_stts);
        barcode_stts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BarcodePassengerFragment barcodePassengerFragment = new BarcodePassengerFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, barcodePassengerFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}