package com.trodev.careermatcherpro.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.trodev.careermatcherpro.R;
import com.trodev.careermatcherpro.advice.AdviceAdapter;
import com.trodev.careermatcherpro.advice.AdviceModel;
import com.trodev.careermatcherpro.govt.GovtActivity;
import com.trodev.careermatcherpro.nongovt.NonGovtJobActivity;
import com.trodev.careermatcherpro.teacher.TeacherJobActivity;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    CardView govtMc, nongovtMc, teacherMc;
    ArrayList<AdviceModel> model;
    AdviceAdapter adapter;
    FirebaseDatabase database;
    DatabaseReference reference;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        /*finding all items*/
        govtMc = view.findViewById(R.id.govtMc);
        nongovtMc = view.findViewById(R.id.nongovtMc);
        teacherMc = view.findViewById(R.id.teacherMc);
        recyclerView = view.findViewById(R.id.recyclerView);



        /*set on click listener*/
        govtMc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), GovtActivity.class));
            }
        });

        nongovtMc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), NonGovtJobActivity.class));
            }
        });

        teacherMc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), TeacherJobActivity.class));
            }
        });

        /*load advice*/
        loadAdvice();
        return view;

    }

    private void loadAdvice() {

        model = new ArrayList<>();

        // firebase realtime database
        reference = FirebaseDatabase.getInstance().getReference().child("advice");

        adapter = new AdviceAdapter(model, getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    AdviceModel govtModel = dataSnapshot.getValue(AdviceModel.class);
                    model.add(0, govtModel);

                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        /*database synced*/
        reference.keepSynced(true);

    }
}