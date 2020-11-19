package com.example.activity1109;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button next, exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next = findViewById(R.id.nextBtn);
        exit = findViewById(R.id.exit);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NextActivity.class);
                startActivity(intent);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.finishAffinity(MainActivity.this);
                // 한번에 종료.
//                finish();
                // finish() 를 호출하면 onDestory 를 호출하게 된다.
            }

        });
    }
    // activity life cycle
    // activity 는 onDestroy 를 거친 후 종료된다.

// onDestroy() 를 overriding 을 하지 않으면 부모의 LifeCycle 을 따라간다.
    // activity 자체를 부모에게서 상속받기 때문.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "앱 종료", Toast.LENGTH_SHORT).show();
    }
}