package com.javarush.task.task22.task2210;

import java.util.*;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTokens("level22.lesson13.task01", ".")));
    }

    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        List<String> result = new ArrayList<>();

        while (tokenizer.hasMoreElements()) {
            result.add(tokenizer.nextToken());
        }

        return result.toArray(new String[result.size()]);
    }
}
