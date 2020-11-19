package com.example.activityintent1119;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    static final int REQUEST_CODE_TEST = 1000;      // 임의로 지정.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
//                startActivity(Intent);    // 값을 넘길 때는 startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE_TEST);
                // REQUEST_CODE : 어디서 (또는 어디로) 넘어가는지 구분하기 위한 code. swift 의 segue id 와 비슷?
                /*
                지정된 intent 로 REQUEST_CODE_TEST 를 가지고 넘엄간 후, 거기거 가져오는 정보는 아래의 onActivityResult() 에 맞게 가져온다.
                 */

            }
        });
    }

    // ResultActivity 에서 넘긴 정보를 받는 메서드.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {   // Intent data 로 정보를 전달받는다.
        super.onActivityResult(requestCode, resultCode, data);

        // 1. requestCode 를 체크.
        if(requestCode == REQUEST_CODE_TEST) {
            String retData = data.getStringExtra("INPUT");

            // 2. resultCode 로 성공인지, 실패인지 확인
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, retData + " 정보 수신! ", Toast.LENGTH_SHORT).show();
                textView.setText(retData);
            }
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "인텐트 정보 받기 취소!", Toast.LENGTH_SHORT).show();
        }
    }
}