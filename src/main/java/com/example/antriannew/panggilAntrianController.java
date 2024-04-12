package com.example.antriannew.controller;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class panggilAntrianController extends Application implements Initializable {
    @FXML
    Label nomorAntrian;

    @FXML
    ComboBox<String> listJenisAntrian;

    @FXML
    Button btnNext;

    @FXML
    Button btnPanggilUlang;

    com.example.antriannew.controller.connection connection = new connection();
    ObservableList<String> listAntrian = FXCollections.observableArrayList();
    String ID_ANTRIAN_HARIAN;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String sqlDaftarAntrian = "SELECT * FROM `tr_antrian`";
        try (PreparedStatement preparedStatement = connection.connection().prepareStatement(sqlDaftarAntrian);
             ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                String kodeAntrian = resultSet.getString("URAIAN_ANTRIAN");
                listAntrian.add(resultSet.getString("URAIAN_ANTRIAN"));
            }
            listJenisAntrian.setItems(listAntrian);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(panggilAntrianController.class.getResource("panggil-antrian.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    public void panggil(){
        String queryPanggil = "SELECT COALESCE(MIN(`NOMOR_ANTRIAN`),0) AS MIN_NOMOR , `ID_ANTRIAN_HARIAN` FROM `td_antrian_harian` WHERE DATE_FORMAT(`WAKTU_AMBIL_ANTRIAN`, '%Y-%m-%d') = CURRENT_DATE AND `KODE_ANTRIAN` = (SELECT KODE_ANTRIAN FROM tr_antrian WHERE URAIAN_ANTRIAN = ?) AND `STATUS` IS NULL";
        String kodeAntrianAktif = listJenisAntrian.getSelectionModel().getSelectedItem().toString();
        try (PreparedStatement preparedStatement = connection.connection().prepareStatement(queryPanggil)){
            preparedStatement.setString(1,kodeAntrianAktif);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next() && resultSet.getInt(1) != 0 ){
                System.out.println(resultSet.getString(2));
                nomorAntrian.setText(resultSet.getString("MIN_NOMOR"));
                String queryUpdateStatus = "UPDATE `td_antrian_harian` SET `STATUS` = 'Y' WHERE `td_antrian_harian`.`ID_ANTRIAN_HARIAN` = ?";
                PreparedStatement statementUpdate = connection.connection().prepareStatement(queryUpdateStatus);
                statementUpdate.setString(1,resultSet.getString("ID_ANTRIAN_HARIAN"));
                statementUpdate.executeUpdate();
            }else {
                nomorAntrian.setText("ANTRIAN KOSONG SAAT INI, SILAHKAN PANGGIL ULANG");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void panggilUlang(){
        String queryPanggil = "SELECT COALESCE(MIN(`NOMOR_ANTRIAN`), 0) AS MIN_NOMOR , `ID_ANTRIAN_HARIAN` FROM `td_antrian_harian` WHERE `ID_ANTRIAN_HARIAN = ?`";
        String kodeAntrianAktif = listJenisAntrian.getSelectionModel().getSelectedItem().toString();
        try (PreparedStatement preparedStatement = connection.connection().prepareStatement(queryPanggil)){
            preparedStatement.setString(1,ID_ANTRIAN_HARIAN);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next() && resultSet.getInt("MIN_NOMOR")> 0){
                nomorAntrian.setText(resultSet.getString("MIN_NOMOR"));
            }else {
                nomorAntrian.setText("ANTRIAN KOSONG SAAT INI, SILAHKAN PANGGIL ULANG");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
