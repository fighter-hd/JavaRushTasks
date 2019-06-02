package com.javarush.task.task01.task0133;

/* 
Не думать о секундах…
*/

import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        Date d1 = new Date();
        Date d2 = new Date();

        d1.setMinutes(0);
        d2.setMinutes(30);

        long m = d2.getTime() - d1.getTime();
        System.out.println(m / 1000);

        //int secondsAfter15 = 30 * 60;
        //System.out.println(secondsAfter15);
    }
}