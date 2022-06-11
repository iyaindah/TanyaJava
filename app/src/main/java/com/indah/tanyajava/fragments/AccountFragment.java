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
import com.indah.tanyajava.ui.SelectTypeUser;

public class AccountFragment extends Fragment {

    Button btnLogout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_account, container, false);

        btnLogout = view.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountFragment.this.getActivity(), SelectTypeUser.class);
                startActivity(intent);
                Toast.makeText(view.getContext(), "Successful Logout", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}