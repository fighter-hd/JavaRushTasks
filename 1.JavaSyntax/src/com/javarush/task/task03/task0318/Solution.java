package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String year = bfr.readLine();
        String name = bfr.readLine();
        int years = Integer.parseInt(year);
        System.out.println(name + " захватит мир через " + years + " лет. Му-ха-ха!");
    }
}

//  Способ со Scanner:
//    Scanner scr = new Scanner(System.in);
//    int years = scr.nextInt();
//    String name = scr.nextLine();
//    System.out.println(name + " захватит мир через " + years + " лет. Му-ха-ха!");
