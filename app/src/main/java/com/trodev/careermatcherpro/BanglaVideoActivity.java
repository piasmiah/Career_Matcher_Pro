package com.trodev.careermatcherpro;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class BanglaVideoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<TubeModel> list1 ;
    private TubeAdapter adapter;
    private DatabaseReference reference, dbRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangla_video);




        /*init recyclerview*/
        recyclerView = findViewById(R.id.recyclerView);

        /*database path*/
        // firebase
        reference = FirebaseDatabase.getInstance().getReference().child("career_tube");

        bangla();



    }

    private void bangla() {

        dbRef = reference.child("বাংলা");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if(!dataSnapshot.exists())
                {
                    recyclerView.setVisibility(View.VISIBLE); // change

                }
                else
                {


                    recyclerView.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TubeModel data = snapshot.getValue(TubeModel.class); // eikhane sob student hobe teacher thakle
                        list1.add(data);
                    }
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(BanglaVideoActivity.this));
                    adapter = new TubeAdapter(list1,BanglaVideoActivity.this);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(BanglaVideoActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}