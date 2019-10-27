package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

public class LoginCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        String hardCardNumber = "123456789012";
        String hardPin = "1234";

        ConsoleHelper.writeMessage("Enter card number - 12 digit.");
        String cardNumber = ConsoleHelper.readString();

        ConsoleHelper.writeMessage("Enter card pin code - 4 digit");
        String pin = ConsoleHelper.readString();

        while (true) {
            if (isInvalidCardNumber(cardNumber)) {
                ConsoleHelper.writeMessage("Invalid card number. Try again. Enter card number - 12 digit:");
                cardNumber = ConsoleHelper.readString();

            } else if (isInvalidPinCode(pin)) {
                ConsoleHelper.writeMessage("Invalid card pin code. Try again. Enter card pin code - 4 digit:");
                pin = ConsoleHelper.readString();

            } else {
                if ( ! cardNumber.equals(hardCardNumber)) {
                    ConsoleHelper.writeMessage("Enter hard card number - 123456789012");
                    cardNumber = ConsoleHelper.readString();
                    continue;

                } else if (! pin.equals(hardPin)) {
                    ConsoleHelper.writeMessage("Enter hard card pin code - 1234");
                    pin = ConsoleHelper.readString();
                    continue;

                } else {
                    ConsoleHelper.writeMessage("Verification success.");
                }
                break;
            }
        }
    }

    private boolean isInvalidCardNumber(String cardNumber) {
        return ! cardNumber.matches("\\d{12}");
    }

    private boolean isInvalidPinCode(String pin) {
        return ! pin.matches("\\d{4}");
    }
}
