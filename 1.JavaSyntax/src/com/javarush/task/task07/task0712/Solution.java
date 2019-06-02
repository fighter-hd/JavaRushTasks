package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();


        for (int i = 0; i < 10; i++) {
            list.add(bfr.readLine());
        }

        int shortest = list.get(0).length();
        int longest = list.get(0).length();

        for (int n = 1; n < list.size(); n++) {
            if (list.get(n).length() < shortest) {
                shortest = list.get(n).length();
            }

            if (list.get(n).length() > longest) {
                longest = list.get(n).length();
            }
        }

        for (String s : list) {
            if (s.length() == shortest) {
                System.out.println(s);
                break;
            }

            if (s.length() == longest) {
                System.out.println(s);
                break;
            }
        }
    }
}
