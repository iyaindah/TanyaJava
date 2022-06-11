package com.indah.tanyajava.fragments;

import android.content.Intent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.indah.tanyajava.R;
import com.indah.tanyajava.ui.DriverPredictActivity;

public class BusDriverFragment extends Fragment {
    Button btn_predict;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bus_driver, container, false);

        btn_predict = view.findViewById(R.id.btn_predict);
        btn_predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BusDriverFragment.this.getActivity(), DriverPredictActivity.class);
                startActivity(intent);
                Toast.makeText(view.getContext(), "Successful click", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}