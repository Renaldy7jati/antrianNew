package com.example.antriannew.controller;

import com.example.antriannew.mainApp;
import com.example.antriannew.models.connection;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class settingKoneksiController implements Initializable {

    @FXML
    TextField host;
    @FXML
    TextField port;
    @FXML
    TextField sid;
    @FXML
    TextField user;
    @FXML
    TextField password;
    @FXML
    TextArea message;
    @FXML
    Button connectDB;
    @FXML
    Button exit;

    String[] data;


    public void bacaFile() {
        try {
            URL url = mainApp.class.getResource("settingCon.txt");
            if (url == null) {

            } else {
                System.out.println(url);
                FileReader fileReader = new FileReader(new File(url.toURI()));
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    data = line.split(";");
                    host.setText(data[0]);
                    port.setText(data[1]);
                    sid.setText(data[2]);
                    user.setText(data[3]);
                    password.setText(data[4]);
                }
                bufferedReader.close();
                fileReader.close();
            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public void tulisFile(){

        URL url = mainApp.class.getResource("settingCon.txt");
        try {
            File file = new File(url.toURI());
            FileWriter fileWriter = new FileWriter(file);
            String data = host.getText().concat(";")
                    .concat(port.getText()).concat(";")
                    .concat(sid.getText()).concat(";")
                    .concat(user.getText()).concat(";")
                    .concat(password.getText());
            fileWriter.write(data);
            fileWriter.close();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        testConnection();
        System.out.println("sukses");

    }


    private void testConnection(){
        connection connection = new connection();
        try {
            connection.connection.getClientInfo();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("SUKSES");
        alert.setHeaderText("");
        alert.setContentText("Koneksi Sukses");
        alert.showAndWait();
        try {
            connection.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void exit(){
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        bacaFile();
    }
}
