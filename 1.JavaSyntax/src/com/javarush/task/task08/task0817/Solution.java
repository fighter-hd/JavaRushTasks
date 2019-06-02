package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();

        map.put("surname1", "name1");
        map.put("surname2", "name2");
        map.put("surname3", "name3");
        map.put("surname4", "name4");
        map.put("surname5", "name5");
        map.put("surname6", "name6");
        map.put("surname7", "name1");
        map.put("surname8", "name3");
        map.put("surname9", "name3");
        map.put("surname10", "name5");

        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        ArrayList<String> list = new ArrayList<>(map.values());

        for (String listValue : list) {
            int equalValuesCount = 0;

            for (String mapValue : map.values()) {
                if (listValue.equals(mapValue)) {
                    equalValuesCount++;
                }
            }

            if (equalValuesCount > 1) {
                removeItemFromMapByValue(map, listValue);
            }
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
