package com.example.test_api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Appointment_EN extends AppCompatActivity {
    Button next_appoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_en);

        next_appoint = findViewById(R.id.next_appoint);
        next_appoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Appointment_EN.this,About_Appointment_EN.class);
                startActivity(i);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
    }
}