package com.javarush.task.task34.task3412;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/* 
Добавление логирования в класс
*/

public class Solution {
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    private int value1;
    private String value2;
    private Date value3;

    public Solution(int value1, String value2, Date value3) {
        this.value1 = value1;
        logger.debug("set value1", value1);

        this.value2 = value2;
        this.value3 = value3;
    }

    public static void main(String[] args) {

    }

    public void calculateAndSetValue3(long value) {
        logger.trace("\"calculateAndSetValue3\" method call", value);

        value -= 133;
        if (value > Integer.MAX_VALUE) {
            value1 = (int) (value / Integer.MAX_VALUE);
            logger.debug("set value1");
        } else {
            value1 = (int) value;
            logger.debug("set value1");
        }
    }

    public void printString() {
        logger.trace("\"printString\" method call");

        if (value2 != null) {
            System.out.println(value2.length());
        }
    }

    public void printDateAsLong() {
        logger.trace("\"printDateAsLong\" method call");

        if (value3 != null) {
            System.out.println(value3.getTime());
        }
    }

    public void divide(int number1, int number2) {
        logger.trace("\"divide\" method call", number1, number2);
        try {
            System.out.println(number1 / number2);
        } catch (ArithmeticException e) {
            logger.error("ArithmeticException: " + e);
        }
    }

    public void setValue1(int value1) {
        this.value1 = value1;
        logger.debug("set value1", value1);
    }

    public void setValue2(String value2) {
        this.value2 = value2;
        logger.debug("set value2", value2);
    }

    public void setValue3(Date value3) {
        this.value3 = value3;
        logger.debug("set value3", value3);
    }
}
