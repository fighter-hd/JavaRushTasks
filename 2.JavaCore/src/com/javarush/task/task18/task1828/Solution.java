package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();

        if (args.length > 0) {
            String enteredId = args[1];

            if (args[0].equals("-u")) {
                String refreshedData = "";
                String newLine;

                BufferedReader reader = new BufferedReader(new FileReader(fileName));

                while ((newLine = reader.readLine()) != null) {
                    String idFromFile = newLine.substring(0, 8).trim();

                    if (idFromFile.equals(enteredId)) {
                        refreshedData += String.format("%-8s", enteredId);

                        String productName = "";
                        for (int i = 2; i < args.length - 2; i++) {
                            productName += args[i] + " ";
                        }

                        refreshedData += String.format("%-30.30s", productName);
                        refreshedData += String.format("%-8s", args[args.length - 2]);
                        refreshedData += String.format("%-4s", args[args.length - 1]);

                    } else {
                        if (newLine.length() != 50) {
                            for (int i = 50 - newLine.length(); i > 0; i--) {
                                newLine += " ";
                            }
                        }
                        refreshedData += newLine;
                    }
                }
                reader.close();

                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

                for (int i = 0; i < refreshedData.length() - 1; i += 50) {
                    writer.write(refreshedData, i, 50);
                    writer.newLine();
                }

                writer.close();
            }

            if (args[0].equals("-d")) {
                String refreshedData = "";
                String newLine;

                BufferedReader reader = new BufferedReader(new FileReader(fileName));

                while ((newLine = reader.readLine()) != null) {
                    String idFromFile = newLine.substring(0, 8).trim();

                    if (idFromFile.equals(enteredId)) {
                        //skip this line
                    } else {
                        if (newLine.length() != 50) {
                            for (int i = 50 - newLine.length(); i > 0; i--) {
                                newLine += " ";
                            }
                        }
                        refreshedData += newLine;
                    }
                    System.out.println(refreshedData);
                }
                reader.close();

                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

                for (int i = 0; i < refreshedData.length() - 1; i += 50) {
                    writer.write(refreshedData, i, 50);
                    writer.newLine();
                }

                writer.close();
            }
        }
    }
}

// -u 3752 T-Shirt blue color 0.00 0

/*
19847   Item number 1                 159.00  12
198479  Super item number 2           173.00  17
3752    T-Shirt blue color 21234567893235.00  28
19847983Tovar nomer 123               10173.991234
 */
