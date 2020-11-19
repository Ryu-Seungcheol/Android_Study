package com.example.graphic1103;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MyGraphicView extends View {
    Paint paint;
    ArrayList<MyPoint> arrayList = new ArrayList<>();
    MainActivity mainActivity;
    int startX=-1, startY=-1, stopX=-1, stopY=-1;
    int curColor = Color.BLACK;         // 현재 색상
    float curWidth = 5;                     // 현재 굵기
    String curMode = "draw";

    public MyGraphicView(Context context) {
        super(context);
        initPaint();
        mainActivity = (MainActivity) context;
        Log.d("MY_TAG", "curShape: " + mainActivity.getCurShape());
    }

    public ArrayList<MyPoint> getArrayList() {
        return arrayList;
    }

    public void setCurColor(int color) {
        // paint 객체를 사용하지 않고, 옵션메뉴에서 전달된 값을 다이렉트로 가져오기.
        this.curColor = color;
    }

    public void setCurWidth(float stroke) {
        this.curWidth = stroke;
    }

    public void setCurMode(String mode) {
        curMode = mode;
    }

    public void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(1);
        paint.setColor(Color.BLACK);
    }

    public Paint getPaint() {
        return paint;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (mainActivity.getCurShape() == MainActivity.LINE ||
                        mainActivity.getCurShape() == MainActivity.CIRCLE) {
                    startX = (int) event.getX();
                    startY = (int) event.getY();
                }
                else {
                    float x = event.getX();
                    float y = event.getY();
                    MyPoint point = new MyPoint(x, y, false, curWidth, curColor);
                    arrayList.add(point);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (mainActivity.getCurShape() == MainActivity.LINE ||
                        mainActivity.getCurShape() == MainActivity.CIRCLE) {
                    stopX = (int) event.getX();
                    stopY = (int) event.getY();

                }
                else {
                    arrayList.add(new MyPoint(event.getX(), event.getY(), true, curWidth, curColor));
                    Log.d("My_Tag", "onTouchEvent()_width" + paint.getStrokeWidth());
                }
                invalidate();
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);   // 상속받아 왔기 때문에, 안정성을 위해 남겨두기도 한다.
        // But, return 할 때에는 삭제해야 한다.
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.apeach);
//        int x = (getWidth() - bitmap.getWidth()) / 2;
//        int y = (getHeight() - bitmap.getHeight()) / 2;
//        canvas.drawBitmap(bitmap, x, y, null);
//        bitmap.recycle();

        Log.d("My_Tag :", "curMode : " + curMode);
        if (curMode.equals("paint")) {
            drawBackground(canvas);
            drawFreeLine(canvas);
        } else if (curMode.equals("draw")) {
            canvas.drawColor(Color.LTGRAY);
        } else if (curMode.equals("loadPaint")) {

        }

        switch (mainActivity.getCurShape()) {
            case MainActivity.LINE: // line
                canvas.drawLine(startX, startY, stopX, stopY, paint);
                break;
            case MainActivity.CIRCLE: // circle
                int radius = (int)Math.sqrt(Math.pow(stopX - startX, 2) +
                        Math.pow(stopY - startY, 2));
                canvas.drawCircle(startX, startY, radius, paint);
                break;
            case MainActivity.FREE_LINE: // free line
                drawFreeLine(canvas);
                break;
        }
    }

    public void drawBackground(Canvas canvas) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.apeach);
        Log.d("My_Tag : ", "background success" + bitmap);
        int x = (getWidth() - bitmap.getWidth()) / 2;
        int y = (getHeight() - bitmap.getHeight()) / 2;
        canvas.drawBitmap(bitmap, x, y, null);
        bitmap.recycle();
    }

    public void loadBackground(Canvas canvas) {
        Bitmap bitmap = BitmapFactory.decodeFile(mainActivity.savedFilePath());
        Log.d("My_Tag : ", "background success" + bitmap);
        int x = (getWidth() - bitmap.getWidth()) / 2;
        int y = (getHeight() - bitmap.getHeight()) / 2;
        canvas.drawBitmap(bitmap, x, y, null);
        bitmap.recycle();
    }

    public void drawFreeLine(Canvas canvas) {
        for (int i=0; i<arrayList.size(); i++) {
            if (arrayList.get(i).draw == true) {
                paint.setColor(arrayList.get(i).getColor());
                float width = arrayList.get(i).getWidth();
                paint.setStrokeWidth(width);
                Log.d("My_Tag", "drawFreeLine()_width" + width);
                canvas.drawLine(
                        arrayList.get(i-1).getX(),
                        arrayList.get(i-1).getY(),
                        arrayList.get(i).getX(),
                        arrayList.get(i).getY(), paint);
//                Log.d("My_Tag", "색상: " +  paint.getColor());
            }
        }
    }

    public void clearPostion() {
        startX = -1;
        startY = -1;
        stopX = -1;
        stopY = -1;
    }
}