package com.javarush.task.task04.task0436;


/* 
Рисуем прямоугольник
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(bfr.readLine());
        int n = Integer.parseInt(bfr.readLine());

        for (int i = 0; i < m; i++) {
            int j = 0;
            for ( ; j < n; j++) {
                System.out.print(8);
            }
            System.out.println();
        }
    }
}
