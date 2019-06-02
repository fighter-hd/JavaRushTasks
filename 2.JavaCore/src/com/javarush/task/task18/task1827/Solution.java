package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();

        if (args.length > 0) {
            if (args[0].equals("-c")) {
                int maxId = 0;

                InputStream inputStream = new FileInputStream(fileName);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String stringId;
                while ((stringId = reader.readLine()) != null) {
                    stringId = stringId.substring(0, 8).trim();
                    int intId = Integer.parseInt(stringId);

                    if (intId > maxId) {
                        maxId = intId;
                    }
                }

                reader.close();
                inputStream.close();

                OutputStream outputStream = new FileOutputStream(fileName, true);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

                writer.newLine();
                writer.write(String.format("%-8s", ++maxId));

                String productName = "";
                for (int i = 1; i < args.length - 2; i++) {
                    productName += args[i] + " ";
                }

                writer.write(String.format("%-30.30s", productName));
                writer.write(String.format("%-8s", args[args.length - 2]));
                writer.write(String.format("%-4s", args[args.length - 1]));

                writer.close();
                outputStream.close();
            }
        }
    }
}
