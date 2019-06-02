package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        Scanner scr = new Scanner(System.in);
        return scr.nextLine();
    }

    public static int readInt() throws Exception {
        Scanner scr = new Scanner(System.in);
        return scr.nextInt();
    }

    public static double readDouble() throws Exception {
        Scanner scr = new Scanner(System.in);
        return scr.nextDouble();
    }

    public static boolean readBoolean() throws Exception {
        boolean b = false;
        Scanner scr = new Scanner(System.in);
        String s = scr.nextLine();

        if (s.equals("true")) {
            b = true;
        }

        if (s.equals("false")) {
            b = false;
        }
        return b;
    }

    public static void main(String[] args) {

    }
}
