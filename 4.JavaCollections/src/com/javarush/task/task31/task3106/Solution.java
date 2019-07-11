package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/

//C:\Users\Gans\Desktop\Java_instructions\For_Tests\test\result.mp3 C:\Users\Gans\Desktop\Java_instructions\For_Tests\test\10678aoevnyesf.zip.004 C:\Users\Gans\Desktop\Java_instructions\For_Tests\test\10678aoevnyesf.zip.002 C:\Users\Gans\Desktop\Java_instructions\For_Tests\test\10678aoevnyesf.zip.003 C:\Users\Gans\Desktop\Java_instructions\For_Tests\test\10678aoevnyesf.zip.001

public class Solution {
    public static void main(String[] args) throws IOException {
        // Это решение позаимствовано отсюда
        // https://www.snip2code.com/Snippet/1178691/Level-31--Lesson-06--Bonus-01

        String resultFileName = args[0];
        int filePartCount = args.length - 1;
        String[] fileNamePart = new String[filePartCount];
        for (int i = 0; i < filePartCount; i++) {
            fileNamePart[i] = args[i + 1];
        }
        Arrays.sort(fileNamePart);

        List<FileInputStream> fisList = new ArrayList<>();
        for (int i = 0; i < filePartCount; i++) {
            fisList.add(new FileInputStream(fileNamePart[i]));
        }
        SequenceInputStream seqInStream = new SequenceInputStream(Collections.enumeration(fisList));
        ZipInputStream zipInStream = new ZipInputStream(seqInStream);
        FileOutputStream fileOutStream = new FileOutputStream(resultFileName);
        byte[] buf = new byte[1024 * 1024];
        while (zipInStream.getNextEntry() != null) {
            int count;
            while ((count = zipInStream.read(buf)) != -1) {
                fileOutStream.write(buf, 0, count);
            }
        }
        seqInStream.close();
        zipInStream.close();
        fileOutStream.close();
    }
}

class Sort implements Comparator<String> {
    public int compare(String a, String b) {
        int a1 = Integer.parseInt(a.substring(a.lastIndexOf(".") + 1));
        int b1 = Integer.parseInt(b.substring(b.lastIndexOf(".") + 1));
        return a.compareTo(b);
    }
}

// мой вариант который валидатор не принимал

//public class Solution {
//    public static void main(String[] args) {
//        List<String> filePathsList = new ArrayList<>();
//
//        for (int i = 1; i < args.length; i++) {
//            filePathsList.add(args[i]);
//        }
//
//        Collections.sort(filePathsList);
//
//        List<FileInputStream> inputStreamList = new ArrayList<>();
//
//        for (String path : filePathsList) {
//            try {
//                inputStreamList.add(new FileInputStream(path));
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
//
//        String fullZip = args[0] + ".zip";
//
//        try (FileOutputStream zipFileOutput = new FileOutputStream(fullZip)) {
//
//            for (FileInputStream inputStream : inputStreamList) {
//                for (int b = inputStream.read(); b != -1 ; b = inputStream.read()) {
//                    zipFileOutput.write(b);
//                }
//
//                inputStream.close();
//            }
//
//            zipFileOutput.flush();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try (FileOutputStream resultFileOutput = new FileOutputStream(args[0]);
//             ZipInputStream zipInput = new ZipInputStream(new FileInputStream(fullZip))) {
//
//            byte[] buffer = new byte[1024 * 1024];
//
//            while (zipInput.getNextEntry() != null) {
//                int count;
//
//                while ((count = zipInput.read(buffer)) != -1) {
//                    resultFileOutput.write(buffer, 0, count);
//                }
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}