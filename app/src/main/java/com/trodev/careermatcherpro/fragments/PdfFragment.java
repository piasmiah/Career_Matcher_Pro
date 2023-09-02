package com.trodev.careermatcherpro.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.card.MaterialCardView;
import com.trodev.careermatcherpro.R;
import com.trodev.careermatcherpro.premium_pdf.BanglaActivity;
import com.trodev.careermatcherpro.premium_pdf.BangladeshAffActivity;
import com.trodev.careermatcherpro.premium_pdf.ComputerActivity;
import com.trodev.careermatcherpro.premium_pdf.EnglishActivity;
import com.trodev.careermatcherpro.premium_pdf.GeneralScienceActivity;
import com.trodev.careermatcherpro.premium_pdf.InternationalAffActivity;
import com.trodev.careermatcherpro.premium_pdf.MathActivity;
import com.trodev.careermatcherpro.premium_pdf.MentalActivity;


public class PdfFragment extends Fragment {

    MaterialCardView banglaMC, englishMC, mentalMC, bangladeshAffMC, internationalAffMC, generalMC, computerMC, mathemeticalMC, ethicsMc, geographyMc;

    public PdfFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pdf, container, false);

        banglaMC = view.findViewById(R.id.banglaMC);
        englishMC = view.findViewById(R.id.englishMC);
        mentalMC = view.findViewById(R.id.mentalMC);
        bangladeshAffMC = view.findViewById(R.id.bangladeshAffMC);
        internationalAffMC = view.findViewById(R.id.internationalAffMC);
        generalMC = view.findViewById(R.id.generalMC);
        computerMC = view.findViewById(R.id.computerMC);
        mathemeticalMC = view.findViewById(R.id.mathemeticalMC);

        banglaMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), BanglaActivity.class));
            }
        });

        englishMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), EnglishActivity.class));
            }
        });

        mentalMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MentalActivity.class));
            }
        });

        bangladeshAffMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), BangladeshAffActivity.class));
            }
        });

        internationalAffMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), InternationalAffActivity.class));
            }
        });

        generalMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), GeneralScienceActivity.class));
            }
        });

        computerMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), ComputerActivity.class));
            }
        });

        mathemeticalMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MathActivity.class));
            }
        });

        return view;

    }
}