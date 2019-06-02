package com.javarush.task.task18.task1803;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int maxRepeat = 0;

        Scanner scanner = new Scanner(System.in);
        File file = new File(scanner.nextLine());
        scanner.close();

        InputStream stream = new FileInputStream(file);

        List<Integer> listOfBytes = new ArrayList<>();

        while (stream.available() > 0) {
            listOfBytes.add(stream.read());
        }
        stream.close();

        List<ByteObject> byteObjectList = getByteObjectList(listOfBytes);
        byteObjectList = removeAndCount(byteObjectList);

        for (ByteObject byteObject : byteObjectList) {
            if (byteObject.repeatCount > maxRepeat) {
                maxRepeat = byteObject.repeatCount;
            }
        }

        for (ByteObject byteObject : byteObjectList) {
            if (byteObject.repeatCount == maxRepeat) {
                System.out.print(byteObject + " ");
            }
        }
    }

    public static List<ByteObject> getByteObjectList(List<Integer> listOfBytes) {
        List<ByteObject> bytesFromFile = new ArrayList<>();

        for (Integer byteFromList : listOfBytes) {
            bytesFromFile.add(new ByteObject(byteFromList));
        }

        return bytesFromFile;
    }

    public static List<ByteObject> removeAndCount(List<ByteObject> byteObjectList) {
        for (int i = 0; i < byteObjectList.size() - 1; i++) {
            int valueI = byteObjectList.get(i).value;

            for (int j = i + 1; j < byteObjectList.size(); j++) {
                int valueJ = byteObjectList.get(j).value;

                if (valueI == valueJ) {
                    byteObjectList.get(i).repeatCount++;
                    byteObjectList.remove(j);
                }
            }
        }
        return byteObjectList;
    }
}

class ByteObject {
    int value;
    int repeatCount;

    public ByteObject(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
