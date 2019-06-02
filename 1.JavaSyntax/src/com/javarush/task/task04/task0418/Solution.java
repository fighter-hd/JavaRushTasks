package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        String a1 = bfr.readLine();
        String b1 = bfr.readLine();

        int a = Integer.parseInt(a1);
        int b = Integer.parseInt(b1);

        System.out.println(Math.min(a, b));
    }
}