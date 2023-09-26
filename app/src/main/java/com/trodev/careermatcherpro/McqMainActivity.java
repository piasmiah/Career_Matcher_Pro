package com.trodev.careermatcherpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;
import com.trodev.careermatcherpro.mcq_part.bangla.BanglaMCQActivity;
import com.trodev.careermatcherpro.mcq_part.computer.ComputerMCQActivity;
import com.trodev.careermatcherpro.mcq_part.english.EnglishMCQActivity;
import com.trodev.careermatcherpro.mcq_part.math.MathMCQActivity;
import com.trodev.careermatcherpro.mcq_part.mental.MentalMCQActivity;

public class McqMainActivity extends AppCompatActivity {

    MaterialCardView banglaMC, englishMC, mentalMC, bangladeshAffMC, internationalAffMC, generalMC, computerMC, mathemeticalMC, ethicsMc, geographyMc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcq_main);

        /*init views*/
        banglaMC = findViewById(R.id.banglaMC);
        englishMC = findViewById(R.id.englishMC);
        mentalMC = findViewById(R.id.mentalMC);
        bangladeshAffMC = findViewById(R.id.bangladeshAffMC);
        internationalAffMC = findViewById(R.id.internationalAffMC);
        generalMC = findViewById(R.id.generalMC);
        computerMC = findViewById(R.id.computerMC);
        mathemeticalMC = findViewById(R.id.mathemeticalMC);
        geographyMc = findViewById(R.id.geographyMc);
        ethicsMc = findViewById(R.id.ethicsMc);

        banglaMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(McqMainActivity.this, BanglaMCQActivity.class));
            }
        });

        englishMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(McqMainActivity.this, EnglishMCQActivity.class));
            }
        });

        mathemeticalMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(McqMainActivity.this, MathMCQActivity.class));
            }
        });

        mentalMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(McqMainActivity.this, MentalMCQActivity.class));
            }
        });

        computerMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(McqMainActivity.this, ComputerMCQActivity.class));
            }
        });
    }
}