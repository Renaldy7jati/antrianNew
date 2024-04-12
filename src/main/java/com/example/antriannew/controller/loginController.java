package com.example.antriannew.controller;

import com.example.antriannew.mainApp;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.example.antriannew.models.*;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginController {
    @FXML
    TextField username;
    @FXML
    PasswordField password;

    connection connection = new connection();

    settingUser settingUser;

    @FXML
    Button loginButton;

    private Stage stage;
    private Scene scene;
    private Parent parent;


    @FXML
    public void login(ActionEvent actionEvent){
        if(isValidated() == true){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            String loginSQL = "SELECT * FROM `TD_USER` JOIN `TR_ROLE` ON `TD_USER`.`ID_ROLE` = `TR_ROLE`.`ID_ROLE` WHERE `TD_USER`.`USER_NAME` = ?";
            try {
                PreparedStatement preparedStatement = connection.connection.prepareStatement(loginSQL);
                preparedStatement.setString(1,username.getText());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next() && resultSet.getString("USER_NAME") != null){
                    String usernameText = resultSet.getString("USER_NAME");
                    String passwordText = resultSet.getString("PASSWORD");
                    String namaRole = resultSet.getString("NAMA_ROLE");
                    if (!usernameText.isEmpty()&&passwordText.equals(password.getText())) {
                        try {
                            loadScene(resultSet.getString("NAMA_ROLE"),actionEvent);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    }else {
                        alert.setContentText("Password Salah");
                        alert.showAndWait();
                        password.requestFocus();
                    }
                } else {
                    alert.setContentText("Username tidak ditemukan");
                    alert.showAndWait();
                    username.requestFocus();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private boolean isValidated() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("ERROR");
        if (username.getText().equals("")) {
            alert.setContentText("Username tidak boleh kosong!");
            alert.showAndWait();
            username.requestFocus();
        } else if (password.getText().equals("")) {
            alert.setContentText("Password tidak boleh kosong!");
            alert.showAndWait();
            password.requestFocus();
        } else {
            return true;
        }
        return false;
    }





    private void loadScene(String fxml, ActionEvent event) throws IOException {
        switch (fxml){
            case "ADMINISTRATOR":
                parent = FXMLLoader.load(mainApp.class.getResource("home.fxml"));
                break;
            case "LOKET":
                parent = FXMLLoader.load(mainApp.class.getResource("panggil-antrian.fxml"));
                break;
            case "LAYAR":
                parent = FXMLLoader.load(mainApp.class.getResource("monitor-utama.fxml"));
                break;
            case "AMBIL_ANTRIAN":
                parent = FXMLLoader.load(mainApp.class.getResource("ambil-antrian.fxml"));
                break;
        }

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
}
