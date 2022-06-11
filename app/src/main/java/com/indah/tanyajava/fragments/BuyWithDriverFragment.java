package com.indah.tanyajava.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.indah.tanyajava.R;

public class BuyWithDriverFragment extends Fragment {

    TextView txt_scan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buy_with_driver, container, false);

        txt_scan = view.findViewById(R.id.txt_scan);
        txt_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TicketDriverFragment ticketDriverFragment = new TicketDriverFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentD_container, ticketDriverFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}