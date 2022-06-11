package com.indah.tanyajava.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.indah.tanyajava.R;
import com.indah.tanyajava.ui.MenuActivity;

public class TicketFragment extends Fragment {
    View view;
    TextView txt_status, txt_beli;
    Button btncheckout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_ticket, container, false);

        txt_status = view.findViewById(R.id.txt_status);
        txt_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StatusFragment statusFragment = new StatusFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, statusFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        btncheckout = view.findViewById(R.id.btncheckout);
        btncheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckoutFragment checkoutFragment = new CheckoutFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, checkoutFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        return view;
    }
}