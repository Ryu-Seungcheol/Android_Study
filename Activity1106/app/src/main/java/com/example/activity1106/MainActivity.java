package com.example.activity1106;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button start, setting, score, exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.game_start);
        setting = findViewById(R.id.game_setting);
        score = findViewById(R.id.game_score);
        exit = findViewById(R.id.game_exit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 4대 컴포넌트들 사이에서 정보를 넘기기 위한 키워드.
                // getApplicationContext() : 현재 위치 정보에서
                // StartActivity.class : 이동할 대상 정보. (StartActivity 클래스의 정보)
                // startActivity(intent) : 이동할 대상으로 이동한다. (Activity 안에서만 사용 가능.)
                Intent intent = new Intent(getApplicationContext(),
                        StartActivity.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        SettingActivity.class);
                startActivity(intent);
            }
        });

        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        ScoreActivity.class);
                startActivity(intent);
            }
        });
    }
}