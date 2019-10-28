package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

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
        writeMessage(res.getString("choose.currency.code"));
        String userInput = readString();

        while (userInput == null || userInput.length() != 3) {
            writeMessage(res.getString("invalid.data"));
            writeMessage(res.getString("choose.currency.code"));
            userInput = readString();
        }

        return userInput.toUpperCase();
    }

    public static String[] getValidTwoDigits() throws InterruptOperationException {
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), "conventional units"));
        String userInput = readString();

        while (isNotValidTwoNumbers(userInput)) {
            writeMessage(res.getString("invalid.data"));
            writeMessage(String.format(res.getString("choose.denomination.and.count.format"), "conventional units"));
            userInput = readString();
        }

        return userInput.split(" ");
    }

    private static boolean isNotValidTwoNumbers(String twoNumbers) {
        return twoNumbers == null || ! twoNumbers.matches("^[+]?[1-9]\\d*[ ][+]?[1-9]\\d*");
    }

    public static Operation askOperation() throws InterruptOperationException {
        writeMessage(res.getString("choose.operation"));
        writeOperationsCodeForUserInput();
        String userInput = readString();

        while (userInput == null || ! userInput.matches("[1-4]")) {
            writeMessage(res.getString("invalid.data"));
            writeMessage("Enter code of operation from 1 to 4.");
            writeOperationsCodeForUserInput();
            userInput = readString();
        }

        return Operation.getAllowableOperationByOrdinal(Integer.parseInt(userInput));
    }

    private static void writeOperationsCodeForUserInput() {
        writeMessage("1 - " + res.getString("operation.INFO"));
        writeMessage("2 - " + res.getString("operation.DEPOSIT"));
        writeMessage("3 - " + res.getString("operation.WITHDRAW"));
        writeMessage("4 - " + res.getString("operation.EXIT"));
    }

    public static void printExitMessage() {
        writeMessage("Good bye!");
    }
}
