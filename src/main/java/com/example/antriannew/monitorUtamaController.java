package com.example.antriannew.controller;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Timer;

public class monitorUtamaController extends Application implements Initializable{

    @FXML
    public Label noAntrianAktif;
    @FXML
    public Label noAntrianLkt1;
    @FXML
    public Label noAntrianLkt2;
    @FXML
    public Label noAntrianLkt3;
    @FXML
    public Label noAntrianLkt4;
    @FXML
    public Label noAntrianLkt5;
    Timer timer = new Timer();

    com.example.antriannew.controller.connection connection = new connection();

    public static void main(String[] args) {
        Application.launch(args);

    }


    @Override
    public void start(Stage stage) throws Exception {


        FXMLLoader fxmlLoader = new FXMLLoader(monitorUtamaController.class.getResource("monitor-utama.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void loadData(String kodeLoket, Label label){
        String sql = "SELECT MAX(`NOMOR_ANTRIAN`) AS NOMOR_ANTRIAN , `ID_ANTRIAN_HARIAN` FROM `td_antrian_harian` WHERE DATE_FORMAT(`WAKTU_AMBIL_ANTRIAN`, '%Y-%m-%d') = CURRENT_DATE AND `KODE_ANTRIAN` = ? AND `STATUS` IS NOT NULL";
        try {
            PreparedStatement preparedStatement = connection.connection().prepareStatement(sql);
            preparedStatement.setString(1, kodeLoket);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next() && resultSet.getString("ID_ANTRIAN_HARIAN")!= null) {
                label.setText(resultSet.getString("NOMOR_ANTRIAN"));
                return;
            }
            label.setText(label.getText());
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        noAntrianLkt1.setText("");
        noAntrianLkt2.setText("");
        noAntrianLkt3.setText("");
        noAntrianLkt4.setText("");
        noAntrianLkt5.setText("");
        refresher();

    }

    @FXML
    public void refresher() {
        Thread refresherThread = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Thread.sleep(1000);

                    Platform.runLater(() -> {
                        System.out.println("Refresher jalan");
                        loadData("LK001", noAntrianLkt1);
                        loadData("LK001", noAntrianLkt1);
                        loadData("LK002", noAntrianLkt2);
                        loadData("LK003", noAntrianLkt3);
                        loadData("LK004", noAntrianLkt4);
                        loadData("LK005", noAntrianLkt5);
                    });
                }
            } catch (InterruptedException e) {
                // Tangani pengecualian InterruptedException
            }
        });
        refresherThread.start();

        // Tambahkan shutdown hook untuk menghentikan thread saat aplikasi ditutup
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            refresherThread.interrupt();
            System.out.println("Aplikasi ditutup. Thread refresher dihentikan.");
        }));
  }

}




