package com.example.chrisjerico.jubecermobileapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Guard;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by ChrisJerico on 3/16/2017.
 */

public class GuardRequest extends AppCompatActivity {
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView StartDate, EndDate, current;
    private GridView secu;
    private Button start, end, send, back;
    private int year, month, day;
    DatePickerDialog startpic, endpic;
    private EditText reason, seid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardrequest);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(c.getTime());
        // formattedDate have current date/time
        current = (TextView) findViewById(R.id.textView43);
        back = (Button) findViewById(R.id.btnback);
        // Now we display formattedDate value in TextView
        current.setText(formattedDate);
      //  secu = (GridView) findViewById(R.id.textView50);
        StartDate = (TextView) findViewById(R.id.editText4);
        EndDate = (TextView) findViewById(R.id.editText5);
        start = (Button) findViewById(R.id.textView44);
        end = (Button) findViewById(R.id.textView48);
        send = (Button) findViewById(R.id.btnsubmit);
        reason= (EditText) findViewById(R.id.editText3);
        seid= (EditText) findViewById(R.id.editText2);

        // perform click event on edit text
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                startpic = new DatePickerDialog(GuardRequest.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                StartDate.setText(year + "-"
                                        + (monthOfYear + 1) + "-" + dayOfMonth);

                            }
                        }, mYear, mMonth, mDay);
                startpic.show();
            }
        });
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                endpic = new DatePickerDialog(GuardRequest.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                EndDate.setText(year + "-"
                                        + (monthOfYear + 1) + "-" + dayOfMonth);

                            }
                        }, mYear, mMonth, mDay);
                endpic.show();
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getdata();
            }
        });
        /*
        MainProfileSg sec =new MainProfileSg();
        String secid;
        secid=sec.gv13.toString();
        seid.setText(secid);
        */
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent es = new Intent(getApplication(), ProfileSg.class);
                startActivity(es);
            }
        });
    }
    public void getdata() {
        String type = "send";
        String start = StartDate.getText().toString();
        String end = EndDate.getText().toString();
        String re = reason.getText().toString();
        if (TextUtils.isEmpty(start)) {
            StartDate.setError("Please set your Start Date.");
            return;
        } else if (TextUtils.isEmpty(end)) {
            EndDate.setError("Please enter your End Date.");
            return;
        } else if (TextUtils.isEmpty(re)) {
            reason.setError("Please state your reason.");
            return;
        } else {

            Toast.makeText(getApplicationContext(), "Processing Request...", Toast.LENGTH_SHORT).show();
            GuardRequestBackgroundWorker guardreqbackgroundworker = new GuardRequestBackgroundWorker(this);
            guardreqbackgroundworker.execute(type, start, end, re);
        }

    }

}



