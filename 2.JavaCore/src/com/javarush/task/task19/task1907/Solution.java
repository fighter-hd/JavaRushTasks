package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String file = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String data = "";

        while (reader.ready()) {
            data += reader.readLine();
            data += ",";
        }
        reader.close();

        int countOfWorld = 0;

        String[] dataArray = data.split("\\W");

        for (String s : dataArray) {

            if (s.equals("world")) {
                countOfWorld++;
            }
        }

        System.out.println(countOfWorld);
    }
}

//C:\Users\DenG14\Desktop\For_Tests\ForOutput.txt

//Example from file: world;Every,second world,character (тут перенос строки)
//work.world
