package com.example.chat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ServerController extends Application implements Initializable {

    public static void main(String[] args) {
        launch();
    }

    @FXML
    private TextArea textAreaAllChat;
    @FXML
    private TextArea textAreaSendMessage;
    Socket socket;
    PrintWriter writer;
    Scanner scanner;
    ServerSocket serverSocket;
    @FXML

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        try {
            serverSocket = new ServerSocket(5678);
            socket = serverSocket.accept();
            writer = new PrintWriter(socket.getOutputStream(), true);
            scanner = new Scanner(socket.getInputStream());
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        String input = scanner.nextLine();
                        textAreaAllChat.appendText("Client: " +input+ "\n");;
                        }

                }
            });
            t.start();
        } catch (Exception e) {
        }
    }
    @FXML
    void handleSendAction(){
        String msg = textAreaSendMessage.getText();
        if(msg.equalsIgnoreCase("rst")){
            textAreaAllChat.clear();
        }
        if(msg.equalsIgnoreCase("")){
            return;
        }
        writer.println(msg);
        textAreaAllChat.appendText("Server:" + msg+"\n");
        textAreaSendMessage.setText("");
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ServerController.class.getResource("ServerChat.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setScene(scene);
//        stage.setTitle( "Connected to "+socket.getInetAddress().getHostAddress()+":"+socket.getPort());
        stage.setTitle( "Connected to Client");
        stage.show();

    }


}
