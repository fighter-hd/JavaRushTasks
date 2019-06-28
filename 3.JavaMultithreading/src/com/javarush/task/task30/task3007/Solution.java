package com.javarush.task.task30.task3007;

/* 
Найдем число 2 в максимальной степени
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(140_000);
        System.out.println(Integer.toBinaryString(140_000));
        System.out.println(Integer.toBinaryString(131072));
        System.out.println(maxPowerOf2(140_000));   //131072
        System.out.println("\n" + 1026);
        System.out.println(Integer.toBinaryString(1026));
        System.out.println(Integer.toBinaryString(1024));
        System.out.println(maxPowerOf2(1026));      //1024
        System.out.println("\n" + 17);
        System.out.println(Integer.toBinaryString(17));
        System.out.println(Integer.toBinaryString(16));
        System.out.println(maxPowerOf2(17));        //16
    }

    public static int maxPowerOf2(int x) {
        x |= x >> 1;
        x |= x >> 2;
        x |= x >> 3;
        x |= x >> 4;
        x &= ~x >> 1;
        return x;
    }
}