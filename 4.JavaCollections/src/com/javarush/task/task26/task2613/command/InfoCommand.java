package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

class InfoCommand implements Command {
    @Override
    public void execute() {
        boolean hasMoney = false;

        for (CurrencyManipulator manipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
            if (manipulator.hasMoney()) {
                hasMoney = true;
                String totalAmountString = String.valueOf(manipulator.getTotalAmount());
                ConsoleHelper.writeMessage(manipulator.getCurrencyCode() + " - " + totalAmountString);
            }
        }

        if ( ! hasMoney) {
            ConsoleHelper.writeMessage("No money available.");
        }
    }
}