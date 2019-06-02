package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        //закомментированные строки это решение которое не прошло тест (почему-то) вместо 3-х if

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        String n1 = bfr.readLine();
        String n2 = bfr.readLine();
        String n3 = bfr.readLine();

        int a = Integer.parseInt(n1);
        int b = Integer.parseInt(n2);
        int c = Integer.parseInt(n3);

//        int[] array = new int[] {a, b, c};

        int count = 0;

//        for (int i = 0; i < array.length - 1; i++) {
//            if (array[i] > 0)
//                count++;
//        }

        if (a > 0) {
            count++;
        }

        if (b > 0) {
            count++;
        }

        if (c > 0) {
            count++;
        }

        System.out.println(count);
    }
}
