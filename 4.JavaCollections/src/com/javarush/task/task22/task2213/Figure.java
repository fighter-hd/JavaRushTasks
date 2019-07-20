package com.javarush.task.task22.task2213;

public class Figure {
    private int x;
    private int y;
    private int[][] matrix;

    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    void left() {
        x -= 1;

        if ( ! isCurrentPositionAvailable()) {
            x += 1;
        }
    }

    void right() {
        x += 1;

        if ( ! isCurrentPositionAvailable()) {
            x -= 1;
        }
    }

    void down() {
        y += 1;
    }

    void up() {
        y -= 1;
    }

    void rotate() {

    }

    void downMaximum() {

    }

    boolean isCurrentPositionAvailable() {
        return true;
    }

    void landed() {

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
