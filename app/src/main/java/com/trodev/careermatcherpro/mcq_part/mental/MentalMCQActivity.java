package com.trodev.careermatcherpro.mcq_part.mental;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.trodev.careermatcherpro.R;

public class MentalMCQActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_mcqactivity);

        getSupportActionBar().setTitle("Mental");
        /*getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);

        mentalPagerAdapter adapter = new mentalPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tab.setupWithViewPager(viewPager);

    }
}