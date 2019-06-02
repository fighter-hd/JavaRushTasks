package com.javarush.task.task09.task0906;

/* 
Логирование стек трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        StackTraceElement stack = Thread.currentThread().getStackTrace()[2];
        System.out.println(stack.getClassName() + ": " + stack.getMethodName() + ": " + s);
    }
}
