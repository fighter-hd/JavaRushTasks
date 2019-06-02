package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        SimpleDateFormat dateFormatIn = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormatOut = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);

        Date now = dateFormatIn.parse(buffer.readLine());

        System.out.println(dateFormatOut.format(now).toUpperCase());
    }
}
