package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int a = 1;
        int m= 1;
        String s ="";

        while (m<=10){
            while (a<=10){
                s =s+(m*a)+ " ";
                a++;
            }
            s=s+"\n";
            m++;
            a=1;
        }
        System.out.print(s);
    }
}
