package com.javarush.task.task18.task1802;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int minByte = Byte.MAX_VALUE;

        Scanner scanner = new Scanner(System.in);
        File file = new File(scanner.nextLine());

        scanner.close();

        FileInputStream stream = new FileInputStream(file);

        while (stream.available() > 0) {
            int inputByte = stream.read();

            if (inputByte < minByte) {
                minByte = inputByte;
            }
        }

        stream.close();

        System.out.println(minByte);
    }
}
