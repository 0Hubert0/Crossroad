package com.example;

import java.util.ArrayList;

public class Lane {
    private ArrayList<Car> cars = new ArrayList<>();
    private int direction;
    private double x, y;

    public Lane(int direction, double x, double y) {
        this.direction = direction;
        this.x=x;
        this.y=y;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public int getDirection() {
        return direction;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void add()
    {
        switch (direction)
        {
            case 1:
                cars.add(new Car(direction, x, 605+Math.random()*30));
                break;
            case 2:
                cars.add(new Car(direction, x, -45-Math.random()*30));
                break;
            case 3:
                cars.add(new Car(direction, -45-Math.random()*30, y));
                break;
            case 4:
                cars.add(new Car(direction, 905+Math.random()*30, y));
                break;
        }

    }

    public void remove()
    {
        cars.remove(0);
    }
}
