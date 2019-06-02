package com.javarush.task.task04.task0434;


/* 
Таблица умножения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int i = 1;
        int j;

        while (i <= 10){
            j = 1;
            while (j <= 10){
                //Внимание!!! j++ это просто обычный j = j + 1, а потом + " "
                System.out.print(i * j++ + " ");
            }
            i++;
            System.out.println();
        }
    }
}
