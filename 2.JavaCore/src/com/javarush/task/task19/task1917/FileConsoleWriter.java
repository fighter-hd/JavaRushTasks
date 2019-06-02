package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter (String string) throws IOException {
        fileWriter = new FileWriter(string);
    }

    public FileConsoleWriter (String string, boolean append) throws IOException {
        fileWriter = new FileWriter(string, append);
    }

    public FileConsoleWriter (File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter (File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter (FileDescriptor fd) {
        fileWriter = new FileWriter(fd);
    }

    public static void main(String[] args) throws IOException {
//        FileConsoleWriter f = new FileConsoleWriter("C:\\Users\\DenG14\\Desktop\\For_Tests\\ForOutput.txt");
//        f.write(123);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        System.out.println(String.valueOf(cbuf).substring(off, (off + len)));
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println(c);
    }

    public void write(String string) throws IOException {
        fileWriter.write(string);
        System.out.println(string);
    }

    public void write(String string, int off, int len) throws IOException {
        fileWriter.write(string, off, len);
        System.out.println(string.substring(off, (off + len)));
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        System.out.println(String.valueOf(cbuf));
    }

    public void close() throws IOException {
        fileWriter.close();
    }
}
