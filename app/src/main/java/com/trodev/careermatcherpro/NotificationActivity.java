package com.trodev.careermatcherpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.trodev.careermatcherpro.R;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        /*action bar title and back button*/
        getSupportActionBar().setTitle("Notification");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}