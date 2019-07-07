package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {
//        String path = "C:\\Users\\Gans\\Desktop\\Java_instructions\\For_Tests\\Folder1";
//        String resultFileAbsolutePath = "C:\\Users\\Gans\\Desktop\\Java_instructions\\For_Tests\\Result3101.txt";

        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent()+"/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);

        List<File> filesList = new ArrayList<>();
        List<File> directoriesList = new ArrayList<>();

        File[] mainDirectoryArray = path.listFiles();
        checkAndAddFile(mainDirectoryArray, directoriesList, filesList);

        for (int i = 0; i < filesList.size(); i++) {
            if (filesList.get(i).length() > 50L) {
                filesList.remove(i--);
            }
        }

        Collections.sort(filesList, Comparator.comparing(File::getName));

        writeFiles(allFilesContent, filesList);
    }

    private static void writeFiles(File targetFile, List<File> filesForWrite) {
        try(BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile))) {
            for (File currentFile : filesForWrite) {
                try(BufferedInputStream input = new BufferedInputStream(new FileInputStream(currentFile))) {
                    List<Byte> bytes = new ArrayList<>();

                    while (input.available() > 0) {
                        bytes.add((byte) input.read());
                    }

                    byte[] currentFileBytes = new byte[bytes.size()];
                    for (int i = 0; i < bytes.size(); i++) {
                        currentFileBytes[i] = bytes.get(i);
                    }

                    output.write(currentFileBytes);
                    output.write("\n".getBytes());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkAndAddFile(File[] currentDirectoryArray, List<File> directories, List<File> files) {
        for (File currentFile : currentDirectoryArray) {
            if (currentFile.isDirectory()) {
                directories.add(currentFile);
                checkAndAddFile(currentFile.listFiles(), directories, files);

            } else {
                files.add(currentFile);
            }
        }
    }
}
