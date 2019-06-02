package com.javarush.task.task03.task0325;

import java.io.*;
import java.util.Scanner;

/* 
Финансовые ожидания
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String s = bfr.readLine();
        int salary = Integer.parseInt(s);
        System.out.println("Я буду зарабатывать $" + salary + " в час");
    }
}

//  Вариант со Scanner:
//   Scanner scr = new Scanner(System.in);
//    int salary = scr.nextInt();
//    System.out.println("Я буду зарабатывать $" + salary + " в час");
