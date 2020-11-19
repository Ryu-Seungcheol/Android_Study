package com.example.graphic1030;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int LINE = 1;
    public static final int CIRCLE = 2;
    public static final int FREE_LINE = 3;
    int curShape = LINE;
    MyGraphicView v;

    public int getCurShape() {
        return curShape;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        v = new MyGraphicView(this);
        setContentView(v);
        // MainActivity 의 정보를 this 로 넘겨줌.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        v.invalidate();
        switch (id) {
            case R.id.line:
                curShape = LINE;
                Toast.makeText(this, "선그리기", Toast.LENGTH_SHORT).show();
                break;
            case R.id.circle:
                curShape = CIRCLE;
                Toast.makeText(this, "원그리기", Toast.LENGTH_SHORT).show();
                break;
            case R.id.freeline:
                curShape = FREE_LINE;
//                v.arrayList.clear();    // 객체 지향의 캡슐화를 위배.
                v.getArrayList().clear();   // 캡슐화에 의거한 코드.
                Toast.makeText(this, "그리기", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }


}