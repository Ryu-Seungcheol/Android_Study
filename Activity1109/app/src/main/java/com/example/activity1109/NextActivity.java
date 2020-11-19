package com.example.activity1109;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NextActivity extends AppCompatActivity {
    Button back_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        back_home = findViewById(R.id.back_home);

        back_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                // 스택을 죽이기 위한 방법
//                finish();
                // 스택이 죽는 방법이기 때문에 중요한 정보가 앱 실행동안 유지되어야 하는 씬이라면 finish() 를 쓰면 안된다.
                // 중요하지 않은 정보라면 finish() 사용 Ok.

                // 스택을 죽이지 않고 스택을 쌓지 않는 방법
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                // FLAG 종류
                // FLAG_ACTIVITY_SINGLE_TOP : activity 가 이미 존재하면 재사용.
                // FLAG_ACTIVITY_CLEAR_TOP : activity 의 하위 activity 를 모두 제거.
                // FLAG_ACTIVITY_NEW_TASK : activity 를 새롭게 생성 (디폴트 값)


                startActivity(intent);
            }
        });
    }
}