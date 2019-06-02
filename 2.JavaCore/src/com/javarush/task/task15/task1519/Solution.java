package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();

        String data = reader.readLine();

        while ( ! data.equals("exit")) {
            list.add(data);
            data = reader.readLine();
        }

        for (String s : list) {
            try {
                if (s.contains(".")) {
                    Double d = Double.parseDouble(s);
                    print(d);

                } else {
                    int number = Integer.parseInt(s);

                    if (number > 0 && number < 128) {
                        print((short) number);
                    } else {
                        print(number);
                    }
                }
            } catch (NumberFormatException exeption) {
                print(s);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
