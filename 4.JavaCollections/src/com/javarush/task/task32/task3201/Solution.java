package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        try {
            RandomAccessFile file = new RandomAccessFile(args[0], "rw");
            long position = Integer.parseInt(args[1]);
            String text = args[2];

            if (position >= file.length()) {
                position = file.length();
            }

            file.seek(position);
            file.write(text.getBytes());

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
