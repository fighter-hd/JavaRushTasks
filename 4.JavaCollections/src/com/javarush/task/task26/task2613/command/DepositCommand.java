package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

class DepositCommand implements Command {
    @Override
    public void execute() {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        String[] nominalAndCount = ConsoleHelper.getValidTwoDigits(currencyCode);

        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        int nominal = Integer.parseInt(nominalAndCount[0]);
        int count = Integer.parseInt(nominalAndCount[1]);

        currencyManipulator.addAmount(nominal, count);
    }
}
