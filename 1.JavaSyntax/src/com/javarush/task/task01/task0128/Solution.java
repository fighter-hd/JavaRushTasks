package com.javarush.task.task01.task0128;

/*
Просто, как 2+2

Напиши программу, которая вызывает метод sum с параметрами 2 и 2.

Требования:
1. Программа должна выводить сумму 2 и 2.
2. Метод main должен вызывать метод sum с параметрами 2 и 2.
3. Метод main не должен вызывать команду вывода текста на экран.
4. Метод sum изменять нельзя.
*/

public class Solution {
    public static void main(String[] args) {
        sum(2, 2);
    }

    public static void sum(int a, int b) {
        int c = a + b;
        System.out.print(c);
    }
}
