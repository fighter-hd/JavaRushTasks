package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        Scanner scanner = new Scanner(System.in);
        InputStream inputStream = new FileInputStream(scanner.nextLine());

        while (inputStream.available() >= 1000) {
            inputStream = new FileInputStream(scanner.nextLine());
        }
        inputStream.close();
        scanner.close();

        throw new DownloadException();
    }

    public static class DownloadException extends Exception {

    }
}
