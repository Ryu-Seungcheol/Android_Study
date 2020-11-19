package com.example.calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity {
    EditText firstInput, secondInput;
    TextView outputView;

    Button plusButton, minusButton, multipleButton, divideButton;

    public int plus(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public int multiple(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) { return a / b; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstInput = findViewById(R.id.firstInput);
        secondInput = findViewById(R.id.secondInput);
        outputView = findViewById(R.id.outputView);

        plusButton = findViewById(R.id.plusButton);
        minusButton = findViewById(R.id.minusButton);
        multipleButton = findViewById(R.id.multipleButton);
        divideButton = findViewById(R.id.divideButton);

        String firstText = firstInput.getText().toString();
        String secondText = secondInput.getText().toString();
        int firstNum = Integer.parseInt(firstText);
        int secondNum = Integer.parseInt(secondText);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                outputView.setText(plus(firstNum, secondNum));
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                outputView.setText(minus(firstNum, secondNum));
            }
        });

        multipleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                outputView.setText(multiple(firstNum, secondNum));
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                outputView.setText(divide(firstNum, secondNum));
            }
        });
    }
}