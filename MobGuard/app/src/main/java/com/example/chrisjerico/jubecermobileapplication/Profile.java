package com.example.chrisjerico.jubecermobileapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class Profile extends AppCompatActivity {
    ImageButton establishment, profile, message, request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        this.getActivityIntent();
        establishment=(ImageButton)findViewById(R.id.imgEstablishment);
        profile=(ImageButton)findViewById(R.id.imgProfile);
        request=(ImageButton)findViewById(R.id.imgRequest);

    }
    public void onClicked(View v)
    {
        switch(v.getId()){
            case R.id.imgEstablishment:
                Intent es = new Intent(this, ClientEstablishment.class);
                startActivity(es);
                break;
            case R.id.imgProfile:
                Intent pro = new Intent(this, MainProfile.class);
                startActivity(pro);
                break;
            case R.id.imgRequest:
                Intent req = new Intent(this, ClientRequest.class);
                startActivity(req);
                break;
            case R.id.imgAddguard:
                Intent geh = new Intent (this, ClientAddGuard.class);
                startActivity(geh);
                break;

        }
    }
    public void getActivityIntent()
    {
        android.content.Intent i = getIntent();
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Do you want to logout?");
        // alert.setMessage("Message");

        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //Your action here
                Profile.this.finish();
            }
        });

        alert.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        alert.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.viewMyAccountID:
                Intent intent1 = new Intent(this, MainProfile.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.logoutID:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

}
