package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        double sum = 0;
        double middleNumber = 0;
        double n = Double.parseDouble(bfr.readLine());

        for (double i = 1; n != -1; i++) {
            sum += n;
            middleNumber = sum / i;
            n = Double.parseDouble(bfr.readLine());
        }

        System.out.println(middleNumber);
    }
}

