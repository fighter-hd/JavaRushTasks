package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map<String, String> humanMap = new HashMap<>();

        humanMap.put("Ааа", "Иван");
        humanMap.put("Ббб", "Санёк");
        humanMap.put("Ввв", "Димон");
        humanMap.put("Ггг", "Иван");
        humanMap.put("Ддд", "Илона");
        humanMap.put("Еее", "Даша");
        humanMap.put("Ёёё", "Санёк");
        humanMap.put("Жжж", "Анна");
        humanMap.put("Ввв", "Олег");
        humanMap.put("Ддд", "Валя");

        return humanMap;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
