package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            System.out.println("File not found in the static field of Solution.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String contentOfFile = "";

        @Override
        public void run() {
            Reader reader = null;
            try {
                reader = new FileReader(getName());
            } catch (FileNotFoundException e) {
                System.out.println("FileNotFoundException in the run() method.");
            }
            BufferedReader buffer = new BufferedReader(reader);

            try {
                String s = buffer.readLine();
                while (s != null) {
                    contentOfFile += s + " ";
                    s = buffer.readLine();
                }
            } catch (IOException e) {
                System.out.println("Exception when file has been read.");
            }

            try {
                buffer.close();
                reader.close();
            } catch (IOException e) {
                System.out.println("IOException");
            }
        }

        @Override
        public void setFileName(String fullFileName) {
            this.setName(fullFileName);
        }

        @Override
        public String getFileContent() {
            return contentOfFile;
        }
    }
}
