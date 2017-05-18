package com.proyectodai.hokit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Investigar extends AppCompatActivity {
    WebView wv;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investigar);
        wv= (WebView)findViewById(R.id.wvRae);
        wv.loadUrl("http://dle.rae.es/?w=diccionario");
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}
