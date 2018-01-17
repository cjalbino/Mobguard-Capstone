package com.example.chrisjerico.jubecermobileapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Guard;

public class GuardAnnouncement extends AppCompatActivity {
    GridView gv1, gv2;


    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter1;

    String address="http://192.168.43.166/guardannouncements.php";
    InputStream is=null;
    String line=null;
    String result = null;
    String[] data;

    String[] data1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardannouncement);


        gv1 = (GridView) findViewById(R.id.gridView);
        gv2 = (GridView) findViewById(R.id.gridView7);


        //ALLOW NETWORK IN MAIN THREAD
        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));

        //Retrieve
        getData();

        //Adapter
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
        gv1.setAdapter(adapter);
        adapter1=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data1);
        gv2.setAdapter(adapter1);

        /*
        Intent intent = new Intent(MainProfileSg.this, SecuId.class );
        intent.putExtra("gv13", gv13.toString());
        startActivity(intent);
        */


    }


    private void getData() {


        try
        {
            JSONArray ja=new JSONArray(result);
            JSONObject jo=null;

            data = new String[ja.length()];

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                data[i]=jo.getString("subject");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        try
        {
            JSONArray ja=new JSONArray(result);
            JSONObject jo=null;

            data1 = new String[ja.length()];

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                data1[i]=jo.getString("details");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
