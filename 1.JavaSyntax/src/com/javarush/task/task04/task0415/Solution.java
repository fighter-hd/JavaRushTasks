package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;
import java.util.Scanner; //для Scanner

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        String sA = bfr.readLine();
        String sB = bfr.readLine();
        String sC = bfr.readLine();
        int a = Integer.parseInt(sA);
        int b = Integer.parseInt(sB);
        int c = Integer.parseInt(sC);

        if ((a + b <= c) || (c + b <= a) || (a + c <= b))
            System.out.println("Треугольник не существует.");
        else
            System.out.println("Треугольник существует.");
    }
}

//  Вместо BufferedReader:
//        Scanner scr = new Scanner(System.in);
//        int a = scr.nextInt();
//        int b = scr.nextInt();
//        int c = scr.nextInt();