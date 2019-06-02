package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream input = new FileInputStream(args[1]);
        OutputStream output = new FileOutputStream(args[2]);

        byte[] buffer = new byte[input.available()];

        if (args[0].equals("-e")) {
            for (int i = 0; i < buffer.length; i++) {
                byte b = (byte) (input.read() + 9);
                buffer[i] = b;
            }
            input.close();

            output.write(buffer);
            output.close();

        } else if (args[0].equals("-d")) {
            for (int i = 0; i < buffer.length; i++) {
                byte b = (byte) (input.read() - 9);
                buffer[i] = b;
            }
            input.close();

            output.write(buffer);
            output.close();
        }
    }
}
