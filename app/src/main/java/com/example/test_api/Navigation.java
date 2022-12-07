package com.example.test_api;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Navigation extends AppCompatActivity {
    LinearLayout hospitala,hospitalb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation);
        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        findViewById(R.id.imagenavi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.ap);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        finish();
                        overridePendingTransition(0,0);
                        return false;
                    case R.id.medi:
                        startActivity(new Intent(getApplicationContext(),Add_medicine.class));
                        finish();
                        overridePendingTransition(0,0);
                        return false;
                    case R.id.other:
                        startActivity(new Intent(getApplicationContext(),Menu.class));
                        finish();
                        overridePendingTransition(0,2);
                        return false;
                }
                return false;
            }
        });



        hospitala = (LinearLayout)findViewById(R.id.hospitala);
        hospitala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Navigation.this,About_Appointment.class);
                startActivity(i);
                finish();
            }
        });

        hospitalb = (LinearLayout) findViewById(R.id.hospitalb);
        hospitalb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Navigation.this,About_Appointment2.class);
                startActivity(i);
                finish();
            }
        });
    }
}