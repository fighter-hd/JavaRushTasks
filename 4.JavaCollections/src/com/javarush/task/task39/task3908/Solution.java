package com.javarush.task.task39.task3908;

import java.util.HashSet;
import java.util.Set;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("Nsaan"));
        System.out.println(isPalindromePermutation("aabbc"));
        System.out.println(isPalindromePermutation("aabbcd"));
        System.out.println(isPalindromePermutation("fnan"));
    }

    public static boolean isPalindromePermutation(String s) {
        char[] allChars = s.toLowerCase().toCharArray();
        Set<Character> charsSet = new HashSet<>();

        for (char c : allChars) {
            charsSet.add(c);
        }

        int[] charsRepeatCounts = new int[charsSet.size()];

        int i = 0;
        for (Character c : charsSet) {
            int currentCharRepeatCount = 0;

            for (char currentChar : allChars) {
                if (c.equals(currentChar)) {
                    currentCharRepeatCount++;
                }
            }

            charsRepeatCounts[i] = currentCharRepeatCount;
            i++;
        }

        int oddCount = 0;

        for (int n : charsRepeatCounts) {
            if (n % 2 == 1) {
                oddCount++;
            }
        }

        return oddCount < 2;
    }
}
