package com.example.test_api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class About_Caretaker extends AppCompatActivity {
    Button opencalendar,backcare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_caretaker);
        opencalendar = findViewById(R.id.opencalendar);
        opencalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(About_Caretaker.this,Add_Caretaker.class);
                startActivity(intent);
                finish();
                ComponentName cn;
                Intent i = new Intent(Intent.ACTION_VIEW);
                cn = new ComponentName("com.google.android.calendar", "com.android.calendar.LaunchActivity");
                i.setComponent(cn);
                startActivity(i);
            }
        });

        backcare = findViewById(R.id.backcare);
        backcare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(About_Caretaker.this,Add_Caretaker.class);
                startActivity(i);
                finish();
            }
        });


    }
}