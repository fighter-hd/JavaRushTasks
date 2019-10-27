package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.class.getPackage().getName()
                                                                        + ".resources.verifiedCards");

    @Override
    public void execute() throws InterruptOperationException {
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
                if ( ! this.validCreditCards.containsKey(cardNumber)) {
                    ConsoleHelper.writeMessage("Card number is not found. Try again:");
                    cardNumber = ConsoleHelper.readString();
                    continue;

                }

                if ( ! pin.equals(this.validCreditCards.getString(cardNumber) ) ) {
                    ConsoleHelper.writeMessage("Pin code is wrong. Enter pin code again:");
                    pin = ConsoleHelper.readString();
                    continue;
                }

                ConsoleHelper.writeMessage("Verification success.");
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
