package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try {
            FileReader fileReader = new FileReader(Statics.FILE_NAME);
            BufferedReader buffer = new BufferedReader(fileReader);
            String s = buffer.readLine();
            while (s != null) {
                lines.add(s);
                s = buffer.readLine();
            }
        } catch (IOException exception) {
            System.out.println("IOException");
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
