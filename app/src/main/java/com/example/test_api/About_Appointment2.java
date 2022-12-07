package com.example.test_api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class About_Appointment2 extends AppCompatActivity {
    Button back_addappointb,Navigation_B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_appointment2);
        back_addappointb = findViewById(R.id.back_addappointb);
        back_addappointb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(About_Appointment2.this,Add_appointment.class);
                startActivity(i);
                finish();
            }
        });

        Navigation_B = findViewById(R.id.Navigation_B);
        Navigation_B.setOnClickListener(new View.OnClickListener() {
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
        Intent intent = new Intent(About_Appointment2.this, Add_appointment.class);
        startActivity(intent);
        finish();
    }
}