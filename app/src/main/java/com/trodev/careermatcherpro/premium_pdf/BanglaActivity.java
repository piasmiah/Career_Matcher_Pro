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
import com.trodev.careermatcherpro.premium_pdf.PremiumPdfAdapter;
import com.trodev.careermatcherpro.R;
import com.trodev.careermatcherpro.premium_pdf.PremiumPdf;

import java.util.ArrayList;

public class BanglaActivity extends AppCompatActivity {
    /*private FloatingActionButton add_ngo_job_btn;*/
    RecyclerView recyclerView;
    ProgressBar progressBar;

    ArrayList<PremiumPdf> model;
    PremiumPdfAdapter adapter;
    FirebaseDatabase database;
    DatabaseReference reference_bangla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangla);
        /*init action bar*/
        getSupportActionBar().setTitle("সকল এনজিও চাকরি");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*add_ngo_job_btn = findViewById(R.id.add_ngo_job_btn);*/
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);

        model = new ArrayList<>();

        // database = FirebaseDatabase.getInstance();

        reference_bangla = FirebaseDatabase.getInstance().getReference("premium").child("pdf_bangla");

        adapter = new PremiumPdfAdapter(model, getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);

        reference_bangla.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    progressBar.setVisibility(View.GONE);

                    PremiumPdf premiumPdf = dataSnapshot.getValue(PremiumPdf.class);
                    model.add(0, premiumPdf);

                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        /*database synced*/
        reference_bangla.keepSynced(true);

     /*   add_ngo_job_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NGOJobActivity.this, UploadNGOJobActivity.class));
            }
        });*/

    }
}