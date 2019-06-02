package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        private Socket socket;

        private Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено соединение с удалённым адресом "
                    + socket.getRemoteSocketAddress());

            String userName = null;
            try (Connection connection = new Connection(socket)){
                userName = serverHandshake(connection);

                Message message = new Message(MessageType.USER_ADDED, userName);
                sendBroadcastMessage(message);
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            if (userName != null) {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            }

            ConsoleHelper.writeMessage("Соединение с удалённым адресом "
                    + socket.getRemoteSocketAddress()
                    + " закрыто.");
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));

                Message clientAnswer = connection.receive();
                MessageType messageType = clientAnswer.getType();
                String clientData = clientAnswer.getData();

                if (messageType == MessageType.USER_NAME && !clientData.isEmpty()) {
                    if (connectionMap.containsKey(clientData)) {
                        continue;
                    } else {
                        connectionMap.put(clientData, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return clientData;
                    }
                } else {
                    continue;
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> connectionEntry : connectionMap.entrySet()) {
                String name = connectionEntry.getKey();

                if (name != userName) {
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message acceptedMessage = connection.receive();

                if (acceptedMessage.getType() == MessageType.TEXT) {
                    Message formedMessage = new Message(MessageType.TEXT,
                            userName + ": " + acceptedMessage.getData());

                    sendBroadcastMessage(formedMessage);
                } else {
                    ConsoleHelper.writeMessage("Нe правильный формат сообщения отличный от \"TEXT\"!");
                }
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        try {
            for (Connection connection : connectionMap.values()) {
                connection.send(message);
            }
        } catch (IOException exception) {
            System.out.println("Сообщение не отправлено.");
        }
    }

    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {

            System.out.println("Сервер запущен.");

            while (true) {
                new Handler(serverSocket.accept()).start();
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
