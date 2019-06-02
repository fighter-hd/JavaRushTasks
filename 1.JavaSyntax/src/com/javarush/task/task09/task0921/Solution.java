package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        List<Number> listOfNumbers = new ArrayList<>();

        try {
            boolean b = true;
            while (b) {
                listOfNumbers.add(Integer.parseInt(buffer.readLine()));
            }

        } catch (NumberFormatException exception) {
            for (Number number : listOfNumbers) {
                System.out.println(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
