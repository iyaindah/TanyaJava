package com.indah.tanyajava.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.indah.tanyajava.R;


public class SuccessScanFragment extends Fragment {

    TextView txt_beli, txt_scan;
    Button btn_ticket_history;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_success_scan, container, false);

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