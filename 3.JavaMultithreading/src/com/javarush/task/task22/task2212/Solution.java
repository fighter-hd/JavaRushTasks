package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.length() < 10) {
            return false;
        }
        return telNumber.matches("(\\+\\d{2})?[(]?\\d{3}[)]?\\d{3}[-]?\\d{2}[-]?\\d{2}");
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));
        System.out.println(checkTelNumber("+38)050)1234567"));
        System.out.println(checkTelNumber("+38(05)01234567"));
        System.out.println(checkTelNumber("(050)1234567"));
        System.out.println(checkTelNumber("0501-2345-67"));
        System.out.println(checkTelNumber(null));
    }
}
