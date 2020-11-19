package com.example.optionmenu1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button ok_btn, cancel_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ok_btn = findViewById(R.id.ok_btn);
        cancel_btn = findViewById(R.id.cancel_btn);

        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 디버깅 정석 코드
                Log.d("MainActivity", "OK 버튼 클릭");
            }
        });

        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 디버깅 (옆 라인에 빨간점을 마킹 : 브레이크 포인트 -> 디버그 )
                Log.d("MainActivity", "Cancel 버튼 클릭");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        // 내가 만든 menu 를 menu 로써 화면에 붙여 사용하겠다는 의미.

        // 부모의 메서드를 사용하겠다.(메뉴) 의미
//        return super.onCreateOptionsMenu(menu);

        return true;    // 내가 만든 메서드를 사용하겠다. 부모의 메서드가 아닌, 내가 만든 것.
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // 메뉴를 선택하면 선택한 메뉴 아이템이 매개변수 item 으로 전달된다.
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_ok:
                Toast.makeText(this, "OK 동작", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_cancel:
                Toast.makeText(this, "취소 동작", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_exit:
                finish();   // 안드로이드 앱 강제 종료
                break;
        }

        // 부모의 것을 사용한다는 의미.
//        return super.onOptionsItemSelected(item);

        // 내가 정의한 대로 사용하겠다는 의미.
        return true;
    }
}