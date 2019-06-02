package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();

        Scanner scr = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            list.add(scr.nextInt());
        }

        int max = 1;
        int temporary = 1;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1) ) ) {
                temporary++;

                if (temporary > max) {
                    max = temporary;
                }
            } else {
                temporary = 1;
            }
        }

        System.out.println(max);
    }
}