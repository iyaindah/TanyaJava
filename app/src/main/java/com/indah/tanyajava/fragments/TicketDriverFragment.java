package com.indah.tanyajava.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.indah.tanyajava.R;

public class TicketDriverFragment extends Fragment {

    ImageView img_scan;
    TextView txt_beli;
    Button btn_ticket_history;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ticket_driver, container, false);

        img_scan = view.findViewById(R.id.img_scan);
        img_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SuccessScanFragment successScanFragment = new SuccessScanFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentD_container, successScanFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        txt_beli = view.findViewById(R.id.txt_beli);
        txt_beli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BuyWithDriverFragment buyWithDriverFragment = new BuyWithDriverFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentD_container, buyWithDriverFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        btn_ticket_history = view.findViewById(R.id.btn_ticket_history);
        btn_ticket_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TicketDriverHistoryFragment ticketDriverHistoryFragment = new TicketDriverHistoryFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentD_container, ticketDriverHistoryFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        return view;
    }
}