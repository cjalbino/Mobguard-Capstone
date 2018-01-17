package com.example.chrisjerico.jubecermobileapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.R.attr.button;
import static android.R.attr.onClick;

/**
 * Created by ChrisJerico on 3/16/2017.
 */

    public class ClientMessage extends AppCompatActivity {
    RadioButton rad1,rad2;
    String send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientmessage);
        Button submit = (Button) findViewById(R.id.btnsend);
        rad1 = (RadioButton)findViewById(R.id.radioButton);
        rad2 = (RadioButton)findViewById(R.id.radioButton2);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                if (rad1.isChecked()) {
                    send = rad1.getText().toString();
                } else if (rad2.isChecked()) {
                    send = rad2.getText().toString();
                }

                Toast.makeText(getApplicationContext(),"Sending to "+send, Toast.LENGTH_LONG).show(); // print the value of selected super star
            }
        });


    }
}








