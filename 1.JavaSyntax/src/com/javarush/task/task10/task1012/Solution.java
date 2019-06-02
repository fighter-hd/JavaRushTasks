package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

//  Проверку проходил с этим блоком, но потом выяснилось что он не нужен... Провтыкал, но валидацию прошёл с ним
//        ArrayList<Character> alphabet = new ArrayList<Character>();
//        for (int i = 0; i < abcArray.length; i++) {
//            alphabet.add(abcArray[i]);
//        }

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        for (char c : abcArray) {
            int count = 0;

            for (String s : list) {

                for (int i = 0; i < s.length(); i++) {
                    if (c == s.charAt(i)) {
                        count++;
                    }
                }
            }
            System.out.println(c + " " + count);
        }
    }

}
