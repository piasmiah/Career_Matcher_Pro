package com.trodev.careermatcherpro.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.trodev.careermatcherpro.OrderPagerAdapter;
import com.trodev.careermatcherpro.R;
import com.trodev.careermatcherpro.User;
import com.trodev.careermatcherpro.mcq_part.bangla.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class UserListActivity extends AppCompatActivity {

/*    RecyclerView Rv;
    DatabaseReference reference;
    UserListAdapter adapter;
    List<User> userList;*/

    TabLayout tab;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

/*        Rv = findViewById(R.id.Rv);
        Rv.setHasFixedSize(true);
        Rv.setLayoutManager(new LinearLayoutManager(this));

        userList = new ArrayList<>();*/

        /*create methods*/


        getSupportActionBar().setTitle("বাংলা ভাষা ও সাহিত্য");

        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);

        /*load data on this activity*/
        load_data();

    }

    private void load_data() {

        OrderPagerAdapter adapter = new OrderPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tab.setupWithViewPager(viewPager);

       /* FirebaseUser fUser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");

        *//*all value dekhanor jonno register users*//*
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                userList.clear();

                for(DataSnapshot ds: dataSnapshot.getChildren())
                {
                    User modelUser = ds.getValue(User.class);

                    if (modelUser != null && !modelUser.getEmail().equals(fUser.getUid())) {
                        userList.add(modelUser);
                    }

                    // adapters
                    adapter = new UserListAdapter(UserListActivity.this, userList);
                    Rv.setAdapter(adapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

    }
}