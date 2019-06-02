package com.javarush.task.task02.task0201;

/*
Реализуем метод print

В методе print выведи на экран переданную строку 4 раза. Каждый раз с новой строки.

Требования:
1. Программа должна выводить текст на экран.
2. Метод main не должен вызывать System.out.println или System.out.print.
3. Метод print должен выводить текст на экран.
4. Метод main должен вызвать метод print класса Solution ровно два раза.
5. Метод print должен выводить на экран строку 4 раза. Каждый раз с новой строки.
*/
public class Solution {
    public static void main(String[] args) {
        print("Java easy to learn!");
        print("Java opens many opportunities!");
    }

    public static void print(String s) {
        for (int i = 0; i < 4; i++) {
            System.out.println(s);
        }
    }
}
