package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File in = new File(args[0]);
        File out = new File(args[1]);

        Charset win1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(in));
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(out));

        byte[] buffer = new byte[8192];
        while (inputStream.available() > 0) {
            inputStream.read(buffer);
            String s = new String(buffer, win1251);
            outputStream.write(s.getBytes(utf8));
        }

        inputStream.close();
        outputStream.close();
    }
}
