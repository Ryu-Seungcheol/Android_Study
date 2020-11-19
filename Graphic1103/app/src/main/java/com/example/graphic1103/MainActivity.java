package com.example.graphic1103;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    public static final int LINE = 1;
    public static final int CIRCLE = 2;
    public static final int FREE_LINE = 3;
    public static final int PAINT = 4;
    int curShape = FREE_LINE;
    MyGraphicView v;
    File file;


    public int getCurShape() {
        return curShape;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        v = new MyGraphicView(this);
        setContentView(v);
        //setContentView(new MyGraphicView(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        v.invalidate();
        v.clearPostion();

        switch (id) {
            case R.id.line:
                curShape = LINE;
                Toast.makeText(this, "선 그리기", Toast.LENGTH_SHORT).show();
                break;
            case R.id.circle:
                curShape = CIRCLE;
                Toast.makeText(this, "원 그리기", Toast.LENGTH_SHORT).show();
                break;
            case R.id.freeLine:
                v.getArrayList().clear();
                curShape = FREE_LINE;
                v.setCurMode("draw");
                Toast.makeText(this, "그림 그리기", Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit:
                finish();
                break;
            case R.id.width5:
                v.setCurWidth(5);
                break;
            case R.id.width10:
                v.setCurWidth(10);
                break;
            case R.id.width20:
                v.setCurWidth(20);
                break;
            case R.id.width30:
                v.setCurWidth(30);
                Log.d("My_Tag", "onOptionItemSelected()_width" + v.getPaint().getStrokeWidth());
                Toast.makeText(this, "굵기30", Toast.LENGTH_SHORT).show();
                break;
            case R.id.black:
                v.setCurColor(Color.BLACK);
                Toast.makeText(this, "검정 색상", Toast.LENGTH_SHORT).show();
                break;
            case R.id.blue:
                v.setCurColor(Color.BLUE);  // paint 객체를 거치지 않고, 바로 다이렉트로 값을 넘겨주기.
                break;
            case R.id.red:
                v.setCurColor(Color.RED);
                break;
            case R.id.green:
                v.setCurColor(Color.GREEN);
                break;
            case R.id.save:
                Toast.makeText(this, "이미지로 저장했습니다.", Toast.LENGTH_SHORT).show();
                ImageSave save = new ImageSave(this);
                file = save.imgFileSave(v); //imgFileSave() 메소드는 File 클래스를 return 한다.
                Log.d("My_Tag : ", "파일 경로 : " + file.getAbsolutePath());    // 절대경로
                break;

            case R.id.paint:    // 색칠하기
                v.setCurMode("paint");
                Toast.makeText(this, "색칠하기", Toast.LENGTH_SHORT).show();
                curShape = PAINT;
                break;
            case R.id.load:     // 파일 불러오기
                v.setCurMode("loadPaint");
                Toast.makeText(this, "이미지를 불러왔습니다.", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    public String savedFilePath() {
        return file.getAbsolutePath();
    }


}