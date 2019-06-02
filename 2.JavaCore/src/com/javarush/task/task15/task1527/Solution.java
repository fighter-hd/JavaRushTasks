package com.javarush.task.task15.task1527;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        List<String> listOfParam = new ArrayList<>();
        String url = buffer.readLine();

        String parameters = url.substring(url.indexOf('?') + 1);

        String[] arrayOfparam = parameters.split("&");
        for (String s : arrayOfparam) {
            listOfParam.add(s);
        }

        for (int i = 0; i < listOfParam.size(); i++) {
            if (listOfParam.get(i).contains("=")) {
                int index = listOfParam.get(i).indexOf('=');
                String sub = listOfParam.get(i).substring(0, index);
                listOfParam.set(i, sub);
            }
        }

        for (String s : listOfParam) {
            System.out.print(s + " ");
        }

        System.out.println();

        for (String s : arrayOfparam) {
            if (s.contains("obj")) {
                try {
                    int index = s.indexOf('=');
                        String number = s.substring(index + 1);
                        double d = Double.parseDouble(number);
                        alert(d);

                } catch (NumberFormatException exception) {
                    int index = s.indexOf('=');
                    if (index != -1) {
                        String notAnumber = s.substring(index + 1);
                        alert(notAnumber);
                    }
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
