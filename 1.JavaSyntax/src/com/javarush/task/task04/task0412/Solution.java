package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;
import java.util.Scanner; //для варианте со Scanner

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String s = bfr.readLine();
        int n = Integer.parseInt(s);

        if (n == 0) {
            System.out.println(n);
        }
        if (n < 0) {
            System.out.println(++n);
        }
        if (n > 0)
            System.out.println(n * 2);
    }
}

//  Вариант со Scanner:
//
//   Scanner scr = new Scanner(System.in);
//    int n = scr.nextInt();
//        if (n == 0) {
//                System.out.println(n);
//                }
//                if (n < 0) {
//        System.out.println(++n);
//        }
//        if (n > 0)
//        System.out.println(n * 2);