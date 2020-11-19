package com.example.activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityDataView extends AppCompatActivity {
    TextView nameView, addrView;
    Button okbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("My_Tag", "Activity_onCreate");
        setContentView(R.layout.activity_data_view);

        nameView = findViewById(R.id.nameView);
        addrView = findViewById(R.id.addrView);

        okbtn = findViewById(R.id.okbtn);

        Intent intent = getIntent();    // 받는 intent
        // getStringExtra(key) 는 putExtra(key, value) 에서 전달한 인자를 받는다.
        // key 끼리는 이름이 동일해야 한다.
        String name = intent.getStringExtra("Name");
        String address = intent.getStringExtra("Address");
        nameView.setText(name);
        addrView.setText(address);

        Log.d("My_Tag", "이름 : " + name);
        Log.d("My_Tag", "주소 : " + address);

        okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("My_Tag", "Activity_onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("My_Tag", "Activity_onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("My_Tag", "Activity_onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("My_Tag", "Activity_onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("My_Tag", "Activity_onReStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("My_Tag", "Activity_onDestroy");
    }
}