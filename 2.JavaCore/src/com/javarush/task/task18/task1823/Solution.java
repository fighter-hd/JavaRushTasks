package com.javarush.task.task18.task1823;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        String dataFromConsole = scanner.nextLine();
        while ( ! dataFromConsole.equals("exit")) {
            new ReadThread(dataFromConsole).start();
            dataFromConsole = scanner.nextLine();
        }

        scanner.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            try {
                InputStream inputStream = new FileInputStream(fileName);

                byte[] bytesArray = new byte[inputStream.available()];
                inputStream.read(bytesArray);
                inputStream.close();

                Set<Byte> bytesSet = new HashSet<>();
                for (byte b : bytesArray) {
                    bytesSet.add(b);
                }

                int mainByte = 0;
                int maxRepeats = 0;

                for (Byte byteFromSet : bytesSet) {
                    int countOfRepeats = 0;

                    for (byte b : bytesArray) {
                        if (byteFromSet == b) {
                            countOfRepeats++;
                        }

                        if (countOfRepeats > maxRepeats) {
                            maxRepeats = countOfRepeats;
                            mainByte = byteFromSet;
                        }
                    }
                }

                synchronized (resultMap) {
                    resultMap.put(fileName, mainByte);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
