package com.javarush.task.task07.task0705;

import java.util.Scanner;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] bigArray = new int[20];
        int[] small1 = new int[10];
        int[] small2 = new int[10];

        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = new Scanner(System.in).nextInt();
        }

        for (int j = 0; j < small1.length; j++) {
            small1[j] = bigArray[j];
        }

        for (int n = 0; n < small2.length; n++) {
            small2[n] = bigArray[bigArray.length / 2 + n];
        }

        for (int k : small2) {
            System.out.println(k);
        }
    }
}
