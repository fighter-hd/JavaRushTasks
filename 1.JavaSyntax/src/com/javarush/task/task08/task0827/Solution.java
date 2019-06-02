package com.javarush.task.task08.task0827;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Calendar g = new GregorianCalendar();

        g.setTime(dateFormat.parse(date));

        System.out.println(g.get(Calendar.DAY_OF_YEAR));

        if (g.get(Calendar.DAY_OF_YEAR) % 2 == 0) {
            return false;
        }

        return true;
    }
}
