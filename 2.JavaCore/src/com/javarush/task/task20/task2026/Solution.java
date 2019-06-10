package com.javarush.task.task20.task2026;

/*
Алгоритмы-прямоугольники
*/

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };
        byte[][] a3 = new byte[][]{
                {1, 0, 0, 1, 1, 1},
                {0, 0, 0, 1, 1, 1},
                {0, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1, 0},
                {1, 0, 0, 1, 1, 0}
        };


        int count1 = getRectangleCount(a1);
        System.out.println("count 1 = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count 2 = " + count2 + ". Должно быть 4");
        int count3 = getRectangleCount(a3);
        System.out.println("count 3 = " + count3 + ". Должно быть 6");
    }

    public static int getRectangleCount(byte[][] a) {
        int countOfRectangle = 0;

        for (int row = 0; row < a.length; row++) {
            for (int column = 0; column < a[row].length; column++) {
                if (a[row][column] == 1) {
                    countOfRectangle++;
                    findRectangel(a, row, column);
                }
            }
        }

        return countOfRectangle;
    }

    private static void findRectangel(byte[][] array, int row, int column) {
        int height = 0;
        int width = 0;

        for (int i = row; i < array.length; i++) {
            if (array[i][column] != 1) {
                break;
            } else {
                height++;
            }
        }

        for (int j = column; j < array.length; j++) {
            if (array[row][j] != 1) {
                break;
            } else {
                width++;
            }
        }

        int tempHeight = height;
        int tempWidth = width;

        for (int i = tempHeight - 1; i >= 0; i--) {
            for (int j = tempWidth - 1; j >= 0; j--) {

                if (array[i + row][j + column] != 1 && j < width) {
                    width = j;
                }

                if (array[i + row][j + column] == 1 && j + 1 > width) {
                    width = j + 1;
                }
            }
        }

        for (int j = tempWidth - 1; j >= 0; j--) {
            for (int i = tempHeight - 1; i >= 0; i--) {

                if (array[i + row][j + column] != 1 && i < height) {
                    height = i;
                }

                if (array[i + row][j + column] == 1 && i + 1 > height) {
                    height = i + 1;
                }
            }
        }

        for (int i = row + height - 1; i >= row; i--) {
            for (int j = column + width - 1; j >= column; j--) {
                array[i][j] = 5;
            }
        }

//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                System.out.print(array[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
