package com.trodev.careermatcherpro.mcq_part.bangladeshAff;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.trodev.careermatcherpro.R;

public class BangladeshAffMCQActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangladeshaff_mcqactivity);

        getSupportActionBar().setTitle("BangladeshAff");
        /*getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);

        bangladeshAffPagerAdapter adapter = new bangladeshAffPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tab.setupWithViewPager(viewPager);

    }
}