package com.javarush.task.task07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Меняем функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        ArrayList<String> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {

            char[] c = list.get(i).toCharArray();

            if (c.length % 2 == 0) {
                String s = list.get(i) + " " + list.get(i);
                newList.add(s);
            } else {
                String s = list.get(i) + " " + list.get(i) + " " + list.get(i);
                newList.add(s);
            }
        }

        for (String s : newList) {
            System.out.println(s);
        }
    }
}
