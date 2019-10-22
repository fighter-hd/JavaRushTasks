package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(-3)); // false
        System.out.println(isPowerOfThree(-1)); // false
        System.out.println(isPowerOfThree(0));  // false
        System.out.println(isPowerOfThree(6));  // false
        System.out.println(isPowerOfThree(18)); // false
        System.out.println(isPowerOfThree(30)); // false
        System.out.println("============================");
        System.out.println(isPowerOfThree(1));  // true
        System.out.println(isPowerOfThree(3));  // true
        System.out.println(isPowerOfThree(9));  // true
        System.out.println(isPowerOfThree(27)); // true
    }

    public static boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        if (n == 1 || n == 3) {
            return true;
        }

        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }

            n /= 3;
        }

        return true;
    }
}
