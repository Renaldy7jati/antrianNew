package com.example.antriannew.models;


import com.example.antriannew.mainApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.*;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    public Connection connection;

    private final String connectionURL = "jdbc:mysql://localhost:3306/antriannew";
    private final String username = "user001";
    private final String pass = "Makinbaik1!";

    private String driver = "jdbc:mysql://";
    private String host;
    private String port;
    private String sid;
    private String user;
    private String password;

    private String[] data;

    private void bacaKoneksi(){
        try {
            File file = new File(mainApp.class.getResource("settingCon.txt").toURI());
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine())!= null){
                data = line.split(";");
                host = data[0];
                port = data[1];
                sid = data[2];
                user = data[3];
                password = data[4];
            }
            bufferedReader.close();

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public connection() {
        bacaKoneksi();
        String koneksi = driver.concat(host).concat(":").concat(port).concat("/").concat(sid);
        try {
            this.connection = DriverManager.getConnection(koneksi,user,password);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("KONEKSI GAGAL");
            alert.setHeaderText(null);
            alert.setContentText("Koneksi gagal, silahkan perika pengaturan koneksi!");
            alert.showAndWait();
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection(){
        return this.connection;
    }

}
