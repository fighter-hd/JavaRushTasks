package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        if (s.charAt(0) == '0') {
            int value;

            switch (s.charAt(1)) {
                case 'x':
                    value = Integer.parseInt(s.substring(2), 16);
                    break;

                case 'b':
                    value = Integer.parseInt(s.substring(2), 2);
                    break;

                default:
                    value = Integer.parseInt(s.substring(1), 8);

            }

            s = String.valueOf(value);
        }

        return s;
    }
}
