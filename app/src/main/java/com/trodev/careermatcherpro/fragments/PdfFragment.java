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
import com.trodev.careermatcherpro.premium_pdf.EnglishActivity;
import com.trodev.careermatcherpro.premium_pdf.MentalActivity;


public class PdfFragment extends Fragment {

    MaterialCardView banglaMC, englishMC, mentalMC;


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

        return view;

    }
}