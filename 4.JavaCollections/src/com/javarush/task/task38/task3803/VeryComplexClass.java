package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

import java.util.Date;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object o = "the string";
        int i = (Integer) o;
    }

    public void methodThrowsNullPointerException() {
        Date emptyDate = null;
        emptyDate.getTime();
    }

    public static void main(String[] args) {

    }
}
