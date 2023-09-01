package com.trodev.careermatcherpro.bank_que;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

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

public class BankQuestionAnswerActivity extends AppCompatActivity {

    /*private FloatingActionButton add_bank_question;*/
    RecyclerView recyclerView;
    ProgressBar progressBar;
    DatabaseReference reference;

    ArrayList<BankQueModel> model;
    BankQueAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_question_answer);

        /*action bar title*/
        getSupportActionBar().setTitle("ব্যাংক জব প্রশ্ন এবং উত্তর");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*init views all*/
/*
        add_bank_question = findViewById(R.id.add_bank_question);
*/
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        model = new ArrayList<>();

        /*adapter set on model*/
        adapter = new BankQueAdapter(model, getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);

        /*database child and get data from database*/
        reference = FirebaseDatabase.getInstance().getReference().child("bank_job_question");

        /*data view on firebase database get data from on reference*/
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    progressBar.setVisibility(View.GONE);

                    BankQueModel bankQueModel = dataSnapshot.getValue(BankQueModel.class);
                    model.add(0, bankQueModel);
                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        reference.keepSynced(true);

       /* add_bank_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(BankQuestionAnswerActivity.this, UploadBankQuestionActivity.class));
                Toast.makeText(BankQuestionAnswerActivity.this, "ব্যাংক জবের প্রশ্ন এবং উত্তর পাবলিশ করেন", Toast.LENGTH_SHORT).show();

            }
        });*/

    }
}