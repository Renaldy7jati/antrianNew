package com.example.antriannew.controller;

import com.example.antriannew.models.connection;
import com.example.antriannew.models.settingAntrian;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class editDataController {
    Stage stage;
    com.example.antriannew.models.connection connection = new connection();

    private com.example.antriannew.models.settingAntrian settingAntrian;


    @FXML
    private TextField kodeAntrian;

    @FXML
    private TextField uraianAntrian;

    @FXML
    Button btnSimpan;


    public void initData(settingAntrian settingAntrian) {
        this.settingAntrian = settingAntrian;
        kodeAntrian.setText(settingAntrian.getKode_antrian());
        uraianAntrian.setText(settingAntrian.getUraian_antrian());

    }
        public void editData() {
        String queryEdit = "UPDATE `tr_antrian` SET `KODE_ANTRIAN` = ?, `URAIAN_ANTRIAN` = ?, `WAKTU_UPDATE` = current_timestamp() WHERE `tr_antrian`.`ID_ANTRIAN` = ?";
        String kodeAntrianText = kodeAntrian.getText();
        String uraianAntrianText = uraianAntrian.getText();
        try (PreparedStatement preparedStatement = connection.connection.prepareStatement(queryEdit);) {
            preparedStatement.setString(1, kodeAntrianText);
            preparedStatement.setString(2, uraianAntrianText);
            preparedStatement.setString(3, settingAntrian.getId_antrian());
            int hasilTambah = preparedStatement.executeUpdate();
            if (hasilTambah > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sukses");
                alert.setContentText("Data berhasil diedit!");
                alert.setHeaderText(null);
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Gagal!");
                alert.setContentText("Data gagal diedit");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
            Stage stage = (Stage) btnSimpan.getScene().getWindow();
            stage.close();
        } catch (SQLException e) {
            Alert alertError = new Alert(Alert.AlertType.ERROR);
            alertError.setTitle("Gagal!");
            alertError.setContentText("Data gagal diedit, detail :" + e.getMessage());
            alertError.setHeaderText(null);
            alertError.showAndWait();
            throw new RuntimeException(e);


        }
    }

}
