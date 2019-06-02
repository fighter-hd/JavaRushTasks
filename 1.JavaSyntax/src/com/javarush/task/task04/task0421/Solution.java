package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        String name1 = bfr.readLine();
        String name2 = bfr.readLine();

        if(name1.equals(name2))
            System.out.println("Имена идентичны");

        if(name1.length() == name2.length() && !(name1.equals(name2)))
            System.out.println("Длины имен равны");
    }
}
