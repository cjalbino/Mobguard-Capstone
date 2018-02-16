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

public class  MainProfile extends AppCompatActivity {
    ListView lv2, lv3, lv5, lv6;
    GridView gv1, gv2, gv3;


    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2;
    ArrayAdapter<String> adapter3;
    ArrayAdapter<String> adapter4;
    ArrayAdapter<String> adapter5;
    ArrayAdapter<String> adapter6;

    ArrayAdapter<String> adapter9;
    ArrayAdapter<String> adapter10;
    String address="http://192.168.43.166/clientsprofile.php";
    InputStream is=null;
    String line=null;
    String result = null;
    String[] data;

    String[] data2;
    String[] data3;

    String[] data4;

    String[] data5;
    String[] data6;
    String[] data7;
    String[] data8;

    String[] data9;
    String[] data10;
    String[] data11;
    String[] data12;

    String[] data13;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainprofile);


        gv1 = (GridView) findViewById(R.id.gridView1);
        gv2 = (GridView) findViewById(R.id.gridView2);
        gv3 = (GridView) findViewById(R.id.gridView3);
        lv2 = (ListView) findViewById(R.id.listView2);
        lv3 = (ListView) findViewById(R.id.listView3);

        lv5 = (ListView) findViewById(R.id.listView5);
        lv6 = (ListView) findViewById(R.id.listView6);

        //ALLOW NETWORK IN MAIN THREAD
        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));

        //Retrieve
        getData();

        //Adapter
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
        gv1.setAdapter(adapter);
        adapter9=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data9);
        gv2.setAdapter(adapter9);
        adapter10=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data10);
        gv3.setAdapter(adapter10);
        adapter2=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data2);
        lv2.setAdapter(adapter2);
        adapter3=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data3);
        lv3.setAdapter(adapter3);
        adapter5=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data5);
        lv5.setAdapter(adapter5);
        adapter6=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data6);
        lv6.setAdapter(adapter6);
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
                data[i]=jo.getString("first_name");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try
        {
            JSONArray ja=new JSONArray(result);
            JSONObject jo=null;

            data9 = new String[ja.length()];

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                data9[i]=jo.getString("middle_name");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        try
        {
            JSONArray ja=new JSONArray(result);
            JSONObject jo=null;

            data10 = new String[ja.length()];

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                data10[i]=jo.getString("last_name");
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
                data2[i]=jo.getString("address");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        try
        {
            JSONArray ja=new JSONArray(result);
            JSONObject jo=null;

            data3 = new String[ja.length()];

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                data3[i]=jo.getString("email");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try
        {
            JSONArray ja=new JSONArray(result);
            JSONObject jo=null;

            data5 = new String[ja.length()];

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                data5[i]=jo.getString("contactNo");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        try
        {
            JSONArray ja=new JSONArray(result);
            JSONObject jo=null;

            data6 = new String[ja.length()];

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                data6[i]=jo.getString("cellphoneNo");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
