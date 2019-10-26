package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

class ExitCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Do you want to exit?\nEnter 'y' or 'n'");

        String userInput;

        do {
            userInput = ConsoleHelper.readString();

            if (userInput.equals("y")) {
                ConsoleHelper.writeMessage("Good bye!");
                break;
            }

            if (userInput.equals("n")) {
                break;
            }

        } while (true);

    }
}