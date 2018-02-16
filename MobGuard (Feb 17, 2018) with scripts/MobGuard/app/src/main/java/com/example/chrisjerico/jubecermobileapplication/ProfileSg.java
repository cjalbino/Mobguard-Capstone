package com.example.chrisjerico.jubecermobileapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by ChrisJerico on 3/15/2017.
 */

public class ProfileSg extends AppCompatActivity{
        ImageButton announcements,resign, profile, message, request;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_profilesg);
            announcements = (ImageButton)findViewById(R.id.imgAnnouncement);
            resign = (ImageButton)findViewById(R.id.imgResignation);
            profile = (ImageButton)findViewById(R.id.imgProfile);
            request = (ImageButton)findViewById(R.id.imgRequest);




            LoadSecuId();
            LoadLeaveId();
        }

    private void LoadLeaveId() {
    }

    private void LoadSecuId(){

    }
    public void onClicked(View view){
            switch(view.getId()){
                case R.id.imgAnnouncement:
                    Intent ann = new Intent(this, GuardAnnouncement.class);
                    startActivity(ann);
                    break;
                case R.id.imgResignation:
                    Intent cli = new Intent(this, GuardServiceReq.class);
                    startActivity(cli);
                    break;
                case R.id.imgProfile:
                    Intent prof = new Intent(this, MainProfileSg.class);
                    startActivity(prof);
                    break;
                case R.id.imgRequest:
                    Intent reqs = new Intent(this, GuardRequest.class);
                    startActivity(reqs);
                    break;
            }
        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.menusg,menu);
            return true;
        }
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.viewMyAccountIDsg:
                    Intent intent1 = new Intent(this, MainProfileSg.class);
                    startActivity(intent1);
                    finish();
                    break;
                case R.id.logoutIDsg:
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    break;

            }
            return super.onOptionsItemSelected(item);
        }
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Do you want to logout?");
        // alert.setMessage("Message");

        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //Your action here
                ProfileSg.this.finish();
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

}
