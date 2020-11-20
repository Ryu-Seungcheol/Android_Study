package com.example.signup1119;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button buttonSign, buttonCan;
    TextView statusView;
    static final int REQUEST_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonSign = findViewById(R.id.buttonSign);
        buttonCan = findViewById(R.id.buttonCan);
        statusView = findViewById(R.id.statusView);

        buttonSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        buttonCan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(this, "취소되었습니다.", Toast.LENGTH_SHORT).show();
                // 왜??

                finish();
            }
        });
    }

    // Request 에 대한 Result 로 넘어온 intent 를 받기 위한 메서드.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 1. requestCode 체크
        if(requestCode == REQUEST_CODE) {
            // requestCode 와 일치하는 intent 가 가져온 data 사용
            String retData = data.getStringExtra("NAME");

            // 2. resultCode 체크
            if (resultCode == RESULT_OK) {
                statusView.setText(retData + " 님 환영합니다.");
                Toast.makeText(this, "가입되었습니다.", Toast.LENGTH_SHORT).show();

            } else if (resultCode == RESULT_CANCELED) {
                statusView.setText("다시 시도해주세요.");
                Toast.makeText(this, "취소되었습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}