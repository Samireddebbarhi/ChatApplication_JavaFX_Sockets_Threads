package org.example.demo1;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Clients {
    @FXML
    private TextArea chatArea;
    @FXML
    private TextField inputField;
    private PrintWriter out;
    private BufferedReader in;

    public void connectToServer() {
        try {
            Socket socket = new Socket("localhost", 9090);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Thread to listen for messages from the server
            new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        String finalMessage = message;
                        Platform.runLater(() -> chatArea.appendText("Server: " + finalMessage + "\n"));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage() {
        String message = inputField.getText();
        if (!message.isEmpty()) {
            out.println(message); // Send message to the server
            chatArea.appendText("You: " + message + "\n"); // Display sent message in the chat area
            inputField.clear();
        }
    }






}