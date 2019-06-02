package com.javarush.task.task07.task0713;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scr = new Scanner(System.in);

        ArrayList<Integer> mainList = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list1 = new ArrayList<Integer>();

        for (int i = 0; i < 20; i++) {
            mainList.add(scr.nextInt());
        }

        for (Integer j : mainList) {
            if (j % 3 == 0) {
                list3.add(j);
            }

            if (j % 2 == 0) {
                list2.add(j);
            }

            if ((j % 3 != 0) && (j % 2 != 0)) {
                list1.add(j);
            }
        }

        printList(list3);
        printList(list2);
        printList(list1);
    }

    public static void printList(List<Integer> list) {
        for (Integer n : list) {
            System.out.println(n);
        }
    }
}
