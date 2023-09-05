package com.trodev.careermatcherpro.premium_pdf;

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
import com.trodev.careermatcherpro.R;

import java.util.ArrayList;

public class GeographyActivity extends AppCompatActivity {
    /*private FloatingActionButton add_ngo_job_btn;*/
    RecyclerView recyclerView;
    ProgressBar progressBar;

    ArrayList<PremiumModel> model;
    PremiumPdfAdapter adapter;
    FirebaseDatabase database;
    DatabaseReference reference_geography;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geography);

        /*init action bar*/
        getSupportActionBar().setTitle("প্রিমিয়াম পিডিএফ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*add_ngo_job_btn = findViewById(R.id.add_ngo_job_btn);*/
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);

        model = new ArrayList<>();

        // database = FirebaseDatabase.getInstance();

        reference_geography = FirebaseDatabase.getInstance().getReference("premium").child("pdf_geography");

        adapter = new PremiumPdfAdapter(model, getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);

        reference_geography.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    progressBar.setVisibility(View.GONE);

                    PremiumModel premiumPdfModel = dataSnapshot.getValue(PremiumModel.class);
                    model.add(0, premiumPdfModel);

                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        /*database synced*/
        reference_geography.keepSynced(true);

     /*   add_ngo_job_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NGOJobActivity.this, UploadNGOJobActivity.class));
            }
        });*/
    }
}