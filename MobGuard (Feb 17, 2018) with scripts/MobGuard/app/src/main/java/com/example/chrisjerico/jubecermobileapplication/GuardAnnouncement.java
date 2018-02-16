package com.example.chrisjerico.jubecermobileapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ChrisJerico on 3/16/2017.
 */

public class  GuardAnnouncement extends AppCompatActivity {
    GridView gv1, gv2, gv3;


    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter1;
    ArrayAdapter<String> adapter2;

    String address="http://192.168.43.166/guardannouncements.php";
    InputStream is=null;
    String line=null;
    String result = null;
    String[] data;
    String[] data1;
    String[] data2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardannouncement);


        gv1 = (GridView) findViewById(R.id.gridView1);
        gv2 = (GridView) findViewById(R.id.gridView2);
        gv3 = (GridView) findViewById(R.id.gridView3);

        //ALLOW NETWORK IN MAIN THREAD
        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));

        //Retrieve
        getData();

        //Adapter
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
        gv1.setAdapter(adapter);
        adapter1=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data1);
        gv2.setAdapter(adapter1);
        adapter2=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data2);
        gv3.setAdapter(adapter2);

        /*
        Intent intent = new Intent(MainProfileSg.this, SecuId.class );
        intent.putExtra("gv13", gv13.toString());
        startActivity(intent);
        */
    }


    private void getData() {
        try
        {
            URL url = new URL(address);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            is = new BufferedInputStream(con.getInputStream());

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        //read its content into a string
        try
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            StringBuilder sb=new StringBuilder();
            while((line=br.readLine())!= null)
            {
                sb.append(line+"\n");
            }
            is.close();
            result=sb.toString();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        //PARSE JSON data
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
        try
        {
            JSONArray ja=new JSONArray(result);
            JSONObject jo=null;

            data2 = new String[ja.length()];

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                data2[i]=jo.getString("created_at");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }





    }


}
