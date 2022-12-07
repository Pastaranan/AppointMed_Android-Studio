package com.example.test_api;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Menu extends AppCompatActivity {
    Button vital_signs,family,emergency,history,postpone,help,settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        vital_signs = findViewById(R.id.vital_signs);
        family = findViewById(R.id.family);
        emergency = findViewById(R.id.emergency);
        history = findViewById(R.id.history);
        postpone = findViewById(R.id.postpone);
        help = findViewById(R.id.help);
        settings = findViewById(R.id.settings);
        set_button_click();

        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayoutme);
        findViewById(R.id.imagenavi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

        findViewById(R.id.bt_user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.END);
            }
        });
        NavigationView navigationright = findViewById(R.id.navigationright);
        navigationright.setItemIconTintList(null);;


        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.other);
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
                    case R.id.ap:
                        startActivity(new Intent(getApplicationContext(),Add_appointment.class));
                        finish();
                        overridePendingTransition(0,0);
                        return false;
                    case R.id.other:
                        startActivity(new Intent(getApplicationContext(),Menu.class));
                        finish();
                        overridePendingTransition(0,0);
                        return false;
                }
                return false;
            }
        });
    }

    private void set_button_click() {
        vital_signs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this,Vital_Signs.class);
                startActivity(i);
                finish();
            }
        });

        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this,Add_Caretaker.class);
                startActivity(i);
                finish();
            }
        });

        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this,under_develope.class);
                startActivity(i);
                finish();
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this,record.class);
                startActivity(i);
                finish();
            }
        });

        postpone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this,under_develope.class);
                startActivity(i);
                finish();
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this,under_develope.class);
                startActivity(i);
                finish();
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this,Language.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}