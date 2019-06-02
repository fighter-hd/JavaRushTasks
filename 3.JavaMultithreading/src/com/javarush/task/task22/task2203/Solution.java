package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        StringBuilder result = null;
        try {
            int tabCount = 0;

            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == '\t') {
                    tabCount++;
                }
            }

            if (tabCount < 2) {
                throw new TooShortStringException();
            }

            result = new StringBuilder();
            String[] array = string.split("\t");
            result.append(array[1]);
        } catch (Exception exception) {
            throw new TooShortStringException();
        }

        return result.toString();
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
