package com.trodev.careermatcherpro.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.trodev.careermatcherpro.R;

public class PremiumPackagesActivity extends AppCompatActivity {

    TextView detailsTv, gold_details, platinum_details, master_details;
    LinearLayout basic_layout, gold_layout, platinum_layout, master_layout;
    Button basic_btn, gold_btn, platinum_btn, master_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premium_packages);

        /*init views*/
        detailsTv = findViewById(R.id.detailsTv);
        basic_layout = findViewById(R.id.basic_layout);
        basic_btn = findViewById(R.id.basic_btn);

        gold_details = findViewById(R.id.gold_details);
        gold_layout = findViewById(R.id.gold_layout);
        gold_btn = findViewById(R.id.gold_btn);

        platinum_details = findViewById(R.id.platinum_details);
        platinum_layout = findViewById(R.id.platinum_layout);
        platinum_btn = findViewById(R.id.platinum_btn);

        master_details = findViewById(R.id.master_details);
        master_layout = findViewById(R.id.master_layout);
        master_btn = findViewById(R.id.master_btn);


        /*transaction effect on linear layout*/
        basic_layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        gold_layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        platinum_layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        master_layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

    }

    public void expand(View view) {

        int text = (detailsTv.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
        TransitionManager.beginDelayedTransition(basic_layout, new AutoTransition());
        detailsTv.setVisibility(text);

        basic_btn.setVisibility(View.VISIBLE);

    }

    public void gold_expand(View view) {

        int text = (gold_details.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
        TransitionManager.beginDelayedTransition(gold_layout, new AutoTransition());
        gold_details.setVisibility(text);

        gold_btn.setVisibility(View.VISIBLE);
    }

    public void platinum_expand(View view) {

        int text = (platinum_details.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
        TransitionManager.beginDelayedTransition(platinum_layout, new AutoTransition());
        platinum_details.setVisibility(text);

        platinum_btn.setVisibility(View.VISIBLE);

    }

    public void master_expand(View view) {

        int text = (master_details.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
        TransitionManager.beginDelayedTransition(master_layout, new AutoTransition());
        master_details.setVisibility(text);

        master_btn.setVisibility(View.VISIBLE);

    }
}