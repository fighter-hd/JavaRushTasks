package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        InputStream inputStream = new FileInputStream(scanner.nextLine());
        OutputStream outputStream1 = new FileOutputStream(scanner.nextLine());
        OutputStream outputStream2 = new FileOutputStream(scanner.nextLine());
        scanner.close();

        int countOfInputBytes = inputStream.available();

        byte[] bufferArray = new byte[inputStream.available()];
        while (inputStream.available() > 0) {
            inputStream.read(bufferArray);
        }
        inputStream.close();

        if (countOfInputBytes % 2 == 0) {
            outputStream1.write(bufferArray, 0, countOfInputBytes / 2);
            outputStream2.write(bufferArray, countOfInputBytes / 2, countOfInputBytes / 2);
        } else {
            outputStream1.write(bufferArray, 0, countOfInputBytes / 2 + 1);
            outputStream2.write(bufferArray, countOfInputBytes / 2 + 1, countOfInputBytes / 2);
        }

        outputStream1.close();
        outputStream2.close();
    }
}


//C:\Users\DenG14\Desktop\For Tests\MyFile.txt
//C:\Users\DenG14\Desktop\For Tests\for output 1.txt
//C:\Users\DenG14\Desktop\For Tests\for output 2.txt