package com.example.chrisjerico.jubecermobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.widget.Toast;

import static android.text.TextUtils.isEmpty;

/**
 * Created by ChrisJerico on 3/15/2017.
 */

public class LoginSg extends AppCompatActivity {
    Button login;
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sglogin);

        login = (Button)findViewById(R.id.btnloginsg);
        username = (EditText)findViewById(R.id.sgid);
        password = (EditText)findViewById(R.id.sgpass);

    }
   public void onClicked(View view){

        String usernamesg = username.getText().toString();
       if(TextUtils.isEmpty(usernamesg)) {
           username.setError("Please enter your email.");
           return;
       }
       else if (!TextUtils.isEmpty(usernamesg))
       {
           if (!isValidEmail(usernamesg)) {
               username.setError("Invalid Email");
           }
       }
        String passwordsg = password.getText().toString();
       if(TextUtils.isEmpty(passwordsg)) {
           password.setError("Please enter your password.");
           return;
       }
       else if (!TextUtils.isEmpty(passwordsg))
       {
       //    if (!isValidPassword(passwordsg)) {
       //        password.setError("Invalid Password");
        //   }

       }
        String type = "login";

          LoginSgBackgroundWorker loginsgbackgroundworker = new LoginSgBackgroundWorker(this);
          loginsgbackgroundworker.execute(type, usernamesg, passwordsg);
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
