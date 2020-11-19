package com.example.activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText nameText, addrText;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("My_Tag", "mainActivity_onCreate");
        nameText = findViewById(R.id.nameText);
        addrText = findViewById(R.id.addrText);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityDataView.class);
                /*
                putExtra(key, value);
                 */
                String strName = nameText.getText().toString();
                String strAddr = addrText.getText().toString();
                intent.putExtra("Name", strName);
                intent.putExtra("Address", strAddr);
                // intent.putExtra(key, value); 로 넘긴 값을 가지고 startActivity(intent); 로 대상 class 에 넘어간다.
                // 오버로딩 된 메소드. cmd + b 로 확인가능.
                // putExtra(key, value) 로 넘기면 받는 Activity 에서는 getTypeExtra(key) 로 받는다.
                // ex) putExtra("Name", strName) = String Type 이므로, getStringExtra(Name) 로 받는다.
                Log.d("My_Tag", "이름 : " + strName);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("My_Tag", "MainActivity_onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("My_Tag", "MainActivity_onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("My_Tag", "MainActivity_onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("My_Tag", "MainActivity_onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("My_Tag", "MainActivity_onReStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("My_Tag", "MainActivity_onDestroy");
    }
}