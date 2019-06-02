package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        bufferedReader.close();

        BufferedReader reader = new BufferedReader(fileReader);
        String data = "";
        String reverse = "";

        while (reader.ready()) {
            data = reader.readLine() + "\n";
            reverse += new StringBuffer(data).reverse().toString();
        }
        reader.close();

        System.out.println(reverse);
    }
}
