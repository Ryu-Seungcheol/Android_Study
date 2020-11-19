package com.example.graphic1103;

public class MyPoint {
    float x;
    float y;
    boolean draw;
    float width;
    int color;

    public MyPoint(float x, float y, boolean draw, float width, int color) {
        this.x = x;
        this.y = y;
        this.draw = draw;
        this.width = width;
        this.color = color;
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

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
