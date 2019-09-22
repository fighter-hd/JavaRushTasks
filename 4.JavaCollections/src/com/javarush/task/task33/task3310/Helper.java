package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Helper {
    public static String generateRandomString() {
        SecureRandom secureRandom = new SecureRandom();
        return new BigInteger(100, secureRandom).toString(36);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
