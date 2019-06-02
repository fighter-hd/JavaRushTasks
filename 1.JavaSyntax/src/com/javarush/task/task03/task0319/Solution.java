package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        String name = bfr.readLine();
        String num01 = bfr.readLine();
        String num02 = bfr.readLine();
        int num1 = Integer.parseInt(num01);
        int num2 = Integer.parseInt(num02);

        System.out.println(name + " получает " + num1 + " через " + num2 + " лет.");
    }
}

//     Вариант со Scanner:
//        Scanner scr = new Scanner(System.in);
//
//        String name = scr.nextLine();
//        int num1 = scr.nextInt();
//        int num2 = scr.nextInt();
//
//        System.out.println(name + " получает " + num1 + " через " + num2 + " лет.");
