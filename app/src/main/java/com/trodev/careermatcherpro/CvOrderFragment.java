package com.trodev.careermatcherpro;

import android.os.Bundle;

import androidx.annotation.NonNull;
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
import com.trodev.careermatcherpro.cv.CvPaymentAdapter;
import com.trodev.careermatcherpro.cv.UserModel;
import com.trodev.careermatcherpro.payment.PackageAdapter;
import com.trodev.careermatcherpro.payment.PackageModel;

import java.util.ArrayList;


public class CvOrderFragment extends Fragment {

    RecyclerView recyclerView;
    DatabaseReference reference;
    ArrayList<UserModel> list;
    CvPaymentAdapter adapter;
    LottieAnimationView animationView;

    public CvOrderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cv_order, container, false);

        /*init database and path also*/
        reference = FirebaseDatabase.getInstance().getReference("user_cv");

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

        // child("package")
        /*we run a query because we need uid base data*/
        Query query = reference.orderByChild(FirebaseAuth.getInstance().getCurrentUser().getUid());
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
                        UserModel data = snapshot.getValue(UserModel.class);
                        list.add(0, data);
                    }
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new CvPaymentAdapter(list, getContext());
                    recyclerView.setAdapter(adapter);
                    Toast.makeText(getContext(), "Cv cart item is available", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}