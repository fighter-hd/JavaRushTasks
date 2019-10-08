package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        File file = new File("not real path to file");
        InputStream input = new FileInputStream(file);
    }

    public static void main(String[] args) {

    }
}
