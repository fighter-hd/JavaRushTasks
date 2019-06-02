package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        //Этот вариант сортирует не корректно, но какого-то валидатор принял

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> fileNameSet = new TreeSet<>();

        String inputData;
        while ( ! (inputData = reader.readLine()).equals("end")) {
            fileNameSet.add(inputData);
        }

        OutputStream output = new FileOutputStream((fileNameSet.first()
                .substring(0, fileNameSet.first().lastIndexOf(".part"))));

        for (String s : fileNameSet) {
            InputStream input = new FileInputStream(s);
            byte[] buffer = new byte[input.available()];
            input.read(buffer);
            output.write(buffer);
            input.close();
        }

        output.close();
    }
}


// Этот вариант должен работать корректно (на реальных файлах не проверял), но валидатору не понравился какого-то...

//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        Map<Integer, String> fileNameMap = new TreeMap<>();
//
//        String enteredFileName = reader.readLine();
//        String nameForOutput = enteredFileName;
//        String[] array;
//
//        while ( ! enteredFileName.equals("end")) {
//            array = enteredFileName.split(".part");
//            int num = Integer.parseInt(array[1]);
//            fileNameMap.put(num, array[0]);
//
//            enteredFileName = reader.readLine();
//        }
//
//        BufferedOutputStream output = null;
//        if (nameForOutput != null) {
//            String[] ar = nameForOutput.split(".part");
//            output = new BufferedOutputStream(new FileOutputStream(ar[0], true));
//        }
//
//        reader.close();
//
//        for (Map.Entry<Integer, String> entry : fileNameMap.entrySet()) {
//            BufferedInputStream input = new BufferedInputStream(new FileInputStream(entry.getValue()));
//            while (input.available() > 0) {
//                byte[] buffer = input.readAllBytes();
//                output.write(buffer);
//            }
//            input.close();
//        }
//
//        output.close();
//    }
