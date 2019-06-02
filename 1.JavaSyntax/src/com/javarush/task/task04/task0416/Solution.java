package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.Scanner;   //для Scanner

public class Solution {
    public static void main(String[] args) throws Exception {
        //без явных подсказок не решил

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String m = bfr.readLine();
        float minute = Float.parseFloat(m);

        if ((minute % 5 >= 0) && (minute % 5 < 3 ))
            System.out.println("зелёный");
        if ((minute % 5 >= 3) && (minute % 5 < 4))
            System.out.println("жёлтый");
        if ((minute % 5 >= 4) && (minute % 5 < 5))
            System.out.println("красный");
    }
}

//   Вместо BufferedReader:
//        Scanner scr = new Scanner(System.in);
//        int minute = scr.nextInt();