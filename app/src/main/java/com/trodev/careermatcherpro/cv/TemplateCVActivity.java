package com.trodev.careermatcherpro.cv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.trodev.careermatcherpro.PremiumAdapter;
import com.trodev.careermatcherpro.R;

import java.util.ArrayList;

public class TemplateCVActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProgressBar progressBar;
    ArrayList<TemplateModel> model;
    PremiumAdapter adapter;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template_cvactivity);

        /*init action bar*/
        getSupportActionBar().setTitle("প্রিমিয়াম CV টেম্পলেট");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*add_ngo_job_btn = findViewById(R.id.add_ngo_job_btn);*/
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        model = new ArrayList<>();


        reference = FirebaseDatabase.getInstance().getReference().child("cv_template");

        adapter = new PremiumAdapter(model, getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    progressBar.setVisibility(View.GONE);

                    TemplateModel templateModel = dataSnapshot.getValue(TemplateModel.class);
                    model.add(templateModel);

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