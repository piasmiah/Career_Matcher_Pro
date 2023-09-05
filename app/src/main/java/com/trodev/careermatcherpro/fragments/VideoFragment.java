package com.trodev.careermatcherpro.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trodev.careermatcherpro.videos.BanglaVideoActivity;
import com.trodev.careermatcherpro.videos.BasicComputerVideoActivity;
import com.trodev.careermatcherpro.videos.EnglishVideoActivity;
import com.trodev.careermatcherpro.videos.IllustratorVideoActivity;
import com.trodev.careermatcherpro.videos.MSExcelVideoActivity;
import com.trodev.careermatcherpro.videos.MSPointVideoActivity;
import com.trodev.careermatcherpro.videos.MSWordActivity;
import com.trodev.careermatcherpro.videos.PhotoshopVideoActivity;
import com.trodev.careermatcherpro.R;


public class VideoFragment extends Fragment {

    CardView banglaCv, englishCv, illustratorCv, msExelCv, msWordCv, msPointCv, photoshopCv, basicComputerCv;

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
        illustratorCv = view.findViewById(R.id.illustratorCv);
        msExelCv = view.findViewById(R.id.msExelCv);
        msWordCv = view.findViewById(R.id.msWordCv);
        msPointCv = view.findViewById(R.id.msPointCv);
        photoshopCv = view.findViewById(R.id.photoshopCv);
        basicComputerCv = view.findViewById(R.id.basicComputerCv);

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

        illustratorCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), IllustratorVideoActivity.class));
            }
        });

        msExelCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MSExcelVideoActivity.class));
            }
        });

        msWordCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MSWordActivity.class));
            }
        });

        msPointCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MSPointVideoActivity.class));
            }
        });

        photoshopCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), PhotoshopVideoActivity.class));
            }
        });

        basicComputerCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), BasicComputerVideoActivity.class));
            }
        });

        return view;
    }
}