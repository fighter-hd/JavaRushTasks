package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream input = new FileInputStream(args[0]);

        byte[] byteArray = new byte[input.available()];
        for (int i = 0; input.available() > 0; i++) {
            byteArray[i] = (byte) input.read();
        }

        input.close();

        Set<Byte> byteSet = new TreeSet<>();
        Map<Byte, Integer> resultMap = new TreeMap<>();

        for (byte b : byteArray) {
            byteSet.add(b);
        }

        for (Byte set : byteSet) {
            int count = 0;
            for (byte b : byteArray) {
                if (set == b) {
                    count++;
                }
            }
            resultMap.put(set, count);
        }

        for (Map.Entry<Byte, Integer> element: resultMap.entrySet()) {
            System.out.print((char) ((byte) element.getKey()));
            System.out.println(" " + element.getValue());
        }
    }
}
