package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        if (n == 0) {
            return Integer.toString(1);

        } else if (n > 0 && n <= 150) {

            BigInteger factorialOfNumber = BigInteger.valueOf(1);
            for (int i = 2; i <= n; i++) {
                factorialOfNumber = factorialOfNumber.multiply(BigInteger.valueOf(i));
            }

            return factorialOfNumber.toString();
        }
        return Integer.toString(0);
    }
}
