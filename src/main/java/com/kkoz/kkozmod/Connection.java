package com.kkoz.kkozmod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Connection extends Thread {

    private static Connection connection;

    private final String host = "localhost";
    private final int port = 1234;

    private static BufferedReader inStream;

    public void connect() {
        if (connection != null) {
            return;
        }
        try {
            Socket socket = new Socket(host, port);
            try {
                inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                start();
            } catch (IOException e) {
                KkozMod.LOGGER.error("Reading failed");
            }
        } catch (IOException e) {
            KkozMod.LOGGER.error("Socket failed");
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = inStream.readLine();
                KkozMod.LOGGER.info(message);
                Notification.sendMessage(message);

            }
        } catch (IOException e) {
            KkozMod.LOGGER.error("Failed");
        }
    }
}
