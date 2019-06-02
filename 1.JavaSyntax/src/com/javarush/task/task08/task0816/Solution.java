package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", df.parse("JUNE 1 1980"));
        map.put("LastName2", df.parse("APRIL 26 1983"));
        map.put("LastName3", df.parse("FEBRUARY 27 1985"));
        map.put("LastName4", df.parse("JULY 5 1991"));
        map.put("LastName5", df.parse("DECEMBER 4 1994"));
        map.put("LastName6", df.parse("OCTOBER 12 1982"));
        map.put("LastName7", df.parse("AUGUST 2 1986"));
        map.put("LastName8", df.parse("SEPTEMBER 24 1976"));
        map.put("LastName9", df.parse("JUNE 18 1995"));
        map.put("LastName10", df.parse("MAY 15 1988"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        Iterator<Date> iterator = map.values().iterator();

        while (iterator.hasNext()) {
            Date v = iterator.next();
            if (v.getMonth() > 4 && v.getMonth() < 8) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) throws ParseException {

    }
}
