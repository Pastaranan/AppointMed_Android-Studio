package com.example.test_api;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
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

public class Add_medicine extends AppCompatActivity {
    Button add_madicine,bt_search,bt_notication;

    public static boolean loop_medicines = true;

    LinearLayout medicine_list_1,medicine_list_2,medicine_list_3,medicine_list_4,medicine_list_5,medicine_list_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);
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

        medicine_list_1 = findViewById(R.id.medicine_list_1);
        medicine_list_2 = findViewById(R.id.medicine_list_2);
        medicine_list_3 = findViewById(R.id.medicine_list_3);
        medicine_list_4 = findViewById(R.id.medicine_list_4);
        medicine_list_5 = findViewById(R.id.medicine_list_5);
        medicine_list_6 = findViewById(R.id.medicine_list_6);

        // get_medicines_loop
        Thread thread_r = new Thread(new Runnable() {
            @Override
            public void run() {
                while (loop_medicines)
                {
                    try {
                        get_medicines();
                        Thread.sleep(1500);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread_r.start();

        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayoutm);
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
        bottomNavigationView.setSelectedItemId(R.id.medi);
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

        medicine_list_1 = (LinearLayout)findViewById(R.id.medicine_list_1);
        medicine_list_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Add_medicine.this,About_Medicine.class);
                startActivity(i);
                finish();
            }
        });

        medicine_list_2 = (LinearLayout)findViewById(R.id.medicine_list_2);
        medicine_list_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Add_medicine.this,About_Medicine_2.class);
                startActivity(i);
                finish();
            }
        });

        medicine_list_3 = (LinearLayout)findViewById(R.id.medicine_list_3);
        medicine_list_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Add_medicine.this,About_Medicine_3.class);
                startActivity(i);
                finish();
            }
        });

        medicine_list_4 = (LinearLayout)findViewById(R.id.medicine_list_4);
        medicine_list_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Add_medicine.this,About_Medicine.class);
                startActivity(i);
                finish();
            }
        });

        medicine_list_5 = (LinearLayout)findViewById(R.id.medicine_list_5);
        medicine_list_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Add_medicine.this,About_Medicine_2.class);
                startActivity(i);
                finish();
            }
        });

        medicine_list_6 = (LinearLayout)findViewById(R.id.medicine_list_6);
        medicine_list_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Add_medicine.this,About_Medicine_3.class);
                startActivity(i);
                finish();
            }
        });

        add_madicine = findViewById(R.id.add_madicine);
        add_madicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Add_medicine.this,Medicine.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void get_medicines() {
        final String url = "http://iiec2312.trueddns.com:19744/medicines";
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
                                medicine_list_1.setVisibility(View.INVISIBLE);
                                medicine_list_2.setVisibility(View.INVISIBLE);
                                medicine_list_3.setVisibility(View.INVISIBLE);
                                medicine_list_4.setVisibility(View.INVISIBLE);
                                medicine_list_5.setVisibility(View.INVISIBLE);
                                medicine_list_6.setVisibility(View.INVISIBLE);
                            }

                            else if ( jsonArray_robot.length() == 1 )
                            {
                                medicine_list_1.setVisibility(View.VISIBLE);
                                medicine_list_2.setVisibility(View.INVISIBLE);
                                medicine_list_3.setVisibility(View.INVISIBLE);
                                medicine_list_4.setVisibility(View.INVISIBLE);
                                medicine_list_5.setVisibility(View.INVISIBLE);
                                medicine_list_6.setVisibility(View.INVISIBLE);
                            }

                            else if ( jsonArray_robot.length() == 2 )
                            {
                                medicine_list_1.setVisibility(View.VISIBLE);
                                medicine_list_2.setVisibility(View.VISIBLE);
                                medicine_list_3.setVisibility(View.INVISIBLE);
                                medicine_list_4.setVisibility(View.INVISIBLE);
                                medicine_list_5.setVisibility(View.INVISIBLE);
                                medicine_list_6.setVisibility(View.INVISIBLE);

                            }

                            else if ( jsonArray_robot.length() == 3 )
                            {
                                medicine_list_1.setVisibility(View.VISIBLE);
                                medicine_list_2.setVisibility(View.VISIBLE);
                                medicine_list_3.setVisibility(View.VISIBLE);
                                medicine_list_4.setVisibility(View.INVISIBLE);
                                medicine_list_5.setVisibility(View.INVISIBLE);
                                medicine_list_6.setVisibility(View.INVISIBLE);
                            }

                            else if ( jsonArray_robot.length() == 4 )
                            {
                                medicine_list_1.setVisibility(View.VISIBLE);
                                medicine_list_2.setVisibility(View.VISIBLE);
                                medicine_list_3.setVisibility(View.VISIBLE);
                                medicine_list_4.setVisibility(View.VISIBLE);
                                medicine_list_5.setVisibility(View.INVISIBLE);
                                medicine_list_6.setVisibility(View.INVISIBLE);
                            }

                            else if ( jsonArray_robot.length() == 5 )
                            {
                                medicine_list_1.setVisibility(View.VISIBLE);
                                medicine_list_2.setVisibility(View.VISIBLE);
                                medicine_list_3.setVisibility(View.VISIBLE);
                                medicine_list_4.setVisibility(View.VISIBLE);
                                medicine_list_5.setVisibility(View.VISIBLE);
                                medicine_list_6.setVisibility(View.INVISIBLE);
                            }

                            else if ( jsonArray_robot.length() == 6 )
                            {
                                medicine_list_1.setVisibility(View.VISIBLE);
                                medicine_list_2.setVisibility(View.VISIBLE);
                                medicine_list_3.setVisibility(View.VISIBLE);
                                medicine_list_4.setVisibility(View.VISIBLE);
                                medicine_list_5.setVisibility(View.VISIBLE);
                                medicine_list_6.setVisibility(View.VISIBLE);
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




    @Override
    public void onBackPressed() {

    }
}