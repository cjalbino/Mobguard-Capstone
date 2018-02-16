package com.example.chrisjerico.jubecermobileapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ChrisJerico on 3/16/2017.
 */

public class MainProfileSg extends AppCompatActivity {

    ListView lv2, lv3, lv5, lv6,lv7,lv8;
    GridView gv1;
    GridView gv2;
    GridView gv3;
    GridView gv4;
    GridView gv5;
    GridView gv6;
    GridView gv13;

    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2;
    ArrayAdapter<String> adapter3;
    ArrayAdapter<String> adapter4;
    ArrayAdapter<String> adapter5;
    ArrayAdapter<String> adapter6;
    ArrayAdapter<String> adapter7;
    ArrayAdapter<String> adapter8;

    ArrayAdapter<String> adapter9;
    ArrayAdapter<String> adapter10;
    ArrayAdapter<String> adapter11;
    ArrayAdapter<String> adapter12;

    ArrayAdapter<String> adapter13;
    String address="http://192.168.43.166/secuprofile.php";
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
        setContentView(R.layout.activity_mainprofilesg);

        gv13 = (GridView) findViewById(R.id.gridView13);

        gv1 = (GridView) findViewById(R.id.gridView1);
        gv2 = (GridView) findViewById(R.id.gridView2);
        gv3 = (GridView) findViewById(R.id.gridView3);
        lv2 = (ListView) findViewById(R.id.listView2);
        lv3 = (ListView) findViewById(R.id.listView3);
        gv4 = (GridView) findViewById(R.id.gridView4);
        gv5 = (GridView) findViewById(R.id.gridView5);
        gv6 = (GridView) findViewById(R.id.gridView6);
        lv5 = (ListView) findViewById(R.id.listView5);
        lv6 = (ListView) findViewById(R.id.listView6);
        lv7 = (ListView) findViewById(R.id.listView7);
        lv8 = (ListView) findViewById(R.id.listView8);
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
        adapter4=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data4);
        gv4.setAdapter(adapter4);
        adapter11=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data11);
        gv5.setAdapter(adapter11);
        adapter12=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data12);
        gv6.setAdapter(adapter12);
        adapter5=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data5);
        lv5.setAdapter(adapter5);
        adapter6=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data6);
        lv6.setAdapter(adapter6);
        adapter7=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data7);
        lv7.setAdapter(adapter7);
        adapter8=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data8);
        lv8.setAdapter(adapter8);
        adapter13 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data13);
        gv13.setAdapter(adapter13);
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
                data2[i]=jo.getString("birth");
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
                data3[i]=jo.getString("gender");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        try
        {
            JSONArray ja=new JSONArray(result);
            JSONObject jo=null;

            data4 = new String[ja.length()];

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                data4[i]=jo.getString("street");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        try
        {
            JSONArray ja=new JSONArray(result);
            JSONObject jo=null;

            data11 = new String[ja.length()];

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                data11[i]=jo.getString("barangay");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        try
        {
            JSONArray ja=new JSONArray(result);
            JSONObject jo=null;

            data12 = new String[ja.length()];

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                data12[i]=jo.getString("city");
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
                data5[i]=jo.getString("marital_status");
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
                data6[i]=jo.getString("telephone");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        try
        {
            JSONArray ja=new JSONArray(result);
            JSONObject jo=null;

            data7 = new String[ja.length()];

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                data7[i]=jo.getString("cellphone");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        try
        {
            JSONArray ja=new JSONArray(result);
            JSONObject jo=null;

            data8 = new String[ja.length()];

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                data8[i]=jo.getString("status");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        try
        {
            JSONArray ja=new JSONArray(result);
            JSONObject jo=null;

            data13 = new String[ja.length()];

            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                data13[i]=jo.getString("id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }



}
