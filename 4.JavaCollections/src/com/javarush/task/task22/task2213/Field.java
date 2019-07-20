package com.javarush.task.task22.task2213;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс Field описывает "поле клеток" игры Тетрис
 */
public class Field {
    //ширина и высота
    private int width;
    private int height;

    //матрица поля: 1 - клетка занята, 0 - свободна
    private int[][] matrix;

    public Field(int height, int width) {
        this.width = width;
        this.height = height;
        matrix = new int[height][width];
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

    /**
     * Метод возвращает значение, которое содержится в матрице с координатами (x,y)
     * Если координаты за пределами матрицы, метод возвращает null.
     */
    public Integer getValue(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height)
            return matrix[y][x];

        return null;
    }

    /**
     * Метод устанавливает переданное значение(value) в ячейку матрицы с координатами (x,y)
     */
    public void setValue(int x, int y, int value) {
        if (x >= 0 && x < width && y >= 0 && y < height)
            matrix[y][x] = value;
    }

    /**
     * Метод печатает на экран текущее содержание матрицы
     */
    public void print() {
        //Создаем массив, куда будем "рисовать" текущее состояние игры
        int[][] canvas = new int[height][width];

        //Копируем "матрицу поля" в массив
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                canvas[i][j] = matrix[i][j];
            }
        }

        //Копируем фигурку в массив, только непустые клетки
        int left = Tetris.game.getFigure().getX();
        int top = Tetris.game.getFigure().getY();
        int[][] brickMatrix = Tetris.game.getFigure().getMatrix();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (top + i >= height || left + j >= width) continue;
                if (brickMatrix[i][j] == 1)
                    canvas[top + i][left + j] = 2;
            }
        }


        //Выводим "нарисованное" на экран, но начинаем с "границы кадра".
        System.out.println("---------------------------------------------------------------------------\n");

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int index = canvas[i][j];
                if (index == 0)
                    System.out.print(" . ");
                else if (index == 1)
                    System.out.print(" X ");
                else if (index == 2)
                    System.out.print(" X ");
                else
                    System.out.print("???");
            }
            System.out.println();
        }


        System.out.println();
        System.out.println();
    }

    /**
     * Удаляем заполненные линии
     */
    public void removeFullLines() {
        //Например так:
        //Создаем список для хранения линий
        //Копируем все непустые линии в список.
        //Добавляем недостающие строки в начало списка.
        //Преобразуем список обратно в матрицу

        //список в который будут записаны не пустые и не полностью заполненные линии
        List<int[]> lines = new ArrayList<>();

        //запись в список копиц необходимых линий сверху-вниз
        for (int i = 0; i < matrix.length; i++) {
            boolean hasEmptyCell = false;
            boolean hasNonEmptyCell = false;

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    hasEmptyCell = true;

                } else {
                    hasNonEmptyCell = true;
                }
            }

            //если строка не пустая и не полностью заполнена, то добавляем её копию в список
            if (hasEmptyCell && hasNonEmptyCell) {
                int[] lineCopy = new int[width];
                System.arraycopy(matrix[i], 0, lineCopy, 0, matrix[i].length);
                lines.add(lineCopy);
            }
        }

        //заполняем начало списка пустыми строками
        int countNeededEmptyLines = height - lines.size();

        for (int i = 0; i < countNeededEmptyLines; i++) {
            lines.add(i, new int[width]);
        }

        //перезаписываем готовый список обратно в матрицу
        for (int height = 0; height < matrix.length; height++) {
            int[] currentLine = lines.get(height);

            for (int width = 0; width < currentLine.length; width++) {
                matrix[height][width] = currentLine[width];
            }
        }
    }

//    public static void main(String[] args) {
//        Field field = new Field(6, 4);
//
//        int[][] m =           {{0,0,0,0},
//                               {0,0,0,0},
//                               {1,0,1,1},
//                               {0,2,2,2},
//                               {1,1,1,1},
//                               {2,2,2,2}};
//
//        field.matrix = m;
//
//        field.myPrint();
//        field.removeFullLines();
//        field.myPrint();
//    }
//
//    private void myPrint() {
//        System.out.println("----------------------------------------------------------------------------------------");
//        for (int height = 0; height < matrix.length; height++) {
//            for (int width = 0; width < matrix[height].length; width++) {
//                System.out.print(" " + matrix[height][width] + " ");
//            }
//            System.out.println();
//        }
//    }
}
