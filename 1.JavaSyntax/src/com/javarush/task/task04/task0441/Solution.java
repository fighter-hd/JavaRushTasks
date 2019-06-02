package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(Integer.parseInt(bfr.readLine()));
        list.add(Integer.parseInt(bfr.readLine()));
        list.add(Integer.parseInt(bfr.readLine()));

        Collections.sort(list);
        System.out.println(list.get(1));
    }
}
