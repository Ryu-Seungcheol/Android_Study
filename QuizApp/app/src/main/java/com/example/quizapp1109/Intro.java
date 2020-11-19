package com.example.quizapp1109;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Intro extends AppCompatActivity {

    Handler handler;

    // runnable 객체를 사용해 스레드 사용.
    // Intro 가 실행된 후, mainActivity 를 실행시켜야 하므로, 순서를 바꿔줘야 한다.
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();   // 인트로 실행 후 필요없어지므로, finish() 를 해준다.
        }
    };

    // activity 의 시작.
    @Override
    protected void onCreate(Bundle savedInstanceState) {    // onCreate() 가 java 의 main() 역할을 한다.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        getSupportActionBar().hide();   // actionBar 를 숨겨 Full 화면으로 출력한다.
        handler = new Handler();
        handler.postDelayed(runnable, 2000);    // 2초 후에 runnable 을 실행. 기기의 성능 차이로 시간 편차는 존재.

    }
    // 스레드는 한 번 생성하면 제거해주지 않는한, 계속 살아있으므로, 사용 후 스레드는 제거해줘야 한다. (db, 파일업로드 등 제거)

    // activity 의 마지막(종료).
    // run() 의 finish() 메소드가 이 메소드를 호출한다.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // runnable 을 호출해 제거한다.
        handler.removeCallbacks(runnable);
    }
}