package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Массив из строчек в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] array = new String[10];

        for (int i = 0; i < 8; i++) {
            array[i] = new BufferedReader(new InputStreamReader(System.in)).readLine();
        }

        for (int i = 9; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }
}