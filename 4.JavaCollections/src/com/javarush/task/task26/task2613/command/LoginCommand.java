package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.class.getPackage().getName()
                                                                                  + ".resources.verifiedCards");

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        ConsoleHelper.writeMessage(res.getString("specify.data"));

        String cardNumber = ConsoleHelper.readString();
        String pin = ConsoleHelper.readString();

        while (true) {
            if (isInvalidCardNumber(cardNumber) || isInvalidPinCode(pin)) {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));

                cardNumber = ConsoleHelper.readString();
                pin = ConsoleHelper.readString();

            } else {
                if ( ! this.validCreditCards.containsKey(cardNumber) || ! pin.equals(this.validCreditCards.getString(cardNumber))) {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNumber));
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    cardNumber = ConsoleHelper.readString();
                    pin = ConsoleHelper.readString();
                    continue;
                }

                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardNumber));;
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
