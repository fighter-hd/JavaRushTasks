package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
        HashMap<Object, Number> map = newHashMap(newArrayList("first", "second"), newArrayList(1,2));
        for (Map.Entry<Object, Number> entry : map.entrySet()) {
            System.out.print(entry.getKey() + ": " + entry.getValue() + "\n");
        }
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        return new ArrayList<>(Arrays.asList(elements));
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        HashSet<T> resultSet = new HashSet<>();

        for (T element : elements) {
            resultSet.add(element);
        }

        return resultSet;
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException();
        }

        HashMap<K, V> resultMap = new HashMap<>();

        for (int i = 0; i < keys.size(); i++) {
            resultMap.put(keys.get(i), values.get(i));
        }

        return resultMap;
    }
}
