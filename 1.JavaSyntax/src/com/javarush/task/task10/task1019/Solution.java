package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        int id = 0;
        String name = null;

        while (true) {
            String number = reader.readLine();

            if (number.equals("")) {
                break;
            }

            id = Integer.parseInt(number);

            name = reader.readLine();
            if (name.equals("")) {
                map.put(name, id);
                break;
            } else {
                map.put(name, id);
            }
        }

        for (Map.Entry<String, Integer> human : map.entrySet()) {
            System.out.println(human.getValue() + " " + human.getKey());
        }
    }
}
