package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Box extends CollisionObject implements Movable {

    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        int width = this.getWidth();
        int height = this.getHeight();
        int x = this.getX() - width / 2;
        int y = this.getY() - height / 2;

        graphics.setColor(Color.ORANGE);
        graphics.fillRect(x, y, width, height);

//        graphics.setColor(Color.BLACK);
//        graphics.drawRect(x, y, width, height);
//
//        int x1 = x;
//        int y1 = y;
//        int x2 = x1 + width;
//        int y2 = y1 + height;
//        graphics.drawLine(x1, y1, x2, y2);
//        graphics.drawLine(x2, y1, x1, y2);
    }

    @Override
    public void move(int x, int y) {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }
}
