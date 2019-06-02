package com.javarush.task.task01.task0140;

/*
Выводим квадрат числа

Дана переменная number.
Напиши программу, которая выводит на экран квадрат этой переменной (number * number).

Требования:
1. Переменную number не изменяй, можешь менять только ее значение.
2. Программа должна выводить текст.
3. Выводимый текст должен быть числом.
4. Выводимый текст должен быть квадратом переменной number.
*/

public class Solution {
    public static int number = 25;

    public static void main(String[] args) {
        System.out.println(number * number);
    }
}