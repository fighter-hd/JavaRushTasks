package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        bufferedReader.close();
        BufferedReader reader = new BufferedReader(fileReader);

        List<String> listOfStrings = new ArrayList<>();

        while (reader.ready()) {
            listOfStrings.add(reader.readLine());
        }
        reader.close();
        fileReader.close();

        Pattern pattern = Pattern.compile("\\d\\p{Punct}?|1[0-2]\\p{Punct}?");

        for (String aString : listOfStrings) {
            StringBuilder forOut = new StringBuilder();
            String[] strings = aString.split(" ");

            for (String s : strings) {
                Matcher matcher = pattern.matcher(s);
                if (matcher.matches()) {
                    int value = Integer.parseInt(matcher.group());

                    forOut.append(map.get(value));
                    forOut.append(" ");
                } else {
                    forOut.append(s);
                    forOut.append(" ");
                }
            }

            String resultLine = forOut.toString().trim();
            System.out.println(resultLine);
        }
    }
}

//C:\Users\DenG14\Desktop\For_Tests\ForOutput.txt
