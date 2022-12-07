package com.example.test_api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class About_Appointment extends AppCompatActivity {
    Button back_addappoint,navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_appointment);

        back_addappoint = findViewById(R.id.back_addappoint);
        back_addappoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(About_Appointment.this,Add_appointment.class);
                startActivity(i);
                finish();
            }
        });

        navigation = findViewById(R.id.navigation);
        navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Uri uri = Uri.parse("https://www.google.co.in/maps/dir/"+"110 The Knowledge Exchange: KX, 1 Thanon Krung Thon Buri, Bang Lamphu Lang, Khlong San, Bangkok 10600"
                            +"/"+"Panyapiwat Institute of Management, ถนน แจ้งวัฒนะ ตำบลบางตลาด อำเภอปากเกร็ด นนทบุรี");
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                catch (ActivityNotFoundException e){

                }
            }
        });
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(About_Appointment.this, Add_appointment.class);
        startActivity(intent);
        finish();
    }
}

