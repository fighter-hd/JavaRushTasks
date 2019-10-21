package com.javarush.task.task39.task3904;

/*
Лестница
*/
public class Solution {
    private static int n = 10;
    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        if (n < 0) {
            return 0;
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (n == 3) {
            return 4;
        }

        long n1 = 1;
        long n2 = 2;
        long n3 = 4;
        long count = 0;

        for (int i = 4; i <= n; i++) {
            count = n3 + n2 + n1;
            n1 = n2;
            n2 = n3;
            n3 = count;
        }

        return count;
//        return numberOfPossibleAscents(n - 1) + numberOfPossibleAscents(n - 2) + numberOfPossibleAscents(n - 3);
    }
}

