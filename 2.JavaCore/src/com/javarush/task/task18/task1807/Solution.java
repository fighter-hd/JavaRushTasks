package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        InputStream inputStream = new FileInputStream(scanner.nextLine());
        scanner.close();

        int sample = ',';
        int countOfRepeat = 0;

        while (inputStream.available() > 0) {
            if (inputStream.read() == sample) {
                countOfRepeat++;
            }
        }

        inputStream.close();

        System.out.println(countOfRepeat);
    }
}
