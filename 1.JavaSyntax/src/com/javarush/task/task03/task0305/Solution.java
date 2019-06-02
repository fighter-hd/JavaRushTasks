package com.javarush.task.task03.task0305;

/* 
Я так давно родился
*/

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        Date birthDay = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd Y", Locale.ENGLISH);

        birthDay.setDate(19);
        birthDay.setMonth(7);
        birthDay.setYear(94);

        System.out.println(dateFormat.format(birthDay).toUpperCase());
    }
}
