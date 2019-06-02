package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        String a1 = bfr.readLine();
        String b1 = bfr.readLine();
        String c1 = bfr.readLine();
        String d1 = bfr.readLine();

        int a = Integer.parseInt(a1);
        int b = Integer.parseInt(b1);
        int c = Integer.parseInt(c1);
        int d = Integer.parseInt(d1);

        int max = 0;

        if (a >= b)
            max = a;
        else max = b;

        if (c > max)
            max = c;

        if (d > max)
            max = d;

        System.out.println(max);

        //или так:
        //System.out.println(Math.max(Math.max(a, b), Math.max(c, d)));
    }
}
