package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Collections;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));

        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        int requiredAmount = getRequiredAmount();

        while (true) {
            if ( ! currencyManipulator.isAmountAvailable(requiredAmount)) {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                requiredAmount = getRequiredAmount();
                continue;
            }

            Map<Integer, Integer> withdrawnBills;
            try {
                withdrawnBills = currencyManipulator.withdrawAmount(requiredAmount);

            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                requiredAmount = getRequiredAmount();
                continue;
            }

            Map<Integer, Integer> sortedWithdrawnBills = new TreeMap<>(Collections.reverseOrder());
            sortedWithdrawnBills.putAll(withdrawnBills);

            for (Map.Entry<Integer, Integer> entry : sortedWithdrawnBills.entrySet()) {
                ConsoleHelper.writeMessage("\t" + entry.getKey() + " - " + entry.getValue());
            }

            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), requiredAmount, currencyCode));
            break;
        }
    }

    private int getRequiredAmount() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("specify.amount"));
        String userInput = ConsoleHelper.readString();

        while (isInvalidStringOfNumber(userInput)) {
            ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            userInput = ConsoleHelper.readString();
        }

        int amount = Integer.parseInt(userInput);

        return amount;
    }

    private boolean isInvalidStringOfNumber(String userInput) {
        return ! userInput.matches("[1-9]\\d*");
    }
}