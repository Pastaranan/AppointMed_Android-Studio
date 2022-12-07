package com.example.test_api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class About_Appointment_EN extends AppCompatActivity {
    Button back_addappointen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_appointment_en);

        back_addappointen = findViewById(R.id.back_addappointen);

        back_addappointen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(About_Appointment_EN.this,Language.class);
                startActivity(i);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(About_Appointment_EN.this,Language.class);
        startActivity(intent);
        finish();
    }
}