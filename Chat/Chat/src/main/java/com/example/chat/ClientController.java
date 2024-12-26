package com.example.chat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ClientController extends Application implements Initializable {
    @FXML
    private TextArea textAreaAllChat;
    @FXML
    private TextArea textAreaSendMessage;
    Socket socket;
    PrintWriter writer;
    Scanner scanner;
    @FXML

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        try {
            socket = new Socket("localhost", 5678);
            writer = new PrintWriter(socket.getOutputStream(), true);
            scanner = new Scanner(socket.getInputStream());
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        String input = scanner.nextLine();
                        textAreaAllChat.appendText("Server: "+input+"\n");;
                    }
                }
            });
            t.start();
        } catch (Exception e) {
        }

        textAreaSendMessage.setOnKeyPressed(event -> {
            // Check if the "Enter" key is pressed
            if (event.getCode() == KeyCode.ENTER) {
                handleSendAction();
            }

        });
    }
    @FXML
    void handleSendAction(){
        String msg= textAreaSendMessage.getText();
        if(msg.equalsIgnoreCase("rst")){
            textAreaAllChat.clear();
        }
        if(msg.equalsIgnoreCase("")){
            return;
        }
        writer.println(msg);
        textAreaAllChat.appendText("You: " + msg +"\n");
        textAreaSendMessage.setText("");

    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ClientController.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}