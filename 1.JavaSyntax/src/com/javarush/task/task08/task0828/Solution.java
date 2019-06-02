package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String s = bfr.readLine();

        List<String> months = Arrays.asList("January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December");

        for (String month : months) {
            if (s.contains(month)) {
                System.out.println(month + " is the " + (months.indexOf(month) + 1) + " month");
                break;
            }
        }
    }
}
