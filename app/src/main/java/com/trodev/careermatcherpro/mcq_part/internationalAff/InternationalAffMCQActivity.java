package com.trodev.careermatcherpro.mcq_part.internationalAff;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.trodev.careermatcherpro.R;

public class InternationalAffMCQActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internationalaff_mcqactivity);

        getSupportActionBar().setTitle("InternationalAff");
        /*getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);

        internationalAffPagerAdapter adapter = new internationalAffPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tab.setupWithViewPager(viewPager);

    }
}