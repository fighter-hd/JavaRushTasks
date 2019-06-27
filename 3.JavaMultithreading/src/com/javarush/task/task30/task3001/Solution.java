package com.javarush.task.task30.task3001;

import java.math.BigInteger;

/*
Конвертер систем счислений
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        Number number1 = new Number(NumberSystemType._16, "6df");
        Number result1 = convertNumberToOtherNumberSystem(number1, NumberSystemType._8);
        System.out.println(result1);    //expected 3337

        Number number2 = new Number(NumberSystemType._16, "abcdefabcdef");
        Number result2 = convertNumberToOtherNumberSystem(number2, NumberSystemType._16);
        System.out.println(result2);    //expected abcdefabcdef

//        Number number3 = new Number(NumberSystemType._16, "-6df");
//        Number result3 = convertNumberToOtherNumberSystem(number3, NumberSystemType._8);
//        System.out.println(result3);    //expected 3337

        Number number4 = new Number(NumberSystemType._2, "120");
        Number result4 = convertNumberToOtherNumberSystem(number4, NumberSystemType._10);
        System.out.println(result4);    //expected
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        Number result;

        try {
            BigInteger bInt = new BigInteger(number.getDigit(), number.getNumberSystem().getNumberSystemIntValue());

            if (bInt.compareTo(new BigInteger("0", 10)) < 0) {
                throw new NumberFormatException("Invalid result number (less then 0).");
            }

            result = new Number(expectedNumberSystem, bInt.toString(expectedNumberSystem.getNumberSystemIntValue()));

        } catch (Throwable e) {
            throw new NumberFormatException(e.getMessage());
        }

        return result;
    }
}
