package com.javarush.task.task07.task0706;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scr = new Scanner(System.in);
        int sumOdd = 0;
        int sumEven = 0;
        int[] street = new int[15];

        for (int i = 0; i < street.length; i++) {
            street[i] = scr.nextInt();

            if (i % 2 == 0) {
                sumEven += street[i];
            } else {
                sumOdd += street[i];
            }
        }

        if (sumEven > sumOdd) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        } else {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
    }
}
