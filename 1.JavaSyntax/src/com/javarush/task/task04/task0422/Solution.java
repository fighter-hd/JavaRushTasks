package com.javarush.task.task04.task0422;

/* 
18+
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        String name = bfr.readLine();
        String age1 = bfr.readLine();
        int age = Integer.parseInt(age1);

        if (age < 18)
            System.out.println("Подрасти еще");
    }
}
