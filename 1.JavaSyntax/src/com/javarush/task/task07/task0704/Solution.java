package com.javarush.task.task07.task0704;


/* 
Переверни массив
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scr = new Scanner(System.in);
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = scr.nextInt();
        }

        for (int j = array.length - 1; j >= 0; j--) {
            System.out.println(array[j]);
        }
    }
}

