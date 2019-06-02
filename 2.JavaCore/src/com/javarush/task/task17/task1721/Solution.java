package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Solution solution = new Solution();

        BufferedReader readerForConsole = new BufferedReader(new InputStreamReader(System.in));
        try {
            String file1 = readerForConsole.readLine();
            String file2 = readerForConsole.readLine();
            readerForConsole.close();

            BufferedReader readerForFile1 = new BufferedReader(new FileReader(file1));
            BufferedReader readerForFile2 = new BufferedReader(new FileReader(file2));

            String line;
            while ((line = readerForFile1.readLine()) != null) {
                allLines.add(line);
            }

            while ((line = readerForFile2.readLine()) != null) {
                forRemoveLines.add(line);
            }

            readerForFile1.close();
            readerForFile2.close();

            solution.joinData();

        } catch (IOException e) {
            //Do nothing...
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
