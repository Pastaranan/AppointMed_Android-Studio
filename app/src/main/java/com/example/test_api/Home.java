package com.example.test_api;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class Home extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;
    LinearLayout hospitala,medicine_1;
    Button bt_search,bt_notication,buttonnextcare;
//    FloatingActionButton feb,feb1,feb2,feb3;
//
//    TextView text1, text2,text3;
//
//    Boolean isAllFabsVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);
        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(7)
                .build();
        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                //do something
            }
        });




        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayouth);
        findViewById(R.id.imagenavi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                drawerLayout.openDrawer(GravityCompat.START);

                ComponentName cn;
                Intent i = new Intent(Intent.ACTION_VIEW);
                cn = new ComponentName("com.google.android.calendar", "com.android.calendar.LaunchActivity");
                i.setComponent(cn);
                startActivity(i);
            }
        });
//        NavigationView navigationView = findViewById(R.id.navigationView);
//        navigationView.setItemIconTintList(null);

        findViewById(R.id.bt_user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.END);

            }
        });
        NavigationView navigationright = findViewById(R.id.navigationright);
//        navigationright .setItemIconTintList(null);



        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        finish();
                        overridePendingTransition(0,0);
                        return false;
                    case R.id.ap:
                        startActivity(new Intent(getApplicationContext(),Add_appointment.class));
                        finish();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.medi:
                        startActivity(new Intent(getApplicationContext(),Add_medicine.class));
                        finish();
                        overridePendingTransition(0,0);
                        return false;
                    case R.id.other:
                        startActivity(new Intent(getApplicationContext(),Menu.class));
                        finish();
                        overridePendingTransition(0,0);
                        return false;

                }
                return false;
            }
        });

        hospitala = findViewById(R.id.hospitala);
        hospitala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,About_Appointment.class);
                startActivity(i);
                finish();
            }
        });
        medicine_1 = findViewById(R.id.medicine_1);
        medicine_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,About_Medicine_3.class);
                startActivity(i);
                finish();
            }
        });

        bt_search = findViewById(R.id.bt_search);
        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "อยู่ระหว่างการพัฒนา", Toast.LENGTH_SHORT).show();
            }
        });

        bt_notication = findViewById(R.id.bt_notication);
        bt_notication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this,Notification.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "กดอีกครั้งเพื่อออก", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}