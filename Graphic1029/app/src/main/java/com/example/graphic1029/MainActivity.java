package com.example.graphic1029;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final int LINE = 1;
    final int CIRCLE = 2;
    int curShape = LINE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        MyGraphicView mgv = new MyGraphicView(this);

        /*
         context = java 의 this 와 비슷한 개념. 하지만, this 보다 좀 더 상위 개념.(안드로이드에서 사용).
         context = 여러 앱들을 관리하는 객체.
         여기서는 하나의 클래스밖에 없으므로 this 를 context로 전달.
         mgv 는 생성된 MyGraphicView() 인스턴스를 참조하는 객체.
         따라서, 아래코드로 하는게 더 낫다.
         */

//        setContentView(mgv);
        // Custom View
        setContentView(new MyGraphicView(this));
        // MainActivity 는 공간 (앱)을 만들고, 그 안을 채우는건 setContentView() 로 한다.
        // this = MainActivity
    }


    // Option Menu 생성 메소드 오버라이딩
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0, "선그리기");    // 하드코딩이라 좋은 방법은 아니다.
        menu.add(0,2,0, "원그리기");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1: // 선
                curShape = LINE;
                break;
            case 2: // 원
                curShape = CIRCLE;
                break;
        }

        return true;
    }

    // 커스텀 뷰 작성, 터치 이벤트 발생시키기.
    class MyGraphicView extends View {

        // 시작점
        int startX = -1;
        int startY = -1;

        // 끝나는 점
        int stopX = -1;
        int stopY = -1;

        public MyGraphicView(Context context) {
            super(context);
            // 부모에게 context 를 알려줌.
        }

        // 터치이벤트 발생시키기

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    // 손가락으로 터치하면 LogCat 출력
                    Log.d("MY_TAG :", "ACTION_DOWN");
                    startX = (int)event.getX();  // 손가락으로 터치 시작 좌표 값 중 x 값을 받아온다.
                    startY = (int)event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    // 손가락으로 찍고 드래그할 경우.
                    Log.d("MY_TAG :", "ACTION_MOVE");
                case MotionEvent.ACTION_UP:
                    // 손가락으로 찍고 난 후.
                    Log.d("MY_TAG :", "ACTION_UP");
                    stopX = (int)event.getX();
                    stopY = (int)event.getY();
                    invalidate();   // 화면을 갱신. 이 메소드는 밑의 onDraw() 메소드를 호출한다.
                    break;
            }
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {  // canvas 는 MyGraphics 클래스에 자동으로 연결되어 있다.
            super.onDraw(canvas);

            Paint paint = new Paint();
            paint.setAntiAlias(true);   // 선을 부드럽게 처리
            paint.setStrokeWidth(5);    // 선 두께
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.BLUE);

            switch (curShape) { // default = LINE
                case LINE:
                    canvas.drawLine(startX, startY, stopX, stopY, paint);
                    break;
                case CIRCLE:
                    int radius = (int)Math.sqrt(Math.pow(stopX - startX, 2) + Math.pow(stopY - startY, 2));
                    // 반지름 구하기.
                    // sqrt = 제곱근
                    canvas.drawCircle(startX, stopX, radius, paint);


                    break;
            }
        }
    }
}