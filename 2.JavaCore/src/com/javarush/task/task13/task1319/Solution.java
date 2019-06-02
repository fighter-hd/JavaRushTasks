package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String myFile = reader.readLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(myFile, true));

        String newString = reader.readLine();

        while ( ! newString.equals("exit")) {
            writer.write(newString);
            writer.newLine();
            newString = reader.readLine();
        }

        writer.write(newString);

        writer.close();
        reader.close();
    }
}
