package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 1; i <= 10; i++) {
            map.put("Lastname" + i, i * 150);
        }

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        Iterator<Integer> iterator = map.values().iterator();

        while (iterator.hasNext()) {
            if (iterator.next() < 500) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {

    }
}