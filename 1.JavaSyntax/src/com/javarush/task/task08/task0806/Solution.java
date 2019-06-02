package com.javarush.task.task08.task0806;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* 
Коллекция HashMap из Object
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        map.put("Sim", 5);
        map.put("Tom", 5.5);
        map.put("Arbus", false);
        map.put("Baby", null);
        map.put("Cat", "Cat");
        map.put("Eat", new Long(56));
        map.put("Food", new Character('3'));
        map.put("Gevey", '6');
        map.put("Hugs", 111111111111L);
        map.put("Comp", (double) 123);

        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Object> s = iterator.next();
            System.out.println(s.getKey() + " - " + s.getValue());
        }

//   Или так без итератора:
//        for (Map.Entry<String, Object> s : map.entrySet()) {
//            System.out.println(s.getKey() + " - " + s.getValue());
//        }
    }
}
