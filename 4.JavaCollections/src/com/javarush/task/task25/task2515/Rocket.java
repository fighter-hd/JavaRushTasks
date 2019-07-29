package com.javarush.task.task25.task2515;

public class Rocket extends BaseObject {

    public Rocket(double x, double y) {
        super(x, y, 1);
    }

    /**
     * Отрисовываем себя на холсте.
     */
    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'R');
    }

    /**
     * Двигаем себя вверх на один ход.
     */
    @Override
    public void move() {
        y--;
    }
}
