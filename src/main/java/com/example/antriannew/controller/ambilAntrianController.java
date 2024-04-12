package com.example.antriannew.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class ambilAntrianController implements Initializable {

    Statement statement;

    private static final Logger logger = Logger.getLogger(ambilAntrianController.class.getName());

    com.example.antriannew.controller.connection connection = new connection();
    @FXML
    Button btnLK1;
    @FXML
    Button btnLK2;
    @FXML
    Button btnLK3;
    @FXML
    Button btnLK4;
    @FXML
    Button btnLK5;
    @FXML
    VBox vBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadScene();
    }

    protected void loadScene() {
        String query = "SELECT URAIAN_ANTRIAN FROM TR_ANTRIAN WHERE KODE_ANTRIAN = ?";
        try (PreparedStatement statement = connection.connection.prepareStatement(query)) {
            // Mengatur teks tombol-tombol berdasarkan data dari tabel TR_ANTRIAN
            for (int i = 1; i <= 5; i++) {
                statement.setString(1, "LK00" + i);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        switch (i) {
                            case 1:
                                btnLK1.setText(resultSet.getString("URAIAN_ANTRIAN"));
                                break;
                            case 2:
                                btnLK2.setText(resultSet.getString("URAIAN_ANTRIAN"));
                                break;
                            case 3:
                                btnLK3.setText(resultSet.getString("URAIAN_ANTRIAN"));
                                break;
                            case 4:
                                btnLK4.setText(resultSet.getString("URAIAN_ANTRIAN"));
                                break;
                            case 5:
                                btnLK5.setText(resultSet.getString("URAIAN_ANTRIAN"));
                                break;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void handleButtonAction(String kodeAntrian) {
        String cek = "SELECT COALESCE(MAX(`NOMOR_ANTRIAN`), 0) AS MAX_NOMOR FROM `td_antrian_harian` WHERE DATE_FORMAT(`WAKTU_AMBIL_ANTRIAN`, '%Y-%m-%d') = CURRENT_DATE AND `KODE_ANTRIAN` = ?";
        String query = "INSERT INTO `td_antrian_harian` (`ID_ANTRIAN_HARIAN`, `KODE_ANTRIAN`, `NOMOR_ANTRIAN`, `WAKTU_AMBIL_ANTRIAN`)\n" +
                "SELECT UUID_SHORT(), ?, COALESCE(MAX(`NOMOR_ANTRIAN`), 0) + 1, CURRENT_TIMESTAMP()\n" +
                "FROM `td_antrian_harian`\n" +
                "WHERE DATE(`WAKTU_AMBIL_ANTRIAN`) = CURRENT_DATE()\n" +
                "AND `KODE_ANTRIAN` = ?";

        String queryPertama = "INSERT INTO td_antrian_harian (ID_ANTRIAN_HARIAN, KODE_ANTRIAN, NOMOR_ANTRIAN, WAKTU_AMBIL_ANTRIAN)\n" +
                "VALUES (UUID_SHORT(), ?, 1, CURRENT_TIMESTAMP())";

        try (PreparedStatement statement1 = connection.connection.prepareStatement(cek)) {
            statement1.setString(1, kodeAntrian);
            ResultSet resultSet = statement1.executeQuery();
            System.out.println(statement1);
            if(resultSet.next() && resultSet.getInt("MAX_NOMOR") > 0) {
                PreparedStatement statement = connection.connection.prepareStatement(query);
                statement.setString(1, kodeAntrian);
                statement.setString(2, kodeAntrian);
                statement.execute();
                System.out.println(statement);
            } else {
                PreparedStatement statement = connection.connection.prepareStatement(queryPertama);
                statement.setString(1, kodeAntrian);
                statement.execute();
                System.out.println(statement);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @FXML
    protected void btnLK1() {
        handleButtonAction("LK001");
    }

    @FXML
    protected void btnLK2() {
        handleButtonAction("LK002");
    }

    @FXML
    protected void btnLK3() {
        handleButtonAction("LK003");
    }

    @FXML
    protected void btnLK4() {
        handleButtonAction("LK004");
    }

    @FXML
    protected void btnLK5() {
        handleButtonAction("LK005");
    }
}
