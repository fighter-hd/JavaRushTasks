package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

/* 
Что внутри папки?
*/
public class Solution {
    private static int filesCount;
    private static int directoriesCount = -1;
    private static long directorySize;


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path checkedDirectory = Paths.get(scanner.nextLine());

        if (Files.isDirectory(checkedDirectory)) {
            Files.walkFileTree(checkedDirectory, new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    directoriesCount++;

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    filesCount++;
                    directorySize += attrs.size();

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });

            System.out.println("Всего папок - " + directoriesCount);
            System.out.println("Всего файлов - " + filesCount);
            System.out.println("Общий размер - " + directorySize);

        } else {
            System.out.println(checkedDirectory.toAbsolutePath().toString() + " - не папка");
        }
    }
}
