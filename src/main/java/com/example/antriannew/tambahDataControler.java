package com.example.antriannew.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class tambahDataControler {

    Stage stage;
    com.example.antriannew.controller.connection connection = new connection();

    @FXML
    TextField kodeAntrian;

    @FXML
    TextField uraianAntrian;

    @FXML
    Button btnTambah;


    public void tambahData(){
        String queryTambah =  "INSERT INTO `tr_antrian` (`ID_ANTRIAN`, `KODE_ANTRIAN`, `URAIAN_ANTRIAN`, `WAKTU_UPDATE`) VALUES (UUID_SHORT(), ?, ?, current_timestamp())";
        String kodeAntrianText = kodeAntrian.getText();
        String uraianAntrianText = uraianAntrian.getText();
        try(PreparedStatement preparedStatement = connection.connection().prepareStatement(queryTambah);) {
            preparedStatement.setString(1,kodeAntrianText);
            preparedStatement.setString(2,uraianAntrianText);
            int hasilTambah = preparedStatement.executeUpdate();
            if(hasilTambah>0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sukses");
                alert.setContentText("Data berhasil ditambahkan!");
                alert.setHeaderText(null);
                alert.showAndWait();
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Gagal!");
                alert.setContentText("Data gagal ditambahkan");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
            Stage stage = (Stage) btnTambah.getScene().getWindow();
            stage.close();
        } catch (SQLException e) {
            Alert alertError = new Alert(Alert.AlertType.ERROR);
            alertError.setTitle("Gagal!");
            alertError.setContentText("Data gagal ditambahkan, detail :" + e.getMessage());
            alertError.setHeaderText(null);
            alertError.showAndWait();
            throw new RuntimeException(e);

        }
    }
}
