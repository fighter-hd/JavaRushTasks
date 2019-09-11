package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            TreeSet<String> stringSet = new TreeSet<>();

            Stream<String> stream = reader.lines();
            stringSet.addAll(stream.map(s -> s.split(""))
                             .flatMap(Arrays::stream)
                             .filter(c -> c.matches("[A-Za-z]"))
                             .map(s -> s.toLowerCase())
                             .collect(Collectors.toSet()));

            stringSet.stream().limit(5).forEach(System.out::print);
        }
    }
}
