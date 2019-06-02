package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        int countOfEnglLetters = 0;
        InputStream fileInputStream = new FileInputStream(args[0]);

        while (fileInputStream.available() > 0) {
            int b = fileInputStream.read();

            if (b >= 65 && b <= 90) {
                countOfEnglLetters++;
            } else if (b >= 97 && b <= 122) {
                countOfEnglLetters++;
            }
        }

        fileInputStream.close();

        System.out.println(countOfEnglLetters);
    }
}
