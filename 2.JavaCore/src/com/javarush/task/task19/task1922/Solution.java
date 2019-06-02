package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        bufferedReader.close();

        BufferedReader reader = new BufferedReader(fileReader);

        while (reader.ready()) {
            int count = 0;

            String temp = reader.readLine();
            String[] wordsArray = temp.split(" ");

            for (String word : wordsArray) {
                if (words.contains(word)) {
                    count++;
                }
            }

            if (count == 2) {
                System.out.println(temp);
            }
        }

        reader.close();
        fileReader.close();
    }
}

//C:\Users\DenG14\Desktop\For_Tests\ForOutput.txt