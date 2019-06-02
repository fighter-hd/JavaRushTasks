package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class BotClient extends Client {
    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (!message.contains(": ")) return;

            String[] textArray = message.split(":");
            String nameOfUser = textArray[0];
            String data = textArray[1].trim();

            SimpleDateFormat dateFormat;
            String resultMessage = "Информация для " + nameOfUser +": ";
            Date time = new GregorianCalendar().getTime();

            switch (data) {
                case ("дата"):
                    dateFormat = new SimpleDateFormat("d.MM.YYYY");
                    resultMessage += dateFormat.format(time);
                    sendTextMessage(resultMessage);
                    break;

                case ("день"):
                    dateFormat = new SimpleDateFormat("d");
                    resultMessage += dateFormat.format(time);
                    sendTextMessage(resultMessage);
                    break;

                case ("месяц"):
                    dateFormat = new SimpleDateFormat("MMMM");
                    resultMessage += dateFormat.format(time);
                    sendTextMessage(resultMessage);
                    break;

                case ("год"):
                    dateFormat = new SimpleDateFormat("YYYY");
                    resultMessage += dateFormat.format(time);
                    sendTextMessage(resultMessage);
                    break;

                case ("время"):
                    dateFormat = new SimpleDateFormat("H:mm:ss");
                    resultMessage += dateFormat.format(time);
                    sendTextMessage(resultMessage);
                    break;

                case ("час"):
                    dateFormat = new SimpleDateFormat("H");
                    resultMessage += dateFormat.format(time);
                    sendTextMessage(resultMessage);
                    break;

                case ("минуты"):
                    dateFormat = new SimpleDateFormat("m");
                    resultMessage += dateFormat.format(time);
                    sendTextMessage(resultMessage);
                    break;

                case ("секунды"):
                    dateFormat = new SimpleDateFormat("s");
                    resultMessage += dateFormat.format(time);
                    sendTextMessage(resultMessage);
                    break;
            }
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        int x = (int) (Math.random() * 100);
        return "date_bot_" + x;
    }

    public static void main(String[] args) {
        new BotClient().run();
    }
}
