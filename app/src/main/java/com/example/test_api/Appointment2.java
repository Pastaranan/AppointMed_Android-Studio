package com.example.test_api;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Appointment2 extends AppCompatActivity {
    Button backchoose,next_appoint;
    EditText notidate;
    TextView Dateappointment,Timeappointment;
    int year;
    int month;
    int day;
    int hour;
    int minute;
    public static int year_e,year_s;
    public static int month_e,month_s;
    public static int day_e,day_s;
    public static int hour_s;
    public static int minute_s;

    public static String Pt_HN,Pt_name,Appointment_type, Hos_name, Hos_department, Doc_name, Day_appoint, Time_appoint;

    private long backPressedTime;
    private Toast backToast;

    Spinner Spinner2,Spinner3,Spinner9;
    ArrayList<String> arrayList_Spinner2;
    ArrayList<String> arrayList_Spinner3;
    ArrayAdapter<String> arrayAdapter_Spinner2;
    ArrayAdapter<String> arrayAdapter_Spinner3;
    ArrayList<String> arrayList_Spinner9;
    ArrayAdapter<String> arrayAdapter_Spinner9;
    EditText Name,HN,Docter;
    String location;
    long startMillis = 0;
    long endMillis = 0;
    TextView title;
    String A;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        backchoose = findViewById(R.id.backchoose);
        backchoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Appointment2.this,Choose_appointment.class);
                startActivity(i);
                finish();
            }
        });

        Dateappointment = findViewById(R.id.Dateappointment);
        final Calendar calendar = Calendar.getInstance();
        Dateappointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(Appointment2.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month,int  dayOfMonth)
                    {
                        year_s = year;
                        month_s = month;
                        day_s = dayOfMonth;

                        String date1 = "  "+ dayOfMonth + "/" + month + "/" + year;
                        Dateappointment.setText(date1);

                        //post
                        Day_appoint = Dateappointment.getText().toString();
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        Timeappointment = findViewById(R.id.Timeappointment);
        Timeappointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hour = calendar.get(Calendar.HOUR_OF_DAY);
                minute = calendar.get(Calendar.MINUTE);
                TimePickerDialog TimePicker = new TimePickerDialog(Appointment2.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        hour_s = selectedHour;
                        minute_s = selectedMinute;
                        Timeappointment.setText(selectedHour + ":" + selectedMinute);

                        //post
                        Time_appoint = Timeappointment.getText().toString() ;
                    }

                },hour, minute, true);
                TimePicker.show();
            }
        });

        Spinner Spinner2 = findViewById(R.id.Spinner2);
        Spinner Spinner3 = findViewById(R.id.Spinner3);
        Spinner Spinner9 = findViewById(R.id.Spinner9);

        arrayList_Spinner2 = new ArrayList<>();
        arrayList_Spinner2.add("โรงพยาบาล A");
        arrayList_Spinner2.add("โรงพยาบาล B");
        arrayList_Spinner2.add("โรงพยาบาล C");
        arrayAdapter_Spinner2 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_Spinner2);
        Spinner2.setAdapter(arrayAdapter_Spinner2);

        arrayList_Spinner3 = new ArrayList<>();
        arrayList_Spinner3.add("อายุรกรรม");
        arrayList_Spinner3.add("ฉุกเฉิน");
        arrayAdapter_Spinner3 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_Spinner3);
        Spinner3.setAdapter(arrayAdapter_Spinner3);

        arrayList_Spinner9 = new ArrayList<>();
        arrayList_Spinner9.add("ก่อน 1 สัปดาห์");
        arrayList_Spinner9.add("1 วัน");
        arrayList_Spinner9.add("30 นาที");
        arrayAdapter_Spinner9 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_Spinner9);
        Spinner9.setAdapter(arrayAdapter_Spinner9);

        Name = findViewById(R.id.Name);
        HN = findViewById(R.id.HN);
        Docter = findViewById(R.id.Docter);
        title = findViewById(R.id.title);




        next_appoint = findViewById(R.id.next_appoint);
        next_appoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //////////////-------post
                Appointment_type = title.getText().toString();
                Hos_name = Spinner2.getSelectedItem().toString();
                Hos_department = Spinner3.getSelectedItem().toString();

                Pt_HN = HN.getText().toString();
                Pt_name = Name.getText().toString();
                Doc_name = Docter.getText().toString();
                //-----------------------------


                Intent intent = new Intent(getApplicationContext(),About_Appointment.class);
                startActivity(intent);
                finish();

                post_data_appointment();

                Calendar beginTime = Calendar.getInstance();
                beginTime.set(year_s, month_s, day_s, hour_s, minute_s);
                startMillis = beginTime.getTimeInMillis();
                Calendar endTime = Calendar.getInstance();
                endTime.set(year_s, month_s, day_s, hour_s, minute_s);
                endMillis= endTime.getTimeInMillis();

                ComponentName cn;
                Intent i = new Intent(Intent.ACTION_INSERT);
                cn = new ComponentName("com.google.android.calendar", "com.android.calendar.LaunchActivity");
                i.setComponent(cn);
                i.setData(CalendarContract.CONTENT_URI);
                i.putExtra(CalendarContract.Events.TITLE,title.getText().toString());
                i.putExtra(CalendarContract.Events.EVENT_LOCATION,"โรงพยาบาลเจริญกรุงประชารักษ์"+" , "+Spinner3.getSelectedItem().toString());
                i.putExtra(CalendarContract.Events.DESCRIPTION,"HN : "+HN.getText().toString()+" ,ชื่อ :  "+Name.getText().toString()+",แพทย์ผู้นัด : "+ Docter.getText().toString());
                i.putExtra("beginTime",startMillis);
                i.putExtra("endTime", endMillis);
                startActivity(i);
            }
        });
    }

    private void post_data_appointment() {

        StringRequest jsonObjRequest = new StringRequest(Request.Method.POST,"http://iiec2312.trueddns.com:19744/appointment",
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) { Log.i("Response", response);
                        System.out.println(response);
                    }
                },

                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d("volley", "Error: " + error.getMessage());
                        error.printStackTrace();
                        Log.d("Error.Response", "Unsuccess");
                    }
                }
        )

        {
            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                params.put("Pt_HN",Pt_HN);
                params.put("Appointment_type", Appointment_type);
                params.put("Pt_name",Pt_name);
                params.put("Doc_name", Doc_name);
                params.put("Hos_name", Hos_name);
                params.put("Hos_department", Hos_department);
                params.put("Time_appoint", Time_appoint);
                params.put("Day_appoint", Day_appoint);
                return params;
            }
        };
        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        queue.add(jsonObjRequest);
    }


    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis())
        {
            Intent intent = new Intent(getApplicationContext(),Add_appointment.class);
            startActivity(intent);
            finish();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "กดอีกครั้งเพื่อกลับ", Toast.LENGTH_SHORT);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }
}