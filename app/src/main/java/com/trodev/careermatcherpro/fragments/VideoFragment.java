package com.trodev.careermatcherpro.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trodev.careermatcherpro.BanglaVideoActivity;
import com.trodev.careermatcherpro.EnglishVideoActivity;
import com.trodev.careermatcherpro.R;


public class VideoFragment extends Fragment {

    CardView banglaCv, englishCv;

    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_video, container, false);

        banglaCv = view.findViewById(R.id.banglaCv);
        englishCv = view.findViewById(R.id.englishCv);

        banglaCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), BanglaVideoActivity.class));
            }
        });

        englishCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), EnglishVideoActivity.class));
            }
        });

        return view;
    }
}