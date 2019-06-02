package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[5];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        int tmp;
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 4; i++) {
                if (array[i] > array[i + 1]) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
        }

        for (int j = 0; j < 5; j++) {
            System.out.println(array[j]);
        }

//  Или так:
//      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//      ArrayList<Integer> list = new ArrayList<Integer>();
//
//        for (int i = 0; i < 5; i++) {
//            list.add(Integer.parseInt(reader.readLine()));
//        }
//
//        Collections.sort(list);
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
    }
}
