package com.example.test_api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class Choose_Appointment_EN extends AppCompatActivity {
    Spinner spinner11;
    ArrayList<String> arrayList_Spinner11;
    ArrayAdapter<String> arrayAdapter_Spinner11;
    Button nexten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_appointment_en);
        Spinner Spinner11 = findViewById(R.id.spinner11);
        arrayList_Spinner11 = new ArrayList<>();
        arrayList_Spinner11.add("Wound Dressing Appointment");
        arrayList_Spinner11.add("Surgery Appointment");
        arrayList_Spinner11.add("Vaccine Appointment");
        arrayList_Spinner11.add("Follow-up Appointment");
        arrayList_Spinner11.add("Blood test Appointment");
        arrayList_Spinner11.add("Surgical Suture");
        arrayAdapter_Spinner11 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_Spinner11);
        Spinner11.setAdapter(arrayAdapter_Spinner11);

        nexten = findViewById(R.id.nexten);
        nexten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Choose_Appointment_EN.this,Appointment_EN.class);
                startActivity(i);
                finish();
            }
        });
    }
}