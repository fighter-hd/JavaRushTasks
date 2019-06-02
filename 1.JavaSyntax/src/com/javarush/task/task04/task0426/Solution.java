package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bfr.readLine());

        if (n == 0)
            System.out.println("ноль");
        else {
            if (n > 0)
                System.out.print("положительное ");
            else System.out.print("отрицательное ");

            if (n % 2 == 0)
                System.out.print("четное ");
            else System.out.print("нечетное ");

            System.out.println("число");
        }
    }
}
