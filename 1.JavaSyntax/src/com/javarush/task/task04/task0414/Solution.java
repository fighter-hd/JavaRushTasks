package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;
import java.util.Scanner;  //для Scanner

public class Solution {
    public static void main(String[] args) throws Exception {
        //это было тяжело
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String s = bfr.readLine();
        int num = Integer.parseInt(s);

        if (num % 4 != 0) {
            System.out.println("количество дней в году: 365");
        } else {
            if ((num % 100 == 0) && (num % 400 != 0))
                System.out.println("количество дней в году: 365");
            else
                System.out.println("количество дней в году: 366");
        }
    }
}

//  Вместо BufferedReader
//        Scanner scr = new Scanner(System.in);
//        int num = scr.nextInt();