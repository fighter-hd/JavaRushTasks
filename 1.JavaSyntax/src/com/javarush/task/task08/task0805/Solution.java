package com.javarush.task.task08.task0805;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
На экране — значения!
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Sim", "Sim");
        map.put("Tom", "Tom");
        map.put("Arbus", "Arbus");
        map.put("Baby", "Baby");
        map.put("Cat", "Cat");
        map.put("Dog", "Dog");
        map.put("Eat", "Eat");
        map.put("Food", "Food");
        map.put("Gevey", "Gevey");
        map.put("Hugs", "Hugs");

        printValues(map);
    }

    public static void printValues(Map<String, String> map) {
        Iterator<String> iterator = map.values().iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

//   Или так:
//        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
//
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next().getValue());
//        }

//     Или так без итератора:
//        for (Map.Entry<String, String> e : map.entrySet()) {
//            System.out.println(e.getValue());
//        }
    }
}
