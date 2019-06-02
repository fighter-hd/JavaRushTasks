package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        List<InputStream> listOfStream = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        try {
            while (true) {
                listOfStream.add(new FileInputStream(fileName));
                fileName = scanner.nextLine();
            }
        } catch (FileNotFoundException exception) {
            scanner.close();

            for (InputStream stream : listOfStream) {
                try {
                    stream.close();
                } catch (IOException e) {
                    //Do nothing
                }
            }

            System.out.println(fileName);
        }
    }
}
