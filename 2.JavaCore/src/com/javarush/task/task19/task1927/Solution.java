package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream originOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        System.setOut(printStream);
        testString.printSomething();
        System.setOut(originOut);

        String text = outputStream.toString();
        outputStream.close();

        String[] resultArray = text.split("\n");

        String result = "";
        for (int i = 0; i < resultArray.length; i++) {
            result += resultArray[i++] + "\n";

            if (i == resultArray.length) {
                break;
            }

            result += resultArray[i] + "\n";
            result += "JavaRush - курсы Java онлайн" + "\n";
        }

        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
