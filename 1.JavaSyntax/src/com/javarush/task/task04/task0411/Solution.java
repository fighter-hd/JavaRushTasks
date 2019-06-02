package com.javarush.task.task04.task0411;

/* 
Времена года на Терре
*/

public class Solution {
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
    }

    public static void checkSeason(int month) {
        if (month == 1 || month == 2 || month == 12)
            System.out.println("зима");
        if (month > 2 && month < 6)
            System.out.println("весна");
        if (month > 5 && month < 9)
            System.out.println("лето");
        if (month > 8 && month < 12)
            System.out.println("осень");
    }
}