package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Древний Рим
*/
public class Solution {
    private enum RomanDigits {
        I, V, X, L, C, D, M
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        if ( ! isValidString(s)) {
            return -1;
        }

        int result = 0;
        Map<Character, Integer> romanDigits = getRomanDigits();

        char lastChar = s.charAt(s.length() - 1);
        result += romanDigits.get(lastChar);

        for (int i = s.length() - 2; i >= 0; i--) {
            char currentChar = s.charAt(i);
            char nextChar = s.charAt(i + 1);

            if (isCurrentCharSmallerThanNextChar(currentChar, nextChar)) {
                
                if (isPreviousCharNotSame(s, i)
                    && isContainDigitOne(currentChar)
                    && isNearestSmallDigitForDecrement(currentChar, nextChar)) {

                    result -= romanDigits.get(currentChar);

                } else {
                    return -1;
                }

            } else {
                result += romanDigits.get(currentChar);
            }
        }

        return result;
    }

    private static boolean isValidString(String s) {
        if (isWrongChars(s)
            || isMoreThanTwoIdenticalDigitsWithFiveInRow(s)
            || isMoreThanThreeIdenticalDigitsInRow(s)
            || isMoreThanOneDecreasingNumInRow(s)) {

                return false;
        }

        return true;
    }

    private static boolean isWrongChars(String s) {
        return ! s.matches("[IVXLCDM]*");
    }

    private static boolean isMoreThanTwoIdenticalDigitsWithFiveInRow(String s) {
        return s.contains("VV") || s.contains("LL") || s.contains("DD");
    }

    private static boolean isMoreThanThreeIdenticalDigitsInRow(String s) {
        return s.contains("IIII") || s.contains("XXXX") || s.contains("CCCC") || s.contains("MMMM");
    }

    private static boolean isMoreThanOneDecreasingNumInRow(String string) {
        int count = 0;

        for (int i = string.length() - 2; i >= 0; i--) {
            char currentChar = string.charAt(i);
            char nextChar = string.charAt(i + 1);

            if (isCurrentCharSmallerThanNextChar(currentChar, nextChar)) {
                count++;

            } else {
                count = 0;
            }

            if (count > 1) {
                return true;
            }
        }

        return false;
    }

    private static Map<Character, Integer> getRomanDigits() {
        Map<Character, Integer> romanDigits = new HashMap<>();

        romanDigits.put('I', 1);
        romanDigits.put('V', 5);
        romanDigits.put('X', 10);
        romanDigits.put('L', 50);
        romanDigits.put('C', 100);
        romanDigits.put('D', 500);
        romanDigits.put('M', 1000);

        return romanDigits;
    }

    private static boolean isCurrentCharSmallerThanNextChar(char currentChar, char nextChar) {
        RomanDigits currentNumber = getRomanDigit(currentChar);
        RomanDigits nextNumber = getRomanDigit(nextChar);

        return currentNumber.ordinal() < nextNumber.ordinal();
    }

    private static RomanDigits getRomanDigit(char c) {
        switch(c) {
            case 'I':
                return RomanDigits.I;
            case 'V':
                return RomanDigits.V;
            case 'X':
                return RomanDigits.X;
            case 'L':
                return RomanDigits.L;
            case 'C':
                return RomanDigits.C;
            case 'D':
                return RomanDigits.D;
            case 'M':
                return RomanDigits.M;
        }

        return null;
    }

    private static boolean isContainDigitOne(char currentChar) {
        return currentChar == 'I' || currentChar == 'X' || currentChar == 'C' || currentChar == 'M';
    }

    private static boolean isPreviousCharNotSame(String checkedString, int index) {
        return index <= 0 || checkedString.charAt(index) != checkedString.charAt(index - 1);
    }

    private static boolean isNearestSmallDigitForDecrement(char firstChar, char secondChar) {
        if (secondChar == 'M' || secondChar == 'D') {
            return firstChar == 'C';

        } else if (secondChar == 'C' || secondChar == 'L') {
            return firstChar == 'X';

        } else if (secondChar == 'X' || secondChar == 'V') {
            return firstChar == 'I';
        }

        return false;
    }
}
