package com.example.test_api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Appointment_continue extends AppCompatActivity {
    Button hos_A_ap_1,hos_A_ap_2,hos_B_ap_1,hos_C_ap_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_continue);

        hos_A_ap_1 = findViewById(R.id.hos_A_ap_1);
        hos_A_ap_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Appointment_continue.this, Appointment_continuously_hosa_1.class);
                startActivity(intent);
                finish();
            }
        });

        hos_A_ap_2 = findViewById(R.id.hos_A_ap_2);
        hos_A_ap_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Appointment_continue.this, Appointment_continuously_hosa_2.class);
                startActivity(intent);
                finish();
            }
        });

        hos_B_ap_1= findViewById(R.id.hos_B_ap_1);
        hos_B_ap_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "อยู่ระหว่าการพัฒนา", Toast.LENGTH_SHORT).show();
            }
        });
        hos_C_ap_1= findViewById(R.id.hos_C_ap_1);
        hos_C_ap_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "อยู่ระหว่าการพัฒนา", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Appointment_continue.this, Add_appointment.class);
        startActivity(intent);
        finish();
    }
}