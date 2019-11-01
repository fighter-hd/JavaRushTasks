package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Player extends CollisionObject implements Movable {

    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        int width = this.getWidth();
        int height = this.getHeight();
        int x = this.getX() - width / 2;
        int y = this.getY() - height / 2;

        graphics.setColor(Color.green);
        graphics.fillOval(x, y, width, height);
    }

    @Override
    public void move(int x, int y) {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }
}
