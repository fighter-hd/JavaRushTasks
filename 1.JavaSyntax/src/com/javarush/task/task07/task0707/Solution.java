package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();

        for (int i = 1; i <= 5; i++) {
            list.add("String " + i);
        }

        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
