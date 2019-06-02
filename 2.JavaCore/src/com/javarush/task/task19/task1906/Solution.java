package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = bufferedReader.readLine();
        String file2 = bufferedReader.readLine();
        bufferedReader.close();

        Reader reader = new FileReader(file1);
        Writer writer = new FileWriter(file2);

        int numOfChar = 1;

        while (reader.ready()) {

            if (numOfChar % 2 == 0) {
                writer.write(reader.read());
            } else {
                reader.read();
            }

            numOfChar++;
        }

        reader.close();
        writer.close();
    }
}

//C:\Users\DenG14\Desktop\For_Tests\ForOutput.txt
//C:\Users\DenG14\Desktop\For_Tests\Result.txt
