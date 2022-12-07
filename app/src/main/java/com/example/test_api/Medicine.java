package com.example.test_api;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
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

public class Medicine extends AppCompatActivity {
    Button backm,next_medicine;
    TextView Datemedicine,Timemedicine;
    EditText medicinename,Medicine_amount_box;
    ImageView imagemedicine;

    private static final int PERMISSION_CODE = 1000;
    private static final int IMAGE_CAPTURE_CODE = 1001;
    Uri image_uri;

    public static String Medicine_name, Medicine_amount, Alarm_time, Alarm_pill, Period_start, Period_length, Use_period, Use_kind;

    int year;
    int month;
    int day;
    int hour;
    int minute;
    long startMillis = 0;
    long endMillis = 0;
    public static int year_e;
    public static int month_e;
    public static int day_e;
    public static int hour_e;
    public static int minute_e;
    public static int year_s;
    public static int month_s;
    public static int day_s;
    public static int hour_s;
    public static int minute_s;

    Spinner Spinner4,Spinner5,Spinner6,Spinner7,Spinner8;
    ArrayList<String> arrayList_Spinner4;
    ArrayList<String> arrayList_Spinner5;
    ArrayList<String> arrayList_Spinner6;
    ArrayList<String> arrayList_Spinner7;
    ArrayList<String> arrayList_Spinner8;

    ArrayAdapter<String> arrayAdapter_Spinner4;
    ArrayAdapter<String> arrayAdapter_Spinner5;
    ArrayAdapter<String> arrayAdapter_Spinner6;
    ArrayAdapter<String> arrayAdapter_Spinner7;
    ArrayAdapter<String> arrayAdapter_Spinner8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        medicinename = findViewById(R.id.medicinename);
        Medicine_amount_box = findViewById(R.id.Medicine_amount_box);



        backm = findViewById(R.id.backm);
        backm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Medicine.this,Add_medicine.class);
                startActivity(i);
                finish();
            }
        });

        final Calendar calendar = Calendar.getInstance();
        Datemedicine = findViewById(R.id. Datemedicine);
        Datemedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(Medicine.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        year_s = year;
                        month_s = month;
                        day_s = dayOfMonth;

                        String date = "  "+ dayOfMonth + "/" + month + "/" + year;
                        Datemedicine.setText(date);

                        //post
                        Period_start = Datemedicine.getText().toString();

                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });


        Timemedicine = findViewById(R.id.Timemedicine);
        Timemedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hour = calendar.get(Calendar.HOUR_OF_DAY);
                minute = calendar.get(Calendar.MINUTE);
                TimePickerDialog TimePicker = new TimePickerDialog(Medicine.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(android.widget.TimePicker timePicker, int selectedHour, int selectedMinute) {
                        hour_s = selectedHour;
                        minute_s = selectedMinute;

                        Timemedicine.setText(selectedHour + ":" + selectedMinute);

                        //post
                        Alarm_time = Timemedicine.getText().toString() ;
                    }
                },hour, minute, true);
                TimePicker.show();
            }
        });

        Spinner Spinner4 = findViewById(R.id.Spinner4);
        Spinner Spinner5 = findViewById(R.id.Spinner5);
        Spinner Spinner6 = findViewById(R.id.Spinner6);
        Spinner Spinner7 = findViewById(R.id.Spinner7);
        Spinner Spinner8 = findViewById(R.id.Spinner8);

        arrayList_Spinner4 = new ArrayList<>();
        arrayList_Spinner4.add("1 ครั้ง/วัน");
        arrayList_Spinner4.add("2 ครั้ง/วัน");
        arrayList_Spinner4.add("3 ครั้ง/วัน");
        arrayAdapter_Spinner4 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_Spinner4);
        Spinner4.setAdapter(arrayAdapter_Spinner4);

        arrayList_Spinner5 = new ArrayList<>();
        arrayList_Spinner5.add("ครึ่งเม็ด");
        arrayList_Spinner5.add("1 เม็ด");
        arrayList_Spinner5.add("2 เม็ด");
        arrayAdapter_Spinner5 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_Spinner5);
        Spinner5.setAdapter(arrayAdapter_Spinner5);

        arrayList_Spinner6 = new ArrayList<>();
        arrayList_Spinner6.add("ต่อเนื่อง");
        arrayList_Spinner6.add("เมื่อมีอาการ");
        arrayList_Spinner6.add("1 สัปดาห์");
        arrayAdapter_Spinner6 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_Spinner6);
        Spinner6.setAdapter(arrayAdapter_Spinner6);

        arrayList_Spinner7 = new ArrayList<>();
        arrayList_Spinner7.add("1 ครั้ง/วัน");
        arrayList_Spinner7.add("2 ครั้ง/วัน");
        arrayList_Spinner7.add("3 ครั้ง/วัน");
        arrayAdapter_Spinner7 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_Spinner7);
        Spinner7.setAdapter(arrayAdapter_Spinner7);

        arrayList_Spinner8 = new ArrayList<>();
        arrayList_Spinner8.add("หลังอาหาร");
        arrayList_Spinner8.add("ก่อนอาหาร อย่างน้อย 30 นาที");
        arrayList_Spinner8.add("ก่อนนอน");
        arrayList_Spinner8.add("รับประทานเมื่อมีอาการ");
        arrayAdapter_Spinner8 = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item,arrayList_Spinner8);
        Spinner8.setAdapter(arrayAdapter_Spinner8);

        next_medicine = findViewById(R.id.nextm);
        next_medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //////////////-------post
                Medicine_name = medicinename.getText().toString();
                Medicine_amount = Medicine_amount_box.getText().toString();

                Alarm_pill = Spinner5.getSelectedItem().toString();

                Period_length = Spinner6.getSelectedItem().toString();
                Use_period = Spinner7.getSelectedItem().toString();
                Use_kind = Spinner8.getSelectedItem().toString();
                //-----------------------------

                Intent intent = new Intent(Medicine.this, About_Medicine_3.class);
                startActivity(intent);
                finish();

                post_data_medicine();

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
                i.putExtra(CalendarContract.Events.TITLE,medicinename.getText().toString() + ", " + Medicine_amount_box.getText().toString() );
                i.putExtra(CalendarContract.Events.DESCRIPTION,""+medicinename.getText().toString()+", "+Spinner5.getSelectedItem().toString()+" , "+ Spinner8.getSelectedItem().toString());

                i.putExtra("beginTime",startMillis);
                i.putExtra("endTime", endMillis);

                startActivity(i);
            }
        });

        imagemedicine = findViewById(R.id.imagemedicine);

        //button click
        imagemedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if system os is >= marshmallow, request runtime permission
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (checkSelfPermission(Manifest.permission.CAMERA) ==
                            PackageManager.PERMISSION_DENIED ||
                            checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                                    PackageManager.PERMISSION_DENIED){
                        //permission not enabled, request it
                        String[] permission = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        //show popup to request permissions
                        requestPermissions(permission, PERMISSION_CODE);
                    }
                    else {
                        //permission already granted
                        openCamera();
                    }
                }
                else {
                    //system os < marshmallow
                    openCamera();
                }
            }
        });
    }

    private void openCamera() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "New Picture");
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera");
        image_uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        //Camera intent
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri);
        startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE);
    }

    //handling permission result
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //this method is called, when user presses Allow or Deny from Permission Request Popup
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_CODE: {
                if (grantResults.length > 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED) {
                    //permission from popup was granted
                    openCamera();
                } else {
                    //permission from popup was denied
                    Toast.makeText(this, "Permission denied...", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //called when image was captured from camera

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            //set the image captured to our ImageView
            imagemedicine.setImageURI(image_uri);
        }
    }

    private void post_data_medicine() {

        StringRequest jsonObjRequest = new StringRequest(Request.Method.POST,"http://iiec2312.trueddns.com:19744/medicine",
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

                params.put("Medicine_name",Medicine_name);
                params.put("Medicine_amount", Medicine_amount);
                params.put("Alarm_time",Alarm_time);
                params.put("Alarm_pill", Alarm_pill);
                params.put("Period_start", Period_start);
                params.put("Period_length", Period_length);
                params.put("Use_period", Use_period);
                params.put("Use_kind", Use_kind);
                return params;
            }
        };
        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        queue.add(jsonObjRequest);
    }

    @Override
    public void onBackPressed() {
            Intent intent = new Intent(Medicine.this, Add_medicine.class);
            startActivity(intent);
            finish();
    }

}