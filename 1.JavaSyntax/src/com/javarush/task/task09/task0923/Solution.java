package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String s = buffer.readLine();

        char[] c = s.toCharArray();

        List<Character> vowels = new ArrayList<>();
        List<Character> consonants = new ArrayList<>();

        for (char letter : c) {
            if (isVowel(letter)) {
                vowels.add(letter);
            } else {
                consonants.add(letter);
            }
        }

        for (Character vowel : vowels) {
            System.out.print(vowel + " ");
        }
        System.out.println();

        for (Character consonant : consonants) {
            if ( ! consonant.equals(' ')) {
                System.out.print(consonant + " ");
            }
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}