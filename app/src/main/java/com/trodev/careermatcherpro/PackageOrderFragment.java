package com.trodev.careermatcherpro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.trodev.careermatcherpro.payment.PackageAdapter;
import com.trodev.careermatcherpro.payment.PackageModel;

import java.util.ArrayList;

public class PackageOrderFragment extends Fragment {

    RecyclerView recyclerView;
    DatabaseReference reference;
    ArrayList<PackageModel> list;
    PackageAdapter adapter;
    LottieAnimationView animationView;

    public PackageOrderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_package_order, container, false);

        /*init database and path also*/
        reference = FirebaseDatabase.getInstance().getReference("package_payment");

        /*init views*/
        recyclerView = view.findViewById(R.id.cartRv);
        animationView = view.findViewById(R.id.animationView);
        animationView.loop(true);

        /*set list on arraylist*/
        list = new ArrayList<>();

        /*create methods*/
        load_data();

        return view;

    }

    private void load_data() {

        /*we run a query because we need uid base data*/
        Query query = reference.child("package").orderByChild(FirebaseAuth.getInstance().getCurrentUser().getUid());
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (!dataSnapshot.exists()) {

                    animationView.setVisibility(View.VISIBLE);
                    Toast.makeText(getContext(), "cart item is empty", Toast.LENGTH_SHORT).show();

                } else {

                    /*first of all we clear list*/
                    list.clear();
                    recyclerView.setVisibility(View.VISIBLE);
                    animationView.setVisibility(View.GONE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        PackageModel data = snapshot.getValue(PackageModel.class);
                        list.add(0, data);
                    }
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new PackageAdapter(getContext(), list, "package");
                    recyclerView.setAdapter(adapter);
                    Toast.makeText(getContext(), "Package cart item is available", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}