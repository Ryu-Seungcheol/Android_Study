package com.example.calculation_edit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText firstInput, secondInput;
    Button plusButton, subButton, multiButton, divButton;
    TextView outputView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstInput = findViewById(R.id.firstInput);
        secondInput = findViewById(R.id.secondInput);

        plusButton = findViewById(R.id.plusButton);
        subButton = findViewById(R.id.subButton);
        multiButton = findViewById(R.id.multiButton);
        divButton = findViewById(R.id.divButton);

        outputView = findViewById(R.id.outputView);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstInputText = firstInput.getText().toString();
                String secondInputText = secondInput.getText().toString();

                int firstNum = Integer.parseInt(firstInputText);
                int secondNum = Integer.parseInt(secondInputText);
                int total = firstNum + secondNum;
                // 디버그 하기
                Log.d("MainActivity", "덧셈 결과값 : " + total);
                outputView.setText(total+"");
                // 자바에서는 숫자+"" 을 하면 문자열로 변환된다.
            }
        });

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstInputText = firstInput.getText().toString();
                String secondInputText = secondInput.getText().toString();

                int firstNum = Integer.parseInt(firstInputText);
                int secondNum = Integer.parseInt(secondInputText);
                int total = firstNum - secondNum;
                // 디버그 하기
                Log.d("MainActivity", "뺄셈 결과값 : " + total);
                outputView.setText(total+"");
                // 자바에서는 숫자+"" 을 하면 문자열로 변환된다.
            }
        });

        multiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstInputText = firstInput.getText().toString();
                String secondInputText = secondInput.getText().toString();

                int firstNum = Integer.parseInt(firstInputText);
                int secondNum = Integer.parseInt(secondInputText);
                int total = firstNum * secondNum;
                // 디버그 하기
                Log.d("MainActivity", "곱셈 결과값 : " + total);
                outputView.setText(total+"");
                // 자바에서는 숫자+"" 을 하면 문자열로 변환된다.
            }
        });

        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstInputText = firstInput.getText().toString();
                String secondInputText = secondInput.getText().toString();

                int firstNum = Integer.parseInt(firstInputText);
                int secondNum = Integer.parseInt(secondInputText);
                double total = firstNum / secondNum;
                // 디버그 하기
                Log.d("MainActivity", "나눗셈 결과값 : " + total);
                outputView.setText(total+"");
                // 자바에서는 숫자+"" 을 하면 문자열로 변환된다.
            }
        });
    }
}