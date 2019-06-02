package com.javarush.task.task12.task1210;

/* 
Три метода и максимум
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static int max (int a, int b) {
        int maximum;

        if (a >= b) {
            maximum = a;
        } else {
            maximum = b;
        }

        return maximum;
    }

    public static long max (long a, long b) {
        long maximum;

        if (a >= b) {
            maximum = a;
        } else {
            maximum = b;
        }

        return maximum;
    }

    public static double max (double a, double b) {
        double maximum;

        if (a >= b) {
            maximum = a;
        } else {
            maximum = b;
        }

        return maximum;
    }
}
