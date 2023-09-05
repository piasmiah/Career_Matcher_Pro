package com.trodev.careermatcherpro.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.trodev.careermatcherpro.R;

public class WebsiteActivity extends AppCompatActivity {

    private static final String TAG = "AndroidRide";
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);

        /*action bar title and back button*/
        getSupportActionBar().setTitle("Trodev Website");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

// ###########################################################
        // locate your Web ID...
        webview = findViewById(R.id.webview);

        // ###########################################################
        // WebSite Address Here
        webview.loadUrl("https://zobayerdev.github.io/trodevit/");

        // if you set this size in your website, Fixed it or don't use this
        webview.setInitialScale(90);

        //#############################################################
        // extra Code of web view
        webview.setWebViewClient(new WebViewClient());
        WebSettings mywebsetting = webview.getSettings();
        mywebsetting.setJavaScriptEnabled(true);

        webview.getSettings().setAllowFileAccess(true);
        webview.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        mywebsetting.setDomStorageEnabled(true);
        mywebsetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        mywebsetting.setUseWideViewPort(true);
        mywebsetting.setSavePassword(true);
        mywebsetting.setSaveFormData(true);
        mywebsetting.setEnableSmoothTransition(true);

        getDownload();

    }

    private void getDownload() {

        webview.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                Toast.makeText(WebsiteActivity.this, "Downloading File", Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        });

    }

}