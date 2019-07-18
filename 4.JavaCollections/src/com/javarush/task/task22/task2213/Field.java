package com.javarush.task.task22.task2213;

public class Field {
    private int width;
    private int height;
    private int[][] matrix;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;

        matrix = new int[height][width];
    }

    void print() {

        for (int height = 0; height < matrix.length; height++) {

            for (int width = 0; width < matrix[height].length; width++) {
                System.out.print(matrix[height][width]);
            }

            System.out.println();
        }
    }

    void removeFullLines() {
        
    }

    Integer getValue(int x, int y) {
        return matrix[y][x];
    }

    void setValue(int x, int y, int value) {
        matrix[y][x] = value;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
