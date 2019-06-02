package com.javarush.task.task12.task1209;

/* 
Три метода и минимум
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static int min (int a, int b) {
        int minimum;

        if (a <= b) {
            minimum = a;
        } else {
            minimum = b;
        }

        return minimum;
    }

    public static long min (long a, long b) {
        long minimum;

        if (a <= b) {
            minimum = a;
        } else {
            minimum = b;
        }

        return minimum;
    }

    public static double min (double a, double b) {
        double minimum;

        if (a <= b) {
            minimum = a;
        } else {
            minimum = b;
        }

        return minimum;
    }
}
