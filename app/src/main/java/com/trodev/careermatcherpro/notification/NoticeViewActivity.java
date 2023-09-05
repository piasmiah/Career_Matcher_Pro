package com.trodev.careermatcherpro.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.trodev.careermatcherpro.R;

public class NoticeViewActivity extends AppCompatActivity {

    private TextView detailsTv, jobTypeTv;
    ImageView imageView;
    String details, type, image;
    ProgressBar progressBar;
    CardView imageCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_view);

        /*action bar title*/
        getSupportActionBar().setTitle("বিস্তারিত দেখুন");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        /*init views*/
        detailsTv = findViewById(R.id.detailsTv);
        jobTypeTv = findViewById(R.id.jobTypeTv);
        imageView = findViewById(R.id.imageIv);
        progressBar = findViewById(R.id.progressBar);


        progressBar.setVisibility(View.VISIBLE);
        imageView.setVisibility(View.GONE);

        // get data from adapter
        details = getIntent().getStringExtra("details");
        type = getIntent().getStringExtra("type");
        image = getIntent().getStringExtra("image");
        simulateDataLoading();

        detailsTv.setText(details);
        jobTypeTv.setText(type);

    }

    private void simulateDataLoading() {
        // Show progress bar
        progressBar.setVisibility(View.VISIBLE);

        // Simulate data loading process
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // Data loading completed, hide progress bar
                progressBar.setVisibility(View.GONE);
                loadImage();
            }
        }, 3000); // Simulate loading for 3 seconds
    }

    private void loadImage() {

        /*get image on database and it's a fit image*/
        Picasso.get().load(image).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

                imageView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();

                /*set image on image view*/
                imageView.setImageBitmap(bitmap);
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                progressBar.setVisibility(View.GONE);
            }
        });

    }


}