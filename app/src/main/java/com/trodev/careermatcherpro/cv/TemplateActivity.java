package com.trodev.careermatcherpro.cv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.trodev.careermatcherpro.R;

public class TemplateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);


        /*action bar and title name*/
        getSupportActionBar().setTitle("Template all");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}