package com.example.chrisjerico.jubecermobileapplication;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }

     public void onClicked(View v){
            switch (v.getId()) {
                case R.id.btnclient:
                      Intent client = new Intent(this, LoginClient.class);
                        startActivity(client);
                       break;
                case R.id.btnsg:
                    Intent sg = new Intent(this, LoginSg.class);
                    startActivity(sg);
                    break;

            }

    }

}
