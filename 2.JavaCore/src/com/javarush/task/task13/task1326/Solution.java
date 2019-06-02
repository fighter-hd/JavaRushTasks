package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Solution {
    public static void main(String[] args) throws IOException {
        //буфер для считывания имени файла с консоли
        BufferedReader bufferForFile = new BufferedReader(new InputStreamReader(System.in));

        //поток ввода информации из файла. В качестве параметра принимает строку с именем файла
        FileInputStream inputStream = new FileInputStream(bufferForFile.readLine());

        //буфер для считывания информации из потока ввода
        BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(inputStream));

        //создание листа для записи информации считаной из файла
        ArrayList<Integer> list = new ArrayList<>();

        //строка, которая будет проверятся в цикле, потом из которой будет парсится значение в число
        //и перезаписыватся её значение на следующую строку из файла
        String lineFromFile = inputBuffer.readLine();

        //непосредственно сам цикл
        while (lineFromFile != null) {
            try {
                int number = Integer.parseInt(lineFromFile);
                list.add(number);
                lineFromFile = inputBuffer.readLine();
            } catch (NumberFormatException e) {
                lineFromFile = inputBuffer.readLine();
            }
        }

        //использую итератор что бы иметь возможность изменять список во время итерации, иначе ошибка!!!
        Iterator iterator = list.iterator();

        //цикл в котором удаляются все нечётные числа
        while (iterator.hasNext()) {
            if ((int) iterator.next() % 2 != 0) {
                iterator.remove();
            }
        }

        //сортировка листа чётных чисел считанного из файла
        Collections.sort(list);

        //вывод каждого значения листа с новой строки
        list.forEach(System.out::println);

        //закрываем все потоки
        inputBuffer.close();
        inputStream.close();
        bufferForFile.close();
    }
}
