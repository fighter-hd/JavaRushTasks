package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = bufferedReader.readLine();
        String file2 = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader reader = new BufferedReader(new FileReader(file1));
        StringBuilder data = new StringBuilder();

        while (reader.ready()) {
            data.append(reader.readLine());
            data.append(" ");
        }
        reader.close();

        String[] dataArray = String.valueOf(data).split(" ");

        StringBuilder builder = new StringBuilder();

        Pattern pattern = Pattern.compile("\\d+");

        for (String s : dataArray) {
            Matcher matcher = pattern.matcher(s);

            if (matcher.matches()) {
                builder.append(matcher.group());
                builder.append(" ");
            }
        }

        String result = String.valueOf(builder);

        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));

        writer.write(result, 0, result.length() - 1);
        writer.close();
    }
}

//C:\Users\DenG14\Desktop\For_Tests\ForOutput.txt
//C:\Users\DenG14\Desktop\For_Tests\Result.txt