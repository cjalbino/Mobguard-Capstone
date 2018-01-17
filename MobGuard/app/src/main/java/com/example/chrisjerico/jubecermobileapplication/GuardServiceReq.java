package com.example.chrisjerico.jubecermobileapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GuardServiceReq extends AppCompatActivity {
    Button  btnSubmit, btnView;
    EditText reason;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardservicereq);

        btnSubmit = (Button) findViewById(R.id.btnsubmit);
        btnView = (Button) findViewById(R.id.btnview);
        reason = (EditText) findViewById(R.id.editText7);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getdata();
            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent es = new Intent(getApplicationContext(), ProfileSg.class);
                startActivity(es);
            }
        });

    }

    private void getdata() {
        String type = "send";
        String rea = reason.getText().toString();
        if  (TextUtils.isEmpty(rea)) {
            reason.setError("Please enter your reason.");
            return;
        }
        else {

            Toast.makeText(getApplicationContext(), "Processing Request...", Toast.LENGTH_SHORT).show();

            GuardResignationBackgroundWorker guardresigbackgroundworker = new GuardResignationBackgroundWorker(this);
            guardresigbackgroundworker.execute(type, rea);


        }
    }
}