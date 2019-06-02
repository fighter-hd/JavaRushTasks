package com.javarush.task.task04.task0423;

/* 
Фейс-контроль
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        String name = bfr.readLine();
        String a = bfr.readLine();
        int age = Integer.parseInt(a);

        if (age > 20)
            System.out.println("И 18-ти достаточно");
    }
}
