package com.javarush.task.task25.task2515;

public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new char[height][width];
    }

    public void setPoint(double x, double y, char c) {
        int intX = (int) Math.round(x);
        int intY = (int) Math.round(y);

        if (x >= 0 && x < matrix[0].length && y >= 0 && y < matrix.length) {
            matrix[intY][intX] = c;
        }
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c) {

        for (int height = 0; height < matrix.length; height++) {
            for (int width = 0; width < matrix[height].length; width++) {

                if (matrix[height][width] != 0) {
                    setPoint(x + width, y + height, c);
                }
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }
}
