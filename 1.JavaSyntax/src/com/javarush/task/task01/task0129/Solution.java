package com.javarush.task.task01.task0129;

/*
Считаем длину окружности

Выведи на экран длину окружности, рассчитанную по формуле: L = 2 * Pi * radius.
Результат - дробное число (тип double).
В качестве значения Pi используй значение 3.14.

Требования:
1. В методе printCircleLength нужно вывести длину окружности, рассчитанную по формуле: 2 * Pi * radius.
2. Метод main должен вызывать метод printCircleLength с параметром 5.
3. Метод main не должен вызывать команду вывода текста на экран.
4. Программа должна выводить длину окружности с радиусом 5.
*/

public class Solution {
    public static void main(String[] args) {
        printCircleLength(5);
    }

    public static void printCircleLength(int radius) {
        double Pi = 3.14;
        System.out.println(2 * Pi * radius);
    }
}