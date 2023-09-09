package com.trodev.careermatcherpro.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.trodev.careermatcherpro.R;

public class FullJobDetailsActivity extends AppCompatActivity {

    private TextView detailsTv, postNameTv, sourceTv, startDateTv, endDateTv, linkTv;
    ImageView imageView;
    String details, name, source, sDate, eDate, link, image, pdfUrl;
    LinearLayout showPdfLl;
    ProgressBar progressBar;
    CardView imageCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_job_details);

        /*action bar title*/
        getSupportActionBar().setTitle("বিস্তারিত দেখুন");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*prevent screen shot and screen recorder*/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        // pdfView = findViewById(R.id.pdfView);
        showPdfLl = findViewById(R.id.showPdfLl);
        progressBar = findViewById(R.id.progressBar);
        imageView = findViewById(R.id.imageIv);
       // imageCard = findViewById(R.id.imageCard);

        progressBar.setVisibility(View.VISIBLE);
        imageView.setVisibility(View.GONE);


        /*init views*/
        detailsTv = findViewById(R.id.detailsTv);
        postNameTv = findViewById(R.id.postNameTv);
        sourceTv = findViewById(R.id.sourceTv);
        startDateTv = findViewById(R.id.startDateTv);
        endDateTv = findViewById(R.id.endDateTv);
        linkTv = findViewById(R.id.linkTv);
        imageView = findViewById(R.id.imageIv);

        // get data from adapter
        details = getIntent().getStringExtra("details");
        name = getIntent().getStringExtra("post");
        image = getIntent().getStringExtra("image");
        source = getIntent().getStringExtra("source");
        sDate = getIntent().getStringExtra("sdate");
        eDate = getIntent().getStringExtra("edate");
        link = getIntent().getStringExtra("link");


        pdfUrl = getIntent().getStringExtra("pdfUrl");

        /*set on click listener*/
        showPdfLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FullJobDetailsActivity.this, ShowPDFActivity.class);
                intent.putExtra("pdfUrl", pdfUrl);
                startActivity(intent);
            }
        });

        /*set data on activities views*/
        detailsTv.setText(details);
        postNameTv.setText(name);
        sourceTv.setText(source);
        startDateTv.setText(sDate);
        endDateTv.setText(eDate);
        linkTv.setText(link);

        simulateDataLoading();
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