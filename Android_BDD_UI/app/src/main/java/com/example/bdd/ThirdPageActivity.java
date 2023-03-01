package com.example.bdd;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdPageActivity extends AppCompatActivity {

    Context mContext = ThirdPageActivity.this;
    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Toast.makeText(mContext, "Hi yummly", Toast.LENGTH_SHORT).show();

        webview = findViewById(R.id.webview1);

        webview.loadUrl("https://www.yummly.com/");

    }

}