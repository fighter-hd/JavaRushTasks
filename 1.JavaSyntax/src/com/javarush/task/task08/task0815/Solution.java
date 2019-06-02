package com.javarush.task.task08.task0815;

import java.util.*;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();

        //Внимание!!! Если все фамилии не будут уникальны, то не пройдёт проверку.
        //Если ключи повторяются, то для данного ключа просто ПЕРЕЗАПИСЫВАЕТСЯ значение
        map.put("surname1", "name1");
        map.put("surname2", "name2");
        map.put("surname3", "name3");
        map.put("surname4", "name4");
        map.put("surname5", "name5");
        map.put("surname6", "name2");
        map.put("surname7", "name3");
        map.put("surname8", "name3");
        map.put("surname9", "name4");
        map.put("surname10", "name6");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int countOfNames = 0;

        Iterator<String> iterator = map.values().iterator();

        while (iterator.hasNext()) {
            if (iterator.next().equals(name)) {
                countOfNames++;
            }
        }

//   Вместо итератора:
//        for (String value : map.values()) {
//            if (value.equals(name)) {
//                countOfNames++;
//            }
//        }
        return countOfNames;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int countOfSurnames = 0;

        Iterator<String> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            if (iterator.next().equals(lastName)) {
                countOfSurnames++;
            }
        }
//   Вместо итератора:
//        for (String key : map.keySet()) {
//            if (key.equals(lastName)) {
//                countOfSurnames++;
//            }
//        }
        return countOfSurnames;
    }

    public static void main(String[] args) {

    }
}
