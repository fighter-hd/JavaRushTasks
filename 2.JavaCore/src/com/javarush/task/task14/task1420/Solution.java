package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<Integer> dividersForA = new ArrayList<>();
        List<Integer> dividersForB = new ArrayList<>();
        int maxNod = 0;
        int maxForCheck = 1;

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (a <= 0 || b <= 0) {
            throw new Exception();
        }

        for (int i = 1; i <= a; i++) {
            if ( a % i == 0) {
                dividersForA.add(i);
            }
        }

        for (int j = 1; j <= b; j++) {
            if ( b % j == 0) {
                dividersForB.add(j);
            }
        }

        for (Integer intA : dividersForA) {
            for (Integer intB : dividersForB) {
                if (intA == intB) {
                    if (maxForCheck <= intB) {
                        maxNod = intB;
                    }
                }
            }
        }

        System.out.println(maxNod);
    }
}
