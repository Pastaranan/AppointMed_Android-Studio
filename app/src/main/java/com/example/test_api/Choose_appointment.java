package com.example.test_api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class Choose_appointment extends AppCompatActivity {
    Spinner spinner1;
    Button next_appointment,backapoint;
    ArrayList<String> arrayList_Spinner1;
    ArrayAdapter<String> arrayAdapter_Spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_appointment);
        Spinner Spinner1 = findViewById(R.id.spinner1);
        arrayList_Spinner1 = new ArrayList<>();
        arrayList_Spinner1.add("ใบนัดทำแผล");
        arrayList_Spinner1.add("ใบนัดผ่าตัด");
        arrayList_Spinner1.add("ใบนัดฉีดวัคซีน");
        arrayList_Spinner1.add("ใบนัดตรวจติดตาม");
        arrayList_Spinner1.add("ใบนัดตรวจเลือด");
        arrayList_Spinner1.add("ใบนัดตัดไหม");
        arrayAdapter_Spinner1 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_Spinner1);
        Spinner1.setAdapter(arrayAdapter_Spinner1);

        next_appointment = findViewById(R.id.next);
        next_appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Choose_appointment.this,Appointment.class);
                startActivity(i);
                finish();
            }
        });

        backapoint = findViewById(R.id.back);
        backapoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Choose_appointment.this,Add_appointment.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Choose_appointment.this, Add_appointment.class);
        startActivity(intent);
        finish();
    }
}