package com.indah.tanyajava.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.maps.MapFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.indah.tanyajava.R;
import com.indah.tanyajava.fragments.AccountFragment;
import com.indah.tanyajava.fragments.ExploreFragment;
import com.indah.tanyajava.fragments.TicketFragment;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ExploreFragment()).commit();
        }

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.menu_explore:
                            selectedFragment = new ExploreFragment();
                            break;
                        case R.id.menu_ticket:
                            selectedFragment = new TicketFragment();
                            break;
                        case R.id.menu_account:
                            selectedFragment = new AccountFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };
}