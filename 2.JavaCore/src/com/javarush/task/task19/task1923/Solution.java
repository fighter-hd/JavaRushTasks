package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
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
        FileWriter writer = new FileWriter(args[1]);
        BufferedReader reader = new BufferedReader(fileReader);

        String words = "";
        while (reader.ready()) {
            words += reader.readLine();
            words += " ";
        }

        reader.close();
        fileReader.close();

        String[] wordsArray = words.split(" ");

        Pattern pattern = Pattern.compile("\\d");

        String result = "";

        for (String s : wordsArray) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                result += s + " ";
            }
        }

        writer.write(result);
        writer.close();
    }
}

//C:\Users\DenG14\Desktop\For_Tests\1.txt C:\Users\DenG14\Desktop\For_Tests\ForOutput.txt

//li432ne ine line1 sdgerf 243fg4fef3
// df 3fds 1rfv4 ete