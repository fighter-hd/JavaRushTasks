package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        File file1 = new File(scanner.nextLine());
        File file2 = new File(scanner.nextLine());
        File file3 = new File(scanner.nextLine());

        BufferedOutputStream output1 = new BufferedOutputStream(new FileOutputStream(file1, true));
        BufferedInputStream input2 = new BufferedInputStream(new FileInputStream(file2));
        BufferedInputStream input3 = new BufferedInputStream(new FileInputStream(file3));

        while (input2.available() > 0) {
            output1.write(input2.read());
        }
        input2.close();

        while (input3.available() > 0) {
            output1.write(input3.read());
        }
        input3.close();
        output1.close();
    }
}
