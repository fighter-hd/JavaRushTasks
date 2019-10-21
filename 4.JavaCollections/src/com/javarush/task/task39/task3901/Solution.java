package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLongestLength = 1;
        int currentLength = 0;
        StringBuilder currentUniqueSubstring = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < s.length(); j++) {
                String currentChar = String.valueOf(s.charAt(j));

                if ( ! currentUniqueSubstring.toString().contains(currentChar)) {
                    currentUniqueSubstring.append(currentChar);
                    currentLength++;

                } else {
                    currentUniqueSubstring = new StringBuilder();
                    currentLength = 0;
                    break;
                }

                if (currentLength > maxLongestLength) {
                    maxLongestLength = currentLength;
                }
            }
        }

        return maxLongestLength;
    }
}
