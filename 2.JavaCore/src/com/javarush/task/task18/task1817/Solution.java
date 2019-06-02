package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        int countOfChar = 0;
        int countOfSpace = 0;

        Pattern patternForAll = Pattern.compile(".");
        Pattern patternForSpace = Pattern.compile(" ");

        Matcher matcherForAll;
        Matcher matcherForSpace;

        InputStream inputStream = new FileInputStream(new File(args[0]));

        int i = inputStream.read();
        String symbol = String.valueOf((char) i);

        while(i > -1) {
            matcherForAll = patternForAll.matcher(symbol);
            matcherForSpace = patternForSpace.matcher(symbol);

            if (matcherForAll.find()) {
                countOfChar++;
            }

            if (matcherForSpace.find()) {
                countOfSpace++;
            }

            i = inputStream.read();
            symbol = String.valueOf((char) i);
        }

        inputStream.close();

        float result = (float) countOfSpace / countOfChar * 100;
        System.out.println(String.format("%.2f", result));
    }
}
