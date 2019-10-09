package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

public class Solution {
    public static Class getFactoryClass() {
        ExceptionFactory exceptionFactory = new ExceptionFactory();
        return exceptionFactory.getClass();
    }

    public static void main(String[] args) throws Throwable {

    }
}