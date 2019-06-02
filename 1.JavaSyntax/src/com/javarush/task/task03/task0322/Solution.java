package com.javarush.task.task03.task0322;


/* 
Большая и чистая
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        String name1 = bfr.readLine();
        String name2 = bfr.readLine();
        String name3 = bfr.readLine();

        System.out.println(name1 + " + " + name2 + " + " + name3 + " = Чистая любовь, да-да!");
    }
}

//  Вариант со Scanner:
//    Scanner scr = new Scanner(System.in);
//
//    String name1 = scr.nextLine();
//    String name2 = scr.nextLine();
//    String name3 = scr.nextLine();
//
//    System.out.println(name1 + " + " + name2 + " + " + name3 + " = Чистая любовь, да-да!");