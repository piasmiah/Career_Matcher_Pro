package com.trodev.careermatcherpro.alljob;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.trodev.careermatcherpro.R;

import java.util.ArrayList;

public class AllJobActivity extends AppCompatActivity {
    /*private FloatingActionButton add_all_job_btn;*/
    RecyclerView recyclerView;
    ProgressBar progressBar;
    ArrayList<AllJobModel> model;
    AllJobAdapter adapter;
    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_job);
        /*init action bar*/
        getSupportActionBar().setTitle("সকল চাকরি");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

/*
        add_all_job_btn = findViewById(R.id.add_all_job_btn);
*/
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);

        model = new ArrayList<>();

        // database = FirebaseDatabase.getInstance();

        reference = FirebaseDatabase.getInstance().getReference().child("all_job");

        adapter = new AllJobAdapter(model, getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    progressBar.setVisibility(View.GONE);

                    AllJobModel allJobModel = dataSnapshot.getValue(AllJobModel.class);
                    model.add(0, allJobModel);

                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        /*database synced*/
        reference.keepSynced(true);

       /* add_all_job_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AllJobActivity.this, UploadAllJobActivity.class));
            }
        });*/

    }
}