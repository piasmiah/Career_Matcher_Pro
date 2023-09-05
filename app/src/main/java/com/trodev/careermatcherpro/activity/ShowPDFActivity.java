package com.trodev.careermatcherpro.activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.trodev.careermatcherpro.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ShowPDFActivity extends AppCompatActivity {
    private String pdfUrl;
    PDFView pdfView;
    ProgressDialog progressDialog;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pdfactivity);

        /*action bar title*/
        getSupportActionBar().setTitle("পিডিএফ দেখুন");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*get data on govtAdapter, NonGovtAdapter, TeacherAdapter*/
        pdfUrl = getIntent().getStringExtra("pdfUrl");

        /*web view*/
        //  webView = findViewById(R.id.webView);
        pdfView = findViewById(R.id.pdfView);


/*        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);*/

        /*progress dialog show and init*/
        progressDialog = new ProgressDialog(ShowPDFActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog = ProgressDialog
                .show(this,
                        "পিডিএফ লোড হচ্ছে",
                        "কিছুক্ষণ অপেক্ষা করুন");
        progressDialog.show();
/*
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(ShowPDFActivity.this, "Error:" + description, Toast.LENGTH_SHORT).show();
            }
        });

        *//*load web*//*
        webView.loadUrl(pdfUrl);*/

        new PdfDownload().execute(pdfUrl);

    }

    private class PdfDownload extends AsyncTask<String, Void, InputStream> {
        @Override
        protected InputStream doInBackground(String... strings) {

            InputStream inputStream = null;

            try {
                progressDialog.show();
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                if (urlConnection.getResponseCode() == 200) {
                    progressDialog.show();
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            progressDialog.hide();
            pdfView.fromStream(inputStream).load();
        }
    }
}