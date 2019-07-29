package com.javarush.task.task25.task2515;

public class SpaceShip extends BaseObject {
    private double dx;

    public SpaceShip(double x, double y) {
        super(x, y, 3);
    }

    public void moveLeft() {
        dx = -1;
    }

    public void moveRight() {
        dx = 1;
    }

    public void move() {
        x += dx;

        checkBorders(radius, Space.game.getWidth() - radius, 0, Space.game.getHeight());
    }

    public void draw(Canvas canvas) {

    }

    public void fire() {
        Rocket rocket1 = new Rocket(x - 2, y);
        Rocket rocket2 = new Rocket(x + 2, y);

        Space.game.getRockets().add(rocket1);
        Space.game.getRockets().add(rocket2);
    }
}
