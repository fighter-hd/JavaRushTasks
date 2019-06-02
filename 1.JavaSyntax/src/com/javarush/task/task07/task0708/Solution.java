package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings = new ArrayList<String>();
    private static String theLongest = "";
    private static int maxCharsInString;

    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            strings.add(bfr.readLine());
        }

        for (String s : strings) {
            if (s.length() > maxCharsInString) {
                maxCharsInString = s.length();
            }
        }

        for (String m : strings) {
            if (m.length() == maxCharsInString) {
                theLongest += m + "\n";
            }
        }

        System.out.print(theLongest);
    }
}
