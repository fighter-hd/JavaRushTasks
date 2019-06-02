package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream originOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);
        testString.printSomething();
        System.setOut(originOut);

        String data = outputStream.toString().trim();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(data);

        String allNumbersString = "";

        while (matcher.find()) {
            allNumbersString += matcher.group() + " ";
        }

        String[] numArray = allNumbersString.split(" ");

        int firstNumber = Integer.parseInt(numArray[0]);
        int secondNumber = Integer.parseInt(numArray[1]);
        int result;

        String sign = "";

        pattern = Pattern.compile("[-+*]");
        matcher = pattern.matcher(data);

        while (matcher.find()) {
            sign = matcher.group();
        }

        switch (sign) {
            case "+":
                result = firstNumber + secondNumber;
                System.out.println(firstNumber + " + " + secondNumber + " = " + result);
                break;
            case "-":
                result = firstNumber - secondNumber;
                System.out.println(firstNumber + " - " + secondNumber + " = " + result);
                break;
            case "*":
                result = firstNumber * secondNumber;
                System.out.println(firstNumber + " * " + secondNumber + " = " + result);
                break;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

