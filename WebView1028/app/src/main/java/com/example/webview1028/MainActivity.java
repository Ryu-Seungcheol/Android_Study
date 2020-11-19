package com.example.webview1028;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button backBtn, goBtn;
    EditText editUrl;
    WebView viewWind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backBtn = findViewById(R.id.backBtn);
        goBtn = findViewById(R.id.goBtn);

        editUrl = findViewById(R.id.editUrl);
        viewWind = findViewById(R.id.viewWind);

        // 익명객체. 객체를 생성한 후 setWebViewClient() 에 전달.
        // WebView(viewWind) 초기 설정.
        viewWind.setWebViewClient(new MyWebViewClient());
        WebSettings webSettings = viewWind.getSettings();
        webSettings.setBuiltInZoomControls(true);

        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewWind.loadUrl(editUrl.getText().toString());
            }
        });

        // 람다
//        backBtn.setOnClickListener(v -> viewWind.goBack());

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewWind.goBack();
            }
        });
    }

    // inner class. (단순한 기능들을 활용하고자 할 때 주로 사용)
    class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}