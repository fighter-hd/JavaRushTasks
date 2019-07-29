package com.javarush.task.task25.task2515;

import java.util.Random;

public class Ufo extends BaseObject {
    //картинка НЛО для отрисовки
    private static int[][] matrix = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 0, 1, 0, 1},
            {1, 1, 1, 1, 1},
    };

    //вектор движения (-1 верх,+1 вниз)
    private double dy = Math.random() * 2 - 1; //-1..1

    //вектор движения (-1 влево,+1 вправо)
    private double dx = Math.random() * 2 - 1; //-1..1

    public Ufo(double x, double y) {
        super(x, y, 3);
    }

    public void move() {
        this.y += dy;
        this.x += dx;

        checkBorders(radius, Space.game.getWidth() - radius + 1,
                     radius, (Space.game.getHeight() - radius + 1) / 2);

        if (Math.random() > 0.9) {
            fire();
        }
    }

    /**
     * Метод рисует свой объект на "канвасе".
     */
    @Override
    public void draw(Canvas canvas) {
        canvas.drawMatrix(x - radius + 1, y - radius + 1, matrix, 'U');
    }

    public void fire() {
        Space.game.getBombs().add(new Bomb(x, y + radius));
    }
}
