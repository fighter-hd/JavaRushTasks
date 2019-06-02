package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        StringBuilder result = new StringBuilder();
        try {
            String[] aroundSpaces = string.split(" ");
            for (int i = 1; i < 5; i++) {
                result.append(aroundSpaces[i]);
                result.append(" ");
            }
        } catch (Exception exception) {
            throw new TooShortStringException();
        }

        return result.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
