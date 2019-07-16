package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        try {
            RandomAccessFile file = new RandomAccessFile(args[0], "rw");
            int number = Integer.parseInt(args[1]);
            String text = args[2];

            file.seek(number);

            byte[] readBytes = new byte[text.length()];

            file.read(readBytes, 0, readBytes.length);

            String readText = new String(readBytes);

            file.seek(file.length());

            if (readText.equals(text)) {
                file.write("true".getBytes());
            } else {
                file.write("false".getBytes());
            }

            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Text for write:
// Test file text.

//Arguments:
//C:\Users\Gans\Desktop\Java_instructions\For_Tests\testText.txt 5 111