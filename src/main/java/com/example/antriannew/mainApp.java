package com.example.antriannew;

import com.example.antriannew.models.connection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;

public class mainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        String fxmlFile = "login.fxml";
//        if(cekKoneksi()){
//            fxmlFile = "login.fxml";
//        }else {
//            fxmlFile = "setting-koneksi.fxml";
//        }
        FXMLLoader fxmlLoader = new FXMLLoader(mainApp.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ANTRIAN 0.0.1");
        stage.setScene(scene);
        stage.show();
    }

    private boolean cekKoneksi() {
        System.out.println("sampai sini");
        try {
            connection connection = new connection();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        launch();
    }
}