package com.trodev.careermatcherpro.fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ShareCompat;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.trodev.careermatcherpro.AboutUsActivity;
import com.trodev.careermatcherpro.MainActivity;
import com.trodev.careermatcherpro.McqMainActivity;
import com.trodev.careermatcherpro.PrivacyActivity;
import com.trodev.careermatcherpro.R;
import com.trodev.careermatcherpro.activity.LoginActivity;
import com.trodev.careermatcherpro.activity.UserListActivity;
import com.trodev.careermatcherpro.User;

public class ProfileFragment extends Fragment {

    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;
    ImageView logout;
    LinearLayout contactLl, console_ll, rateLl, shareLl, privacyLl, cartLl, aboutLl;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        TextView nameET = view.findViewById(R.id.nameEt);
        TextView emailET = view.findViewById(R.id.emailTv);
        TextView numberET = view.findViewById(R.id.mobileTv);
        TextView passEt = view.findViewById(R.id.passTv);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);
                if (userProfile != null) {

                    String uname = userProfile.uname;
                    String email = userProfile.email;
                    String num = userProfile.num;
                    String pass = userProfile.pass;

                    nameET.setText(uname);
                    emailET.setText("E-mail: " + email);
                    numberET.setText("Mobile: " + num);
                    passEt.setText("Password: " + pass);

                    /*toast sms*/
                    Toast.makeText(getActivity(), uname + " info found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), "something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });

        logout = view.findViewById(R.id.logout_btn);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getActivity(), LoginActivity.class));
                Toast.makeText(getActivity(), "log-out successful", Toast.LENGTH_SHORT).show();
                getActivity().finishAffinity();
            }
        });

        /*init views*/
        contactLl = view.findViewById(R.id.contactLl);
        console_ll = view.findViewById(R.id.console_ll);
        rateLl = view.findViewById(R.id.rateLl);
        shareLl = view.findViewById(R.id.shareLl);
        privacyLl = view.findViewById(R.id.privacyLl);
        cartLl = view.findViewById(R.id.cartLl);
        aboutLl = view.findViewById(R.id.aboutLl);

        contactLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go_to_email();
            }
        });

        console_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go_to_console();
            }
        });

        rateLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rateUsOnGooglePlay();
            }
        });

        shareLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share_apps();
            }
        });

        privacyLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), PrivacyActivity.class));
            }
        });

        cartLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), UserListActivity.class));
            }
        });

        aboutLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AboutUsActivity.class));
            }
        });

        return view;
    }

    private void share_apps() {

        int applicationNameId = getContext().getApplicationInfo().labelRes;
        final String appPackageName = getContext().getPackageName();
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, getActivity().getString(applicationNameId));
        String text = "Career Matcher Pro";
        String link = "https://play.google.com/store/apps/details?id=" + appPackageName;
        i.putExtra(Intent.EXTRA_TEXT, text + " " + link);
        startActivity(Intent.createChooser(i, "choose share options"));

    }

    public void rateUsOnGooglePlay() {

        Uri marketUri = Uri.parse("https://play.google.com/store/apps/details?id=" + getActivity().getPackageName());
        try {
            getContext().startActivity(new Intent(Intent.ACTION_VIEW, marketUri));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getContext(), "Couldn't find PlayStore on this device", Toast.LENGTH_SHORT).show();
        }
    }

    private void go_to_email() {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"careermatcherpro@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Help of");
        intent.putExtra(Intent.EXTRA_TEXT, "Assalamualaikum, ");
        startActivity(Intent.createChooser(intent, ""));

    }

    private void go_to_console() {

        // on below line we are creating the uri to open google play store to open google maps application
        Uri uri = Uri.parse("https://play.google.com/store/apps/dev?id=6580660399707616800");
        // initializing intent with action view.
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        // set flags on below line.
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        // on below line we are starting the activity.
        startActivity(i);

    }
}