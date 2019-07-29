package com.javarush.task.task25.task2515;

public class Bomb extends BaseObject {

    public Bomb(double x, double y) {
        super(x, y, 1);
    }

    public void move() {
        this.y += 1;
    }


    public void draw(Canvas canvas) {
        canvas.setPoint(this.x, this.y, 'B');
    }
}
