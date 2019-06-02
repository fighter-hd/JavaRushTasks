package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        String[] arrayString = new String[10];
        int[] arrayInt = new int[10];

        for (int j = 0; j < arrayString.length; j++) {
            arrayString[j] = bfr.readLine();
        }

        for (int i = 0; i < arrayInt.length; i++) {
            int n = arrayString[i].length();
            arrayInt[i] = n;
        }

        for (int i : arrayInt) {
            System.out.println(i);
        }
    }
}
