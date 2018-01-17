package com.example.chrisjerico.jubecermobileapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by ChrisJerico on 3/16/2017.
 */

public class ClientRequest extends AppCompatActivity {
    TextView startdate;
    Button btnDateStart, btnDatePicker, btnTimePicker, btnSubmit, btnView;
    EditText txtDate, txtTime, meetingplace, servicedescription;
    DatePickerDialog meetstart;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientrequest);
        btnDatePicker = (Button) findViewById(R.id.btn_date);
        btnSubmit = (Button) findViewById(R.id.btnsubmit);
        btnView = (Button) findViewById(R.id.btnview);
        txtDate = (EditText) findViewById(R.id.in_date);
        meetingplace = (EditText) findViewById(R.id.editText2);
        servicedescription = (EditText) findViewById(R.id.editText6);

        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final java.util.Calendar c = java.util.Calendar.getInstance();
                int mYear = c.get(java.util.Calendar.YEAR); // current year
                int mMonth = c.get(java.util.Calendar.MONTH); // current month
                int mDay = c.get(java.util.Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                meetstart = new DatePickerDialog(ClientRequest.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                txtDate.setText(year + "-"
                                        + (monthOfYear + 1) + "-" + dayOfMonth);

                            }
                        }, mYear, mMonth, mDay);
                meetstart.show();
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getdata();
            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent es = new Intent(getApplicationContext(), Profile.class);
                startActivity(es);
            }
        });

    }

    private void getdata() {
        String type = "send";
        String desc = servicedescription.getText().toString();
        String place = meetingplace.getText().toString();
        String date = txtDate.getText().toString();

        if  (TextUtils.isEmpty(desc)) {
            servicedescription.setError("Please enter your service description.");
            return;
        } else if (TextUtils.isEmpty(place)) {
            meetingplace.setError("Please enter your meeting place.");
            return;
        } else if (TextUtils.isEmpty(date)) {
            txtDate.setError("Please set your meeting date.");
            return;
        } else {

            Toast.makeText(getApplicationContext(), "Processing Request...", Toast.LENGTH_SHORT).show();


            ClientRequestBackgroundWorker clientreqbackgroundworker = new ClientRequestBackgroundWorker(this);
            clientreqbackgroundworker.execute(type, desc, place, date);


        }
    }
}