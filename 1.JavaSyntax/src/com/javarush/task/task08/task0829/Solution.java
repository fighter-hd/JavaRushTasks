package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> addresses = new HashMap<>();

        while (true) {
            String city = reader.readLine();

            if (city.isEmpty()) {
                break;
            }

            String family = reader.readLine();
            addresses.put(city, family);
        }

        String city = reader.readLine();

        Iterator<Map.Entry<String, String>> iterator = addresses.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> family = iterator.next();

            if (family.getKey().equals(city)) {
                System.out.println(family.getValue());
                break;
            }
        }
    }
}
