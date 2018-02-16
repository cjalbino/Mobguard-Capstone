package com.example.chrisjerico.jubecermobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Chris Jerico Albino on 9/14/2017.
 */

public class SecuId extends AppCompatActivity {
    public String gv13;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            Intent intent = getIntent();
            String gv13 = intent.getStringExtra("gv13");
    }


}
