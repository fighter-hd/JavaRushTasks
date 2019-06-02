package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;
import java.util.Scanner;   //для Scanner

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        String num1 = bfr.readLine();
        String num2 = bfr.readLine();
        String num3 = bfr.readLine();

        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        int n3 = Integer.parseInt(num3);

        if (n1 == n2 && n1 == n3)
            System.out.println(n1 + " " + n2 + " " + n3);
        else {
            if (n1 == n2) {
                System.out.println(n1 + " " + n2);
            }
            if (n1 == n3) {
                System.out.println(n1 + " " + n3);
            }
            if (n2 == n3) {
                System.out.println(n2 + " " + n3);
            }
        }
    }
}

//  Вместо BufferedReader:

//    Scanner scr = new Scanner(System.in);
//    int n1 = scr.nextInt();
//    int n2 = scr.nextInt();
//    int n3 = scr.nextInt();