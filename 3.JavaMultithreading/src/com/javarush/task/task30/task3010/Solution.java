package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        for (int i = 2; i <= 36; i++) {
            try {
                BigInteger bigInteger = new BigInteger(args[0], i);
                System.out.println(i);
                return;

            } catch (Throwable ignore) {
                //ignore and continue
            }
        }

        System.out.println("incorrect");
    }
}