package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();

        int minChars = Integer.MAX_VALUE;
        String shortest = "";

        for (int i = 0; i < 5; i++) {
            list.add(bfr.readLine());
        }

        for (String n : list) {
            if (n.length() < minChars) {
                minChars = n.length();
            }
        }

        for (String s : list) {
            if (s.length() == minChars) {
                shortest += s + "\n";
            }
        }

        System.out.print(shortest);
    }
}
