package com.trodev.careermatcherpro.mcq_part.math;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.trodev.careermatcherpro.R;

public class MathMCQActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_mcqactivity);

        getSupportActionBar().setTitle("Math");
        /*getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);

        mathPagerAdapter adapter = new mathPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tab.setupWithViewPager(viewPager);

    }
}