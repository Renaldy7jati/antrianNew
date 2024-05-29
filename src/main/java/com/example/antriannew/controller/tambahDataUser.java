package com.example.antriannew.controller;

import com.example.antriannew.models.connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class tambahDataUser implements Initializable{

    Stage stage;
    com.example.antriannew.models.connection connection = new connection();

    @FXML
    TextField username;
    @FXML
    TextField nama;

    @FXML
    TextField password;

    @FXML
    ComboBox<String> role;
    @FXML
    Button btnTambah;

    ObservableList<String> lisRole = FXCollections.observableArrayList();

    public void tambahData(){
        String queryTambah =  "INSERT INTO `td_user` (`ID_USER`, `USER_NAME`, `PASSWORD`, `NAMA`,`ID_ROLE`,`WAKTU_UPDATE`) VALUES (UUID_SHORT(), ?, ?,?,(SELECT ID_ROLE FROM tr_role WHERE NAMA_ROLE = ?), current_timestamp())";
        String userName = username.getText();
        String namaText = nama.getText();
        String passwordText = password.getText();
        String roleText = role.getSelectionModel().getSelectedItem().toString();
        try(PreparedStatement preparedStatement = connection.connection.prepareStatement(queryTambah);) {
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,passwordText);
            preparedStatement.setString(3,namaText);
            preparedStatement.setString(4,roleText);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String sqlDaftarAntrian = "SELECT * FROM `tr_role`";
        try (PreparedStatement preparedStatement = connection.connection.prepareStatement(sqlDaftarAntrian);
             ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                String userRole = resultSet.getString("NAMA_ROLE");
                lisRole.add(resultSet.getString("NAMA_ROLE"));
            }
            role.setItems(lisRole);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
