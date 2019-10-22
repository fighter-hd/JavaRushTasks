package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

public class Solution {
    public static void main(String[] args) {
        int[][] matrix1 = { {1,1,0,1,1,1},
                            {1,0,1,0,1,1},
                            {1,1,1,1,0,0},
                            {0,1,1,1,1,0},
                            {1,1,1,1,1,0} };  // maxSquare = 9

        int[][] matrix2 = { {0,1,0,1,1,1},
                            {1,1,1,0,1,1},
                            {1,0,1,1,1,1},
                            {0,1,1,0,1,1},
                            {1,1,1,1,1,0} };  // maxSquare = 4

        int[][] matrix3 = { {0,1,1,1,1},
                            {1,1,1,0,1,1},
                            {1,1,0},
                            {0,1,1,0,1,1},
                            {1} };  // maxSquare = 4

        System.out.println("Must be 9: " + maxSquare(matrix1));
        System.out.println("Must be 4: " + maxSquare(matrix2));
        System.out.println("Must be 4: " + maxSquare(matrix3));
    }

    public static int maxSquare(int[][] matrix) {
        int height = matrix.length;
        int width = getMaxMatrixWidth(matrix);

        int[][] filledMatrix = getFilledMatrix(matrix, height, width);
        int[][] subMatrix = getFilledSubMatrix(filledMatrix, height, width);

        int maxSideLength = getMaxMatrixElement(subMatrix);

        return maxSideLength * maxSideLength;
    }

    private static int getMaxMatrixWidth(int[][] matrix) {
        int width = 0;

        for (int[] raw : matrix) {
            int rawLength = raw.length;

            if (rawLength > width) {
                width = rawLength;
            }
        }

        return width;
    }

    private static int[][] getFilledMatrix(int[][] matrix, int height, int width) {
        int[][] resultMatrix = new int[height][width];

        for (int h = 0; h < height; h++) {
            for (int r = 0; r < matrix[h].length; r++) {
                resultMatrix[h][r] = matrix[h][r];
            }
        }

        return resultMatrix;
    }

    private static int[][] getFilledSubMatrix(int[][] sourceMatrix, int height, int width) {
        int[][] subMatrix = getSubMatrix(sourceMatrix, height, width);

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {

                if(sourceMatrix[i][j] == 1) {
                    subMatrix[i][j] = Math.min(subMatrix[i][j - 1],
                            Math.min(subMatrix[i - 1][j], subMatrix[i - 1][j - 1])) + 1;
                } else {
                    subMatrix[i][j] = 0;
                }
            }
        }

        return subMatrix;
    }

    private static int[][] getSubMatrix(int[][] sourceMatrix, int height, int width) {
        int[][] subMatrix = new int[height][width];

        for (int r = 0; r < height; r++) {
            subMatrix[r][0] = sourceMatrix[r][0];
        }

        for (int c = 0; c < width; c++) {
            subMatrix[0][c] = sourceMatrix[0][c];
        }

        return subMatrix;
    }

    private static int getMaxMatrixElement(int[][] matrix) {
        int maxElement = Integer.MIN_VALUE;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {

                if (matrix[row][column] > maxElement) {
                    maxElement = matrix[row][column];
                }
            }
        }

        return maxElement;
    }

//    public static int maxSquare(int[][] matrix) {
//        int height = matrix.length;
//        int width = getMaxMatrixWidth(matrix);
//        int[][] filledMatrix = getFilledMatrix(matrix, height, width);
//
//        for (int maxSideLength = Math.min(height, width); maxSideLength > 0; maxSideLength--) {
//
//            if (isMaxSizeOfSquare(filledMatrix, maxSideLength)) {
//                return maxSideLength * maxSideLength;
//            }
//        }
//
//        return 0;
//    }
//
//    private static boolean isMaxSizeOfSquare(int[][] matrix, int maxSideLength) {
//        for (int startRow = 0; startRow <= matrix.length - maxSideLength; startRow++) {
//            for (int startColumn = 0; startColumn <= matrix[startRow].length - maxSideLength; startColumn++) {
//
//                if ( ! isSquareContainsZero(matrix, maxSideLength, startRow, startColumn)) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
//
//    private static boolean isSquareContainsZero(int[][] matrix, int maxSideLength, int firstRow, int firstColumn) {
//        for (int row = firstRow; row < firstRow + maxSideLength; row++) {
//            for (int column = firstColumn; column < firstColumn + maxSideLength; column++) {
//
//                if (matrix[row][column] == 0) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
}