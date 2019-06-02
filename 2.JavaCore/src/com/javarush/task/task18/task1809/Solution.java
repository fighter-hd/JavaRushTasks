package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        InputStream inputStream = new FileInputStream(scanner.nextLine());
        OutputStream outputStream = new FileOutputStream(scanner.nextLine());
        scanner.close();

        byte[] array = new byte[inputStream.available()];
        inputStream.read(array);

        for (int i = array.length - 1; i >= 0; i--) {
            outputStream.write(array[i]);
        }

        inputStream.close();
        outputStream.close();
    }
}
