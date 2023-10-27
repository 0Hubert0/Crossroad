package com.example;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Car {
    private double v=0, y, x, changeOfVelocity;
    private int height=30, width=15;
    private Paint color;

    public Car(int direction, double x, double y) {
        this.x=x;
        this.y=y;
        this.changeOfVelocity=(Math.random()*0.2)+0.03;
        this.color = new Color(Math.random(), Math.random(), Math.random(), 1);
        if(direction==3 || direction==4)
        {
            int temp=height;
            height=width;
            width=temp;
        }
    }

    public Paint getColor() {
        return color;
    }

    public double getChangeOfVelocity() {
        return changeOfVelocity;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setV(double v) {
        this.v = v;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public double getV() {
        return v;
    }

    public void accelerate()
    {
        v+=changeOfVelocity;
    }

    public void decelerate()
    {
        v-=changeOfVelocity;
    }
}
