package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

class WithdrawCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        int requiredAmount = getRequiredAmount(currencyCode);

        while (true) {
            if ( ! currencyManipulator.isAmountAvailable(requiredAmount)) {
                ConsoleHelper.writeMessage("The requested amount is not available. Please enter a available amount.");
                requiredAmount = getRequiredAmount(currencyCode);
                continue;
            }

            Map<Integer, Integer> withdrawnBills;
            try {
                withdrawnBills = currencyManipulator.withdrawAmount(requiredAmount);

            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage("Shortage of banknotes. Please enter a available amount.");
                requiredAmount = getRequiredAmount(currencyCode);
                continue;
            }

            Map<Integer, Integer> sortedWithdrawnBills = new TreeMap<>(Collections.reverseOrder());
            sortedWithdrawnBills.putAll(withdrawnBills);

            for (Map.Entry<Integer, Integer> entry : sortedWithdrawnBills.entrySet()) {
                ConsoleHelper.writeMessage("\t" + entry.getKey() + " - " + entry.getValue());
            }

            ConsoleHelper.writeMessage("Withdraw operation was successful.");
            break;
        }
    }

    private int getRequiredAmount(String currencyCode) throws InterruptOperationException {
        ConsoleHelper.writeMessage("Enter the withdraw amount:");
        String userInput = ConsoleHelper.readString();

        while (isInvalidStringOfNumber(userInput)) {
            ConsoleHelper.writeMessage("Invalid number. Enter again valid number:");
            userInput = ConsoleHelper.readString();
        }

        int amount = Integer.parseInt(userInput);

        return amount;
    }

    private boolean isInvalidStringOfNumber(String userInput) {
        return ! userInput.matches("[1-9]\\d*");
    }
}