package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> map = new TreeMap<>();

        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bReader = new BufferedReader(fileReader);

        while (bReader.ready()) {
            String line = bReader.readLine();
            String[] lines = line.split(" ");

            double salary = Double.parseDouble(lines[1]);

            if (map.containsKey(lines[0])) {
                for (Map.Entry<String, Double> entry : map.entrySet()) {
                    if (entry.getKey().equals(lines[0])) {
                        salary += entry.getValue();
                        break;
                    }
                }
            }

            map.put(lines[0], salary);
        }
        bReader.close();
        fileReader.close();

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

//C:\Users\DenG14\Desktop\For_Tests\ForOutput.txt

//Petrov 2
//Sidorov 6
//Ivanov 1.35
//Ivanov 1.30
//Petrov 3.1