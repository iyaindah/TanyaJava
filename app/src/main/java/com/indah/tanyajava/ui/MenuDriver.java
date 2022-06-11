package com.indah.tanyajava.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.indah.tanyajava.R;
import com.indah.tanyajava.fragments.AccountDriverFragment;
import com.indah.tanyajava.fragments.BusDriverFragment;
import com.indah.tanyajava.fragments.TicketDriverFragment;
import com.indah.tanyajava.fragments.TicketFragment;

public class MenuDriver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_driver);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentD_container,
                    new BusDriverFragment()).commit();
        }

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.menu_bus_driver:
                            selectedFragment = new BusDriverFragment();
                            break;
                        case R.id.menu_ticket:
                            selectedFragment = new TicketDriverFragment();
                            break;
                        case R.id.menu_account:
                            selectedFragment = new AccountDriverFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentD_container,
                            selectedFragment).commit();

                    return true;
                }
            };
}