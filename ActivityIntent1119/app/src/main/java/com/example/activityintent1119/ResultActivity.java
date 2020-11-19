package com.example.activityintent1119;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {
    Button buttonOk, buttonCancle;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        buttonOk = findViewById(R.id.buttonOk);
        buttonCancle = findViewById(R.id.buttonCancle);
        input = findViewById(R.id.input);


        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 확인 버튼이 눌리면, input 에 입력된 정보를 가지고 되돌아간다.
                Intent intent = new Intent();   // 매개변수가 없는 intent 생성.
                // input 의 정보를 INPUT 이라는 키에 담아 보내겠다.
                intent.putExtra("INPUT", input.getText().toString());
                setResult(RESULT_OK, intent);   // 정보를 MainActivity 의 onActivityResult() 로 넘긴다.
                finish();   // onDestory() 를 호출.
            }
        });


        buttonCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                setResult(RESULT_CANCELED);   // 취소했다는 정보를 넘길 때.

                // 가지고 돌아갈 정보가 없으므로, 바로 MainActivity 로 돌아가면 된다.
                finish();
            }
        });

    }
}