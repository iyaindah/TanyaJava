package com.indah.tanyajava.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.indah.tanyajava.R;

public class SelectTypeUser extends AppCompatActivity {

    RelativeLayout driverContainer, passangerContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_type_user);

        driverContainer = findViewById(R.id.driver_container);
        passangerContainer = findViewById(R.id.passanger_container);

        driverContainer.setOnClickListener(view -> {
            startActivity(new Intent(SelectTypeUser.this, LoginDriver.class));
        });

        passangerContainer.setOnClickListener(view -> {
            startActivity(new Intent(SelectTypeUser.this, LoginPassanger.class));
        });
    }
}