package com.example.chrisjerico.jubecermobileapplication;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


/**
 * Created by Chris Jerico Albino on 8/29/2017.
 */

public class LoginSgBackgroundWorker extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertdialog;

    LoginSgBackgroundWorker(Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String login_url = "http://192.168.43.166/loginsecu.php";
        //"http://10.0.2.2/loginsecu.php" ->for emulators
        //192.168.43.166->hotspots
        //192.168.22.10->wifi

        if (type.equals("login")) {
            try {
                String emailsecu = params[1];
                String passwordsecu = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("emailsecu", "UTF-8") + "=" + URLEncoder.encode(emailsecu, "UTF-8") + "&" + URLEncoder.encode("passwordsecu", "UTF-8") + "=" + URLEncoder.encode(passwordsecu, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
             //   Intent email= new Intent(context, GuardRequest.class);
             //   email.putExtra("emailsecu", emailsecu.toString());
              //  context.startActivity(email);


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertdialog = new AlertDialog.Builder(context).create();
        alertdialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
        alertdialog.setMessage(result);
        alertdialog.show();

        if (result.contains("success")) {
            Intent intent = new Intent(context, ProfileSg.class);
            context.startActivity(intent);

        }


    }
    /*
      protected String doInBackground (String...params){
        String login_url = "http://192.168.0.24/secuprofile.php";
        try {
            String emailsecu = params[1];
            URL url = new URL(login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("emailsecu", "UTF-8") + "=" + URLEncoder.encode(emailsecu, "UTF-8");
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

        */


    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


}
