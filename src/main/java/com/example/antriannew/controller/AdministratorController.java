package com.example.antriannew.controller;

import com.example.antriannew.mainApp;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class AdministratorController {

    @FXML
    BorderPane borderPane;
    @FXML
    Button settingAntrian;
    @FXML
    Button settingUser;
    @FXML
    Button settingKoneksi;

    @FXML
    Button logOut;

    Parent parent;
    Scene scene;
    Stage stage;

    @FXML
    public void btnSettingAntrian(ActionEvent actionEvent) throws IOException {
        ScrollPane view = FXMLLoader.load(mainApp.class.getResource("setting-antrian.fxml"));

        borderPane.setCenter(view);
    }

    @FXML
    public void btnSettingUser(ActionEvent actionEvent) throws IOException {
        ScrollPane view = FXMLLoader.load(mainApp.class.getResource("setting-user.fxml"));
        borderPane.setCenter(view);
    }

    @FXML
    public void btnLogOut(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Log Out !");
        alert.setHeaderText(null);
        alert.setContentText("Anda yakin log out ?");
        Optional<ButtonType> confirm = alert.showAndWait();
        if(confirm.isPresent() && confirm.get().equals(ButtonType.OK)){
            parent = FXMLLoader.load(mainApp.class.getResource("login.fxml"));
            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        }else {
            return;
        }
    }
}
