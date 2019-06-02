package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String tag = args[0];

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        bufferedReader.close();

        BufferedReader reader = new BufferedReader(fileReader);

        String fileData = "";
        while (reader.ready()) {
            fileData += reader.readLine();
        }
        reader.close();

        List<Integer> closerTags =  new LinkedList<>();

        Matcher matcherTagClose = Pattern.compile("<\\s*/" + tag + "\\s?.*?>").matcher(fileData);

        while (matcherTagClose.find()) {
            closerTags.add(matcherTagClose.end());
        }

        Matcher matcherTagOpen = Pattern.compile("<\\s*" + tag + "\\s?.*?>").matcher(fileData);

        int countOfRepeatOpen;

        while (matcherTagOpen.find()) {
            countOfRepeatOpen = 0;
            matcherTagClose = Pattern.compile("<\\s*/?" + tag + "\\s?.*?>").matcher(fileData);

            Matcher matcherRegion = matcherTagClose.region(matcherTagOpen.end(), fileData.length());

            while (matcherRegion.find()) {
                if (matcherRegion.group().matches("<\\s*" + tag + "\\s?.*?>")) {
                    countOfRepeatOpen++;
                } else {
                    String result = fileData.substring(matcherTagOpen.start(), closerTags.get(countOfRepeatOpen));
                    closerTags.remove(countOfRepeatOpen);

                    System.out.println(result);
                    break;
                }
            }
        }
    }
}
