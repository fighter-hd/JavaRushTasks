package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream input = new FileInputStream(reader.readLine());
        BufferedInputStream buffer = new BufferedInputStream(input);

        while (buffer.available() > 0) {
            char c = (char) buffer.read();
            System.out.print(c);
        }

        buffer.close();
        input.close();
        reader.close();

        //не знаю влияло ли на проверку, но считывал файл при тесте типа txt у которого было 2 строки символов
        //по идее на валидацию не влияло)))
        //не обращать внимания, то я к 11 ночи туплю
    }
}