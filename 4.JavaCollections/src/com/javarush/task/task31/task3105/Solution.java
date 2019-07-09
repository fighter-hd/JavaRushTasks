package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<ZipEntry, ByteArrayOutputStream> hashMap = new HashMap<>();
        Path fileName = Paths.get(args[0]);
        Path newFile = Paths.get("new\\"+fileName.getFileName().toString());

        FileInputStream fileInputStream = new FileInputStream(args[1]);
        ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);

        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry())!=null){
            if (!zipEntry.getName().equals(newFile.toString())){
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count = 0;
                while ((count = zipInputStream.read(buffer)) != -1){
                    byteArrayOutputStream.write(buffer, 0, count);
                }
                byteArrayOutputStream.close();
                // zipInputStream.closeEntry();
                hashMap.put(zipEntry,byteArrayOutputStream);
            }
        }
        zipInputStream.close();

        FileOutputStream fileOutputStream = new FileOutputStream(args[1]);
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
        for (HashMap.Entry<ZipEntry,ByteArrayOutputStream> entry: hashMap.entrySet()){
            zipOutputStream.putNextEntry(new ZipEntry(entry.getKey().getName()));
            zipOutputStream.write(entry.getValue().toByteArray());
            // zipOutputStream.closeEntry();
        }

        ZipEntry newEntry = new ZipEntry(newFile.toString());
        zipOutputStream.putNextEntry(newEntry);
        Files.copy(fileName,zipOutputStream);
        //zipOutputStream.closeEntry();
        zipOutputStream.close();
    }
}