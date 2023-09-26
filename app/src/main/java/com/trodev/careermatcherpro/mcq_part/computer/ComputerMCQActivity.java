package com.trodev.careermatcherpro.mcq_part.computer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.trodev.careermatcherpro.R;

public class ComputerMCQActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_mcqactivity);

        getSupportActionBar().setTitle("Computer");
        /*getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);

        computerPagerAdapter adapter = new computerPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tab.setupWithViewPager(viewPager);

    }
}