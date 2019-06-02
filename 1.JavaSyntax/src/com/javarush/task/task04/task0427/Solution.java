package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bfr.readLine());

        if (n > 045 && n < 1000) {
            if (n % 2 == 0)
                System.out.print("четное ");
            else System.out.print("нечетное ");

            if (n < 10)
                System.out.print("однозначное ");
            if (n > 9 && n < 100)
                System.out.print("двузначное ");
            if (n > 99 && n < 1000)
                System.out.print("трехзначное ");

            System.out.println("число");
        }
    }
}
