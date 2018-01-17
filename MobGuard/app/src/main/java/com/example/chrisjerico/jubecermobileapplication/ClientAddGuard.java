package com.example.chrisjerico.jubecermobileapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Chris Jerico Albino on 10/17/2017.
 */

public class ClientAddGuard extends AppCompatActivity {
    TextView startdate;
    Button btnDateStart, btnDatePicker, btnTimePicker, btnSubmit, btnView;
    EditText txtDate, numberofguards, shiftstart, shiftend;
    DatePickerDialog meetstart;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addguard);
        btnDatePicker = (Button) findViewById(R.id.btn_date);
        btnSubmit = (Button) findViewById(R.id.btnsubmit);
        btnView = (Button) findViewById(R.id.btnview);
        txtDate = (EditText) findViewById(R.id.in_date);
        numberofguards = (EditText) findViewById(R.id.editText6);
        shiftstart = (EditText) findViewById(R.id.editText2);
        shiftend = (EditText) findViewById(R.id.editText23);


        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final java.util.Calendar c = java.util.Calendar.getInstance();
                int mYear = c.get(java.util.Calendar.YEAR); // current year
                int mMonth = c.get(java.util.Calendar.MONTH); // current month
                int mDay = c.get(java.util.Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                meetstart = new DatePickerDialog(ClientAddGuard.this,
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
        String no = numberofguards.getText().toString();
        String start = shiftstart.getText().toString();
        String end = shiftend.getText().toString();
        String date = txtDate.getText().toString();

        if  (TextUtils.isEmpty(no)) {
            numberofguards.setError("Please enter the additional number of guards you need.");
            return;
        } else if (TextUtils.isEmpty(start)) {
            shiftstart.setError("Please enter the start shift.");
            return;
        } else if (TextUtils.isEmpty(end)) {
            shiftend.setError("Please enter the end shift.");
            return;
        } else if (TextUtils.isEmpty(date)) {
            txtDate.setError("Please set your meeting date.");
            return;
        } else {

            Toast.makeText(getApplicationContext(), "Processing Request...", Toast.LENGTH_SHORT).show();

            ClientAddGuardBackgroundWorker clientaddgbackgroundworker = new ClientAddGuardBackgroundWorker(this);
            clientaddgbackgroundworker.execute(type, no, start,end, date);


        }
    }
}