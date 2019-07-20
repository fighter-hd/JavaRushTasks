package com.javarush.task.task22.task2213;

public class FigureFactory {
    static Figure createRandomFigure(int x,int y) {
        int[][] matrix = new int[y][x];

        return new Figure(x, y, matrix);
    }
}
