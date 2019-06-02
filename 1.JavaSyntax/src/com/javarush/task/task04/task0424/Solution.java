package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        String a1 = bfr.readLine();
        String b1 = bfr.readLine();
        String c1 = bfr.readLine();

        int a = Integer.parseInt(a1);
        int b = Integer.parseInt(b1);
        int c = Integer.parseInt(c1);

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(a);
        list.add(b);
        list.add(c);

        if (a == b && a != c)
            System.out.println(list.indexOf(c) + 1);

        if (a == c && a != b)
            System.out.println(list.indexOf(b) + 1);

        if (c == b && b != a)
            System.out.println(list.indexOf(a) + 1);
    }
}
