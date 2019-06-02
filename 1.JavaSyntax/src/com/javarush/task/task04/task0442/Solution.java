package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        String s = bfr.readLine();


        while (!s.equals("-1")) {
            sum += Integer.parseInt(s);
            s = bfr.readLine();
        }

        System.out.println(sum - 1);
    }
}
