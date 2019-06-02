package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        final int N = Integer.parseInt(reader.readLine());
        final int M = Integer.parseInt(reader.readLine());

        for (int n = 0; n < N; n++) {
            list.add(reader.readLine());
        }

        for (int m = 0; m < M; m++) {
            list.add(list.remove(0));
        }

        list.forEach(System.out::println);
    }
}
