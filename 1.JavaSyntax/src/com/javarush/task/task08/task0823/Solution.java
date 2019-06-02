package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        char[] charArray = s.toCharArray();
        List<Character> characterList = new ArrayList<>();

        for (int i = 0; i < charArray.length; i++) {
            characterList.add(charArray[i]);
        }

        for (int j = 0; j < characterList.size(); j++) {
            if (j == 0) {
                characterList.set(0, characterList.get(0).toUpperCase(characterList.get(0)));
            } else {
                if (characterList.get(j - 1).equals(' ')) {
                    characterList.set(j, characterList.get(j).toUpperCase(characterList.get(j)));
                }
            }
        }

        characterList.forEach(System.out::print);
    }
}
