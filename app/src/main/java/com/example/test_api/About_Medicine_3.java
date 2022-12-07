package com.example.test_api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class About_Medicine_3 extends AppCompatActivity {
    Button back_addmedicine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_medicine3);

        back_addmedicine = findViewById(R.id.back_addmedicine);
        back_addmedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(About_Medicine_3.this,Add_medicine.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(About_Medicine_3.this, Add_medicine.class);
        startActivity(intent);
        finish();
    }
}