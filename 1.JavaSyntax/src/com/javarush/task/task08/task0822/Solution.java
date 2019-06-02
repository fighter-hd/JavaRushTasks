package com.javarush.task.task08.task0822;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        int minimum = Integer.MAX_VALUE;

        for (Integer number : array) {
            if (number < minimum) {
                minimum = number;
            }
        }

        return minimum;
    }

    public static List<Integer> getIntegerList() throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Integer> array = new ArrayList<>();

        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            array.add(scanner.nextInt());
        }

        return array;
    }
}
