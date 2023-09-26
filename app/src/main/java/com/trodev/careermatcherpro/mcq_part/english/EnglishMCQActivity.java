package com.trodev.careermatcherpro.mcq_part.english;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.trodev.careermatcherpro.R;


public class EnglishMCQActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_mcqactivity);

        getSupportActionBar().setTitle("English");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);

        EnglishPagerAdapter adapter = new EnglishPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tab.setupWithViewPager(viewPager);

    }
}