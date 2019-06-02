package com.javarush.task.task18.task1805;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        File file = new File(scanner.nextLine());
        scanner.close();

        InputStream stream = new FileInputStream(file);

        Set<Integer> setOfBytes = new TreeSet<>();

        while (stream.available() > 0) {
            setOfBytes.add(stream.read());
        }
        stream.close();

        for (Integer aByte : setOfBytes) {
            System.out.print(aByte + " ");
        }
    }
}
