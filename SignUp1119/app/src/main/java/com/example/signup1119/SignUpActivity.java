package com.example.signup1119;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText nameView, emailView, phoneView;
    Button btnSign, btnCancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nameView = findViewById(R.id.nameView);
        emailView = findViewById(R.id.emailView);
        phoneView = findViewById(R.id.phoneView);

        btnSign = findViewById(R.id.btnSing);
        btnCancle = findViewById(R.id.btnCancle);

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("NAME", nameView.getText().toString());
                setResult(RESULT_OK, intent);   // RESULT_OK 라는 RESULT_CODE 와 함께 intent 를 넘긴다.
                finish();
            }
        });

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}