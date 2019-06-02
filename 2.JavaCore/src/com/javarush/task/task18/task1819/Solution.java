package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        File file1 = new File(scanner.nextLine());
        File file2 = new File(scanner.nextLine());

        BufferedInputStream input1 = new BufferedInputStream(new FileInputStream(file1));
        BufferedInputStream input2 = new BufferedInputStream(new FileInputStream(file2));

        byte[] byteArray1 = new byte[input1.available()];
        for (int i = 0; input1.available() > 0; i++) {
            byteArray1[i] = (byte) input1.read();
        }
        input1.close();

        byte[] byteArray2 = new byte[input2.available()];
        for (int i = 0; input2.available() > 0; i++) {
            byteArray2[i] = (byte) input2.read();
        }
        input2.close();

        byte[] result = new byte[byteArray1.length + byteArray2.length];

        for (int i = 0; i < byteArray2.length; i++) {
            result[i] = byteArray2[i];
        }

        int j = 0;
        for (int i = byteArray2.length; i < result.length; i++) {
            result[i] = byteArray1[j++];
        }

        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(file1));

        output.write(result);

        output.close();
    }
}
