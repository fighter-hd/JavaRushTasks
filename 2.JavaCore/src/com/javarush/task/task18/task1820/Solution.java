package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferInput = new BufferedReader(new FileReader(scanner.nextLine()));

        String line = bufferInput.readLine();
        bufferInput.close();

        String[] stringArray = line.split(" ");

        double[] numbersArray = new double[stringArray.length];
        for (int i = 0; i < numbersArray.length; i++) {
            numbersArray[i] = Double.parseDouble(stringArray[i]);
            numbersArray[i] = Math.round(numbersArray[i]);
        }

        String result = "";
        for (int i = 0; i < numbersArray.length; i++) {
            result += String.format("%.0f", numbersArray[i]) + " ";
        }

        BufferedWriter bufferOutput = new BufferedWriter(new FileWriter(scanner.nextLine()));
        scanner.close();

        bufferOutput.write(result);
        bufferOutput.close();
    }
}
