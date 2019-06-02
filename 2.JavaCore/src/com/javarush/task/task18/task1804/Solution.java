package com.javarush.task.task18.task1804;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        File file = new File(scanner.nextLine());
        scanner.close();

        InputStream stream = new FileInputStream(file);

        List<Integer> listOfBytes = new ArrayList<>();

        while (stream.available() > 0) {
            listOfBytes.add(stream.read());
        }
        stream.close();

        Map<Integer, Integer> mapOfBytes = getMapOfBytes(listOfBytes);

        List<Integer> resultList = getMinRepeatedBytes(mapOfBytes);

        for (Integer integer : resultList) {
            System.out.print(integer + " ");
        }
    }

    private static Map<Integer, Integer> getMapOfBytes(List<Integer> listOfBytes) {
        Map<Integer, Integer> mapOfBytes = new HashMap<>();

        for (Integer aByte : listOfBytes) {
            int repeatCount = 0;

            for (Integer thisElement : listOfBytes) {
                if (aByte == thisElement) {
                    repeatCount++;
                }

                mapOfBytes.put(aByte, repeatCount);
            }
        }
        return mapOfBytes;
    }

    private static List<Integer> getMinRepeatedBytes(Map<Integer, Integer> mapOfBytes) {
        List<Integer> resultList = new ArrayList<>();
        int minRepeat = Integer.MAX_VALUE;

        for (Integer value : mapOfBytes.values()) {
            if (value < minRepeat) {
                minRepeat = value;
            }
        }

        for (Map.Entry<Integer, Integer> entry : mapOfBytes.entrySet()) {
            if (entry.getValue() == minRepeat) {
                resultList.add(entry.getKey());
            }
        }

        return resultList;
    }
}
