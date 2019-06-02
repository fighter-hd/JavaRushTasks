package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bfr.readLine());
        int b = Integer.parseInt(bfr.readLine());
        int c = Integer.parseInt(bfr.readLine());

        int countPositive = 0;
        int countNegative = 0;

        if (a > 0 && a != 0) {
            countPositive++;
        } else if (a < 0){
            countNegative++;
        }

        if (b > 0 && b != 0) {
            countPositive++;
        } else if (b < 0){
            countNegative++;
        }

        if (c > 0 && c != 0) {
            countPositive++;
        } else if (c < 0){
            countNegative++;
        }

        System.out.println("количество положительных чисел: " + countPositive);
        System.out.println("количество отрицательных чисел: " + countNegative);
    }
}
