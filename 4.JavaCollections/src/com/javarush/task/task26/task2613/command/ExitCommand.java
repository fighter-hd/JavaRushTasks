package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class ExitCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.exit_en");


    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));

        String userInput;

        do {
            userInput = ConsoleHelper.readString();

            if (userInput.equals("y")) {
                ConsoleHelper.writeMessage(res.getString("thank.message"));
                break;
            }

            if (userInput.equals("n")) {
                break;
            }

        } while (true);

    }
}