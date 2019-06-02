package com.javarush.task.task18.task1801;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int maxByte = 0;

        Scanner scanner = new Scanner(System.in);

        File file = new File(scanner.nextLine());
        FileInputStream inputStream = new FileInputStream(file);

        while (inputStream.available() > 0) {
            int inputByte = inputStream.read();

            if (inputByte > maxByte) {
                maxByte = inputByte;
            }
        }

        inputStream.close();
        scanner.close();

        System.out.println(maxByte);
    }
}
