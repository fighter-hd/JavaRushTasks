package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;
import java.util.Scanner; //для варианта со Scanner

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] daysOfWeek = new String[8];

        daysOfWeek[0] = "такого дня недели не существует";
        daysOfWeek[1] = "понедельник";
        daysOfWeek[2] = "вторник";
        daysOfWeek[3] = "среда";
        daysOfWeek[4] = "четверг";
        daysOfWeek[5] = "пятница";
        daysOfWeek[6] = "суббота";
        daysOfWeek[7] = "воскресенье";

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String s = bfr.readLine();
        int num = Integer.parseInt(s);

        if (num > 0 && num < daysOfWeek.length)
            System.out.println(daysOfWeek[num]);
        else
            System.out.println(daysOfWeek[0]);
    }
}

//  Вариант со Scanner без массива:
//
//   Scanner scr = new Scanner(System.in);
//    int num = scr.nextInt();
//
//        if (num > 1 || num < 7) {
//        if (num == 1)
//        System.out.println("понедельник");
//        if (num == 2)
//        System.out.println("вторник");
//        if (num == 3)
//        System.out.println("среда");
//        if (num == 4)
//        System.out.println("четверг");
//        if (num == 5)
//        System.out.println("пятница");
//        if (num == 6)
//        System.out.println("суббота");
//        if (num == 7)
//        System.out.println("воскресенье");
//        } else
//        System.out.println("такого дня недели не существует");