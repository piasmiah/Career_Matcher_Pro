package com.trodev.careermatcherpro.mcq_part.english;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.trodev.careermatcherpro.R;
import com.trodev.careermatcherpro.mcq_part.bangla.ViewPagerAdapter;
import com.trodev.careermatcherpro.mcq_part.english.englishPagerAdapter;

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

        englishPagerAdapter adapter = new englishPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tab.setupWithViewPager(viewPager);

    }
}