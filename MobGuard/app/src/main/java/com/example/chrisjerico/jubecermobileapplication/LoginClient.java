package com.example.chrisjerico.jubecermobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Chris Jerico Albino on 9/29/2017.
 */

public class LoginClient extends AppCompatActivity {
    Button login;
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        login = (Button)findViewById(R.id.btnlogin);
        username = (EditText)findViewById(R.id.userid);
        password = (EditText)findViewById(R.id.userpass);

    }
    public void onClicked(View view){

        String usernameclient = username.getText().toString();
        if(TextUtils.isEmpty(usernameclient)) {
            username.setError("Please enter your email.");
            return;
        }
        else if (!TextUtils.isEmpty(usernameclient))
        {
            if (!isValidEmail(usernameclient)) {
                username.setError("Invalid Email");
            }
        }
        String passwordclient = password.getText().toString();
        if(TextUtils.isEmpty(passwordclient)) {
            password.setError("Please enter your password.");
            return;
        }
        else if (!TextUtils.isEmpty(passwordclient))
        {
        //    if (!isValidPassword(passwordclient)) {
         //       password.setError("Invalid Password");
         //   }
             String type = "login";

          LoginClientBackgroundWorker loginclientbackgroundworker = new LoginClientBackgroundWorker(this);
          loginclientbackgroundworker.execute(type, usernameclient, passwordclient);

        }




    }


    private boolean isValidEmail(String usernamesg) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(usernamesg);
        return matcher.matches();
    }

    private boolean isValidPassword(String passwordsg) {
        if (passwordsg != null && passwordsg.length() > 6) {
            return true;
        }
        return false;
    }



}
