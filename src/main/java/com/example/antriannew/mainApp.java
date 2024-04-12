package com.example.antriannew;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class mainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainApp.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 560);
        stage.setTitle("ANTRIAN 0.0.1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}