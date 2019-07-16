package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int bigA = 'A';
        int bigZ = 'Z';
        int a = 'a';
        int z = 'z';
        int zero = '0';
        int nine = '9';

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            char c;

            switch ((int) (Math.random() * 3)) {
                case 0:
                    c = (char) (Math.random() * 9 + zero);
                    builder.append(c);
                    break;

                case 1:
                    c = (char) (Math.random() * (bigZ - bigA) + bigA);
                    builder.append(c);
                    break;

                case 2:
                    c = (char) (Math.random() * (z - a) + a);
                    builder.append(c);
                    break;
            }
        }

        if ( ! isCharPresent(builder, zero, nine)) {
            char c = (char) (Math.random() * 9 + zero);
            builder.setCharAt(5, c);
        }

        if ( ! isCharPresent(builder, bigA, bigZ)) {
            char c = (char) (Math.random() * (bigZ - bigA) + bigA);
            builder.setCharAt(6, c);
        }

        if ( ! isCharPresent(builder, a, z)) {
            char c = (char) (Math.random() * (z - a) + a);
            builder.setCharAt(7, c);
        }

        String password = builder.toString();

        try {
            output.write(password.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output;
    }

    private static boolean isCharPresent(StringBuilder builder, int first, int last) {
        boolean isPresent = false;

        for (int i = 0; i < 5; i++) {
            int c = builder.charAt(i);

            if (c >= first && c <= last) {
                isPresent = true;
                break;
            }
        }

        return isPresent;
    }
}