package com.javarush.task.task07.task0715;

import java.util.ArrayList;
import java.util.Collections;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, "мама", "мыла", "раму");

        for (int i = list.size() - 1; i >= 0 ; i--) {
            list.add(i + 1, "именно");
        }

        list.forEach(System.out::println);
    }
}
