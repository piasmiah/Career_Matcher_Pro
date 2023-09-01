package com.trodev.careermatcherpro.bcs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.trodev.careermatcherpro.R;

import java.util.ArrayList;

public class BCSQuestionAnswerActivity extends AppCompatActivity {
/*
    private FloatingActionButton add_bcs_question;
*/
    RecyclerView recyclerView;
    ProgressBar progressBar;
    DatabaseReference reference;
    ArrayList<BCSModel> model;
    BCSAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bcsquestion_answer);

        /*action bar title*/
        getSupportActionBar().setTitle("বিসিএস প্রশ্ন এবং উত্তর");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*init views all*/
/*
        add_bcs_question = findViewById(R.id.add_bcs_question);
*/
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        model = new ArrayList<>();

        /*adapter set on model*/
        adapter = new BCSAdapter(model, getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);

        /*database child and get data from database*/
        reference = FirebaseDatabase.getInstance().getReference().child("bcs_question");


        /*data view on firebase database get data from on reference*/
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    progressBar.setVisibility(View.GONE);

                    BCSModel govtModel = dataSnapshot.getValue(BCSModel.class);
                    model.add(0, govtModel);
                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        reference.keepSynced(true);

    /*    add_bcs_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BCSQuestionAnswerActivity.this, UploadBCSQuestionActivity.class));
            }
        });*/
    }
}
