package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        String a = bfr.readLine();
        String b = bfr.readLine();
        String c = bfr.readLine();

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(Integer.parseInt(a));
        list.add(Integer.parseInt(b));
        list.add(Integer.parseInt(c));

        Collections.sort(list);
        Collections.reverse(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

//   или так:
//       int[] array = new int[3];
//        array[0] = Integer.parseInt(a1);
//        array[1] = Integer.parseInt(b1);
//        array[2] = Integer.parseInt(c1);
//
//        for (int i = 0; i < array.length - 1; i++) {
//            if (array[i] > array[i + 1]) {
//                int tmp = array[i + 1];
//                array[i + 1] = array[i];
//                array[i] = tmp;
//            }
//        }
//
//        for (int j = array.length - 1; j >= 0; j--) {
//            System.out.print(array[j] + " ");
//        }
    }
}
