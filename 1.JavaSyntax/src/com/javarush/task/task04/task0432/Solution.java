package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        String s = bfr.readLine();
        int n = Integer.parseInt(bfr.readLine());

        while (n > 0) {
            System.out.println(s);
            n--;
        }
    }
}
