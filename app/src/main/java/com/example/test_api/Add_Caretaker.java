package com.example.test_api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Add_Caretaker extends AppCompatActivity {
    Button add_caretaker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_caretaker);

        add_caretaker = findViewById(R.id.add_caretaker);
        add_caretaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Add_Caretaker.this,Caretaker.class);
                startActivity(i);
                finish();
            }
        });
    }
}