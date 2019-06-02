package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        List<Character> listOfChars = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            listOfChars.add(s.charAt(i));
        }

        for (int i = 0; i < 40; i++) {
            for (Character c : listOfChars) {
                System.out.print(c);
            }
            System.out.println();
            listOfChars.remove(0);
        }

/*  Или так:
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        char[] charArray = s.toCharArray();

        for (int i = 0; i < 40; i++) {
            for (int j = i; j < charArray.length; j++) {
                System.out.print(charArray[j]);
            }
            System.out.println();
        }*/
    }

}

