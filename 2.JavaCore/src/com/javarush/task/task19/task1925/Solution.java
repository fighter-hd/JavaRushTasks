package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(fileReader);

        StringBuilder builder = new StringBuilder();
        while (reader.ready()) {
            builder.append(reader.readLine() + " ");
        }
        reader.close();

        FileWriter fileWriter = new FileWriter(args[1]);

        Pattern pattern = Pattern.compile("\\S{7,}");
        Matcher matcher = pattern.matcher(builder);

        String result = "";

        while (matcher.find()) {
            result += matcher.group() + ",";
        }

        result = result.substring(0, result.length() - 1);

        fileWriter.write(result);
//        System.out.println(result);
        fileWriter.close();
    }
}
