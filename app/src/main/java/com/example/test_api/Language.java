package com.example.test_api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Language extends AppCompatActivity {
    Button back_to_menu;
    RadioButton thai,eng;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);


        back_to_menu = findViewById(R.id.back_to_menu);
        back_to_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (thai.isChecked()){
                Intent i = new Intent(Language.this,Menu.class);
                startActivity(i);
                finish();}
                else {
                    Intent i = new Intent(Language.this,Choose_Appointment_EN.class);
                    startActivity(i);
                    finish();}
            }
        });
        thai = findViewById(R.id.thai);
        eng =findViewById(R.id.eng);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Language.this, Menu.class);
        startActivity(intent);
        finish();
    }
}