package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        String enterFromKeyboard = bfr.readLine();
        int sum = 0;
        int number;

        while ( ! enterFromKeyboard.equals("сумма")) {
            number = Integer.parseInt(enterFromKeyboard);
            sum += number;
            enterFromKeyboard = bfr.readLine();
        }

        System.out.println(sum);
    }
}
