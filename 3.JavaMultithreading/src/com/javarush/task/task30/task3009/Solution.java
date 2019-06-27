package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/*
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> resultSet = new HashSet<>();

        for (int i = 2; i <= 36 ; i++) {
            StringBuilder builder = new StringBuilder();
            int currentNumber = 0;

            try {
                currentNumber = Integer.parseInt(number);
            } catch (NumberFormatException ignore) {
                continue;
            }

            String temp = Integer.toString(currentNumber, i);
            builder.append(temp);

            if (temp.equals(builder.reverse().toString())) {
                resultSet.add(i);
            }

        }

        return resultSet;
    }
}