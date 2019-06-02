package com.javarush.task.task09.task0927;

import java.util.*;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Map<String, Cat> mapOfCats = new HashMap<>();
        List<Cat> listOfCats = new ArrayList<>();

        for (int i = 1; i < 11; i++) {
            listOfCats.add(new Cat("Cote" + i));
        }

        for (Cat cat : listOfCats) {
            mapOfCats.put(cat.name, cat);
        }

        return mapOfCats;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> setOfCats = new HashSet<>();

        for (Cat cat : map.values()) {
            setOfCats.add(cat);
        }

        return setOfCats;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
