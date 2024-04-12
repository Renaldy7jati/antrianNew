package com.example.antriannew;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class homeController extends Application {

    @FXML
    BorderPane borderPane;
    @FXML
    Button settingAntrian;
    @FXML
    Button settingUser;
    @FXML
    Button settingKoneksi;


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(panggilAntrianController.class.getResource("home.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void btnSettingAntrian(ActionEvent actionEvent) throws IOException {
        ScrollPane view = FXMLLoader.load(getClass().getResource("setting-antrian.fxml"));
        borderPane.setCenter(view);
    }

    public void btnSettingUser(ActionEvent actionEvent) throws IOException {
        ScrollPane view = FXMLLoader.load(getClass().getResource("setting-user.fxml"));
        borderPane.setCenter(view);
    }
}
