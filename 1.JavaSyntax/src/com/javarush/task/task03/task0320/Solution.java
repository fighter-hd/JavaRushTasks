package com.javarush.task.task03.task0320;


/* 
Скромность украшает программиста
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        String name = bfr.readLine();

        System.out.println(name + " зарабатывает $5,000. Ха-ха-ха!");
    }
}

//   Вариант со Scanner:
//    Scanner scr = new Scanner(System.in);
//    String name = scr.nextLine();
//    System.out.println(name + " зарабатывает $5,000. Ха-ха-ха!");