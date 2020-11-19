package com.example.graphic1030;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MyGraphicView extends View {

    Paint paint;
    ArrayList<MyPoints> arrayList;
    MainActivity mainActivity;
    int startX = -1, startY = -1, stopX = -1, stopY = -1;

    // 생성자
    public MyGraphicView(Context context) {
        super(context); // 넘겨받은 context 를 super(부모)에게로 던진다.
        // 여기서는 mainActivity 를 넘겨받는다. MyGraphicView 에서 setContentView(new MyGraphicView(this));가 실행될 때 넘겨받는다.
        initPaint();
        arrayList = new ArrayList<>();
        mainActivity = (MainActivity) context; // 타입 불일치. 따라서, 형변환 타입 캐스팅을 해준다.
//        Log.d("My Tag", "curShape:" + mainActivity.curShape);
        // 객체지향의 방식을 위배. 캡슐화를 위배. -> 캡슐화된 변수를 다이렉트로 접근하면 안된다.
        Log.d("My Tag", "curShape" + mainActivity.getCurShape());


    }

    public ArrayList<MyPoints> getArrayList() {
        return arrayList;
    }

    // paint 생성 설정
    public void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLUE);
    }

    // 터치 이벤트를 위한 메소드 오버라이딩 (from View)
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                if (mainActivity.getCurShape() == MainActivity.LINE || mainActivity.getCurShape() == MainActivity.CIRCLE) {
                    startX = (int)event.getX();  // 손가락으로 터치 시작 좌표 값 중 x 값을 받아온다.
                    startY = (int)event.getY();
                } else {
                    float x = event.getX();
                    float y = event.getY();
                    MyPoints points = new MyPoints(x, y, false);
                    arrayList.add(points);
                }
                break;

            case MotionEvent.ACTION_MOVE:

                if (mainActivity.getCurShape() == MainActivity.LINE || mainActivity.getCurShape() == MainActivity.CIRCLE) {
                    stopX = (int)event.getX();
                    stopY = (int)event.getY();
                } else {
                    arrayList.add(new MyPoints(event.getX(), event.getY(), true));
                }
                invalidate();   // onDraw() 를 동시 호출한다.
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.LTGRAY);

        switch (mainActivity.getCurShape()) {

            case MainActivity.LINE: // line

                canvas.drawLine(startX, startY, stopX, stopY, paint);
                break;

            case MainActivity.CIRCLE: // circle;

                int radius = (int)Math.sqrt(Math.pow(stopX - startX, 2) + Math.pow(stopY - startY, 2));
                canvas.drawCircle(startX, startY, radius, paint);
                break;

            case MainActivity.FREE_LINE: // free line

                drawFreeLine(canvas);
                break;
        }
    }


    public void drawFreeLine(Canvas canvas) {
        for (int i = 0; i<arrayList.size(); i++) {
            if (arrayList.get(i).draw){ // true 인 것만 그리겠다는 의미. (arrayList.get(i).draw) == true 와 같은 의미.
                // get(i-1) = 이전좌표에서 온 거기 때문.
                canvas.drawLine(
                        arrayList.get(i-1).getX(),
                        arrayList.get(i-1).getY(),
                        arrayList.get(i).getX(),
                        arrayList.get(i).getY(),
                        paint);
            }
        }
    }
}
