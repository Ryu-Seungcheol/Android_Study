package com.example.graphic1030;

// 데이터 클래스. (모델)
// 선을 긋는 동안 생겨나는 점들을 저장하는 객체.
// 하나의 점당 하나의 객체가 된다.
public class MyPoints { // 좌표값을 저장할 클래스
    // 좌표값을 저장할 변수.
    float x;
    float y;
    boolean draw;   // 그릴지 말지를 결정.

    // cmd + N
    public MyPoints(float x, float y, boolean draw) {
        this.x = x;
        this.y = y;
        this.draw = draw;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public boolean isDraw() {
        return draw;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }
}
