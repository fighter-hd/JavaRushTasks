package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        try {
            String userInput = bis.readLine();

            if (userInput.toLowerCase().contains("exit")) {
                throw new InterruptOperationException();
            }

            return userInput;

        } catch (IOException ignore) { /* do nothing */ }

        return null;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage("Enter currency code in 3 letter.");
        String userInput = readString();

        while (userInput == null || userInput.length() != 3) {
            writeMessage("Invalid input. Please, enter currency code in 3 letter.");
            userInput = readString();
        }

        return userInput.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        String requestMessage = "Enter the nominal of the currency and the amount, separated by a space (two positive numbers).";
        writeMessage(requestMessage);
        String userInput = readString();

        while (isNotValidTwoNumbers(userInput)) {
            writeMessage("Invalid Input. Numbers cannot be an empty string, negative or start from zero.\n" + requestMessage);
            userInput = readString();
        }

        return userInput.split(" ");
    }

    private static boolean isNotValidTwoNumbers(String twoNumbers) {
        return twoNumbers == null || ! twoNumbers.matches("^[+]?[1-9]\\d*[ ][+]?[1-9]\\d*");
    }

    public static Operation askOperation() throws InterruptOperationException {
        writeMessage("Enter code of operation:\n1 - INFO\n2 - DEPOSIT\n3 - WITHDRAW\n4 - EXIT");
        String userInput = readString();

        while (userInput == null || ! userInput.matches("[1-4]")) {
            writeMessage("Invalid input. Please, enter code of operation from 1 to 4.");
            userInput = readString();
        }

        return Operation.getAllowableOperationByOrdinal(Integer.parseInt(userInput));
    }
}
