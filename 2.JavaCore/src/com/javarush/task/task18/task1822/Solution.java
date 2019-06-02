package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedReader buffer = new BufferedReader(new FileReader(scanner.nextLine()));
        scanner.close();

        String product = "For check";

        while (product != null) {
            product = buffer.readLine();
            String[] productData = product.split(" ");

            if (productData[0].equals(args[0])) {
                break;
            }
        }

        buffer.close();

        System.out.println(product);
    }
}
