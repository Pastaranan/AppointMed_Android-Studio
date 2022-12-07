package com.example.test_api;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Add_appointment extends AppCompatActivity {
    Button add_appointment,bt_search,bt_notication;
//    LinearLayout hospitala,hospitalb;
    LinearLayout appoint_hos_1,appoint_hos_2,appoint_hos_3,appoint_hos_4,appoint_hos_5,appoint_hos_6;
    Dialog myDialog;

    LinearLayout linear_hos_1,linear_hos_2,linear_hos_3,linear_hos_4,linear_hos_5,linear_hos_6;

    public static boolean loop_appointmed = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment);

        bt_search = findViewById(R.id.bt_search);
        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "อยู่ระหว่างการพัฒนา", Toast.LENGTH_SHORT);
            }
        });

        bt_notication = findViewById(R.id.bt_notication);
        bt_notication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "อยู่ระหว่างการพัฒนา", Toast.LENGTH_SHORT);
            }
        });

        myDialog = new Dialog(this);

        linear_hos_1 = findViewById(R.id.linear_hos_1);
        linear_hos_2 = findViewById(R.id.linear_hos_2);
        linear_hos_3 = findViewById(R.id.linear_hos_3);
        linear_hos_4 = findViewById(R.id.linear_hos_4);
        linear_hos_5 = findViewById(R.id.linear_hos_5);
        linear_hos_6 = findViewById(R.id.linear_hos_6);

        // get_appointmed_loop
        Thread thread_r = new Thread(new Runnable() {
            @Override
            public void run() {
                while (loop_appointmed)
                {
                    try {
                        get_appointmed();
                        Thread.sleep(2000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread_r.start();

        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayouta);
        findViewById(R.id.imagenavi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

        findViewById(R.id.bt_user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.END);
            }
        });
        NavigationView navigationright = findViewById(R.id.navigationright);
        navigationright.setItemIconTintList(null);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.ap);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        finish();
                        overridePendingTransition(0,0);
                        return false;
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

        add_appointment = findViewById(R.id.add_appointment);
        add_appointment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                popup_appoint_old_new();
//                Intent i = new Intent(Add_appointment.this,Choose_appointment.class);
//                startActivity(i);
//                finish();
            }
        });

        appoint_hos_1 = (LinearLayout)findViewById(R.id.appoint_hos_1);
        appoint_hos_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Add_appointment.this,About_Appointment.class);
                startActivity(i);
                finish();
            }
        });

        appoint_hos_2 = (LinearLayout) findViewById(R.id.appoint_hos_2);
        appoint_hos_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Add_appointment.this,About_Appointment2.class);
                startActivity(i);
                finish();
            }
        });

        appoint_hos_3 = (LinearLayout) findViewById(R.id.appoint_hos_3);
        appoint_hos_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Add_appointment.this,About_Appointment.class);
                startActivity(i);
                finish();
            }
        });

        appoint_hos_4 = (LinearLayout) findViewById(R.id.appoint_hos_4);
        appoint_hos_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Add_appointment.this,About_Appointment.class);
                startActivity(i);
                finish();
            }
        });

        appoint_hos_5 = (LinearLayout) findViewById(R.id.appoint_hos_5);
        appoint_hos_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Add_appointment.this,About_Appointment.class);
                startActivity(i);
                finish();
            }
        });

        appoint_hos_6 = (LinearLayout) findViewById(R.id.appoint_hos_6);
        appoint_hos_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Add_appointment.this,About_Appointment.class);
                startActivity(i);
                finish();
            }
        });
    }


    private void get_appointmed() {
        final String url = "http://iiec2312.trueddns.com:19744/appointments";
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        try
                        {   JSONArray jsonArray_robot = response.getJSONArray("data");

                            if ( jsonArray_robot.length() <= 0 )
                            {
                                linear_hos_1.setVisibility(View.INVISIBLE);
                                linear_hos_2.setVisibility(View.INVISIBLE);
                                linear_hos_3.setVisibility(View.INVISIBLE);
                                linear_hos_4.setVisibility(View.INVISIBLE);
                                linear_hos_5.setVisibility(View.INVISIBLE);
                                linear_hos_6.setVisibility(View.INVISIBLE);
                            }

                            else if ( jsonArray_robot.length() == 1 )
                            {
                                linear_hos_1.setVisibility(View.VISIBLE);
                                linear_hos_2.setVisibility(View.INVISIBLE);
                                linear_hos_3.setVisibility(View.INVISIBLE);
                                linear_hos_4.setVisibility(View.INVISIBLE);
                                linear_hos_5.setVisibility(View.INVISIBLE);
                                linear_hos_6.setVisibility(View.INVISIBLE);
                            }

                            else if ( jsonArray_robot.length() == 2 )
                            {
                                linear_hos_2.setVisibility(View.VISIBLE);
                                linear_hos_1.setVisibility(View.VISIBLE);
                                linear_hos_3.setVisibility(View.INVISIBLE);
                                linear_hos_4.setVisibility(View.INVISIBLE);
                                linear_hos_5.setVisibility(View.INVISIBLE);
                                linear_hos_6.setVisibility(View.INVISIBLE);

                            }

                            else if ( jsonArray_robot.length() == 3 )
                            {
                                linear_hos_1.setVisibility(View.VISIBLE);
                                linear_hos_2.setVisibility(View.VISIBLE);
                                linear_hos_3.setVisibility(View.VISIBLE);
                                linear_hos_4.setVisibility(View.INVISIBLE);
                                linear_hos_5.setVisibility(View.INVISIBLE);
                                linear_hos_6.setVisibility(View.INVISIBLE);
                            }

                            else if ( jsonArray_robot.length() == 4 )
                            {
                                linear_hos_1.setVisibility(View.VISIBLE);
                                linear_hos_2.setVisibility(View.VISIBLE);
                                linear_hos_3.setVisibility(View.VISIBLE);
                                linear_hos_4.setVisibility(View.VISIBLE);
                                linear_hos_5.setVisibility(View.INVISIBLE);
                                linear_hos_6.setVisibility(View.INVISIBLE);
                            }

                            else if ( jsonArray_robot.length() == 5 )
                            {
                                linear_hos_1.setVisibility(View.VISIBLE);
                                linear_hos_2.setVisibility(View.VISIBLE);
                                linear_hos_3.setVisibility(View.VISIBLE);
                                linear_hos_4.setVisibility(View.VISIBLE);
                                linear_hos_5.setVisibility(View.VISIBLE);
                                linear_hos_6.setVisibility(View.INVISIBLE);
                            }

                            else if ( jsonArray_robot.length() == 6 )
                            {
                                linear_hos_1.setVisibility(View.VISIBLE);
                                linear_hos_2.setVisibility(View.VISIBLE);
                                linear_hos_3.setVisibility(View.VISIBLE);
                                linear_hos_4.setVisibility(View.VISIBLE);
                                linear_hos_5.setVisibility(View.VISIBLE);
                                linear_hos_6.setVisibility(View.VISIBLE);
                            }
                        }

                        catch (JSONException e)
                        {
                            e.printStackTrace();
                            finish();
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        );
        queue.add(getRequest);
    }


    private void popup_appoint_old_new() {myDialog.setContentView(R.layout.activity_popup_appointment);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView new_appointment = myDialog.findViewById(R.id.new_appointment);
        new_appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Add_appointment.this,Choose_appointment.class);
                startActivity(i);
                finish();
            }
        });

        TextView continue_appointment = myDialog.findViewById(R.id.continue_appointment);
        continue_appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Add_appointment.this,Appointment_continue.class);
                startActivity(i);
                finish();
            }
        });
        myDialog.show();
    }

    @Override
    public void onBackPressed() {
    }
}