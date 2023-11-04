package com.trodev.careermatcherpro.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.trodev.careermatcherpro.R;
import com.trodev.careermatcherpro.payment.PackageAdapter;
import com.trodev.careermatcherpro.payment.PackageModel;

import java.util.ArrayList;

public class OrderFragment extends Fragment {

    private RecyclerView recyclerView;
    DatabaseReference reference;
    ArrayList<PackageModel> list;
    PackageAdapter adapter;

    public OrderFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_order, container, false);


        reference = FirebaseDatabase.getInstance().getReference("package_payment");

        /*init views*/
        recyclerView = view.findViewById(R.id.cartRv);
        /*animationView = view.findViewById(R.id.animationView);
        animationView.loop(true);*/

        /*create methods*/
        load_data();

        return view;

    }

    private void load_data() {

        //child("Premium_Packages").
        Query query = reference.orderByChild("uID").equalTo(FirebaseAuth.getInstance().getCurrentUser().getUid());
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    //animationView.setVisibility(View.VISIBLE);
                    Toast.makeText(getContext(), "no data found", Toast.LENGTH_SHORT).show();
                } else {
                    recyclerView.setVisibility(View.VISIBLE);
                   // animationView.setVisibility(View.GONE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        PackageModel data = snapshot.getValue(PackageModel.class);
                        list.add(0, data);

                    }
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new PackageAdapter(list, getContext());
                    recyclerView.setAdapter(adapter);
                    Toast.makeText(getContext(), "found data", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}