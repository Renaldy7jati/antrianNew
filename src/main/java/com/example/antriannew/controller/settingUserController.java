package com.example.antriannew.controller;

import com.example.antriannew.mainApp;
import com.example.antriannew.models.connection;
import com.example.antriannew.models.settingUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.ResourceBundle;

public class settingUserController implements Initializable {


    com.example.antriannew.models.connection connection = new connection();
    @FXML
    TableView<settingUser> tableView = new TableView<>();

    private final ObservableList<settingUser> settingUsers = FXCollections.observableArrayList();
    String query = "SELECT td_user.ID_USER, td_user.PASSWORD,td_user.USER_NAME, td_user.NAMA, td_user.WAKTU_UPDATE, tr_role.NAMA_ROLE FROM td_user JOIN tr_role ON td_user.ID_ROLE = tr_role.ID_ROLE";


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableView.setMinWidth(tableView.getMinWidth());
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        //TableColumn id_user = new TableColumn<>("ID User");
        TableColumn user_name = new TableColumn<>("Username");
        //TableColumn password = new TableColumn<>("Password");
        TableColumn nama = new TableColumn<>("Nama");
        TableColumn role = new TableColumn<>("Role");
        //TableColumn waktu_update = new TableColumn<>("Waktu Update");

        tableView.getColumns().addAll(/*id_user,*/user_name,/*password,*/nama, role/*,waktu_update*/);

        //id_user.setCellValueFactory(new PropertyValueFactory<settingUser,String>("id_user"));
        user_name.setCellValueFactory(new PropertyValueFactory<settingUser, String>("user_name"));
        //password.setCellValueFactory(new PropertyValueFactory<settingUser,String>("password"));
        nama.setCellValueFactory(new PropertyValueFactory<settingUser, String>("nama"));
        role.setCellValueFactory(new PropertyValueFactory<settingUser, String>("id_role"));
        //waktu_update.setCellValueFactory(new PropertyValueFactory<settingUser, LocalDateTime>("waktu_update"));

        //untuk edit data kode antrian langsung di table
//        kode_antrian.setCellFactory(TextFieldTableCell.forTableColumn());
//        kode_antrian.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<settingAntrian,String>>() {
//            @Override
//            public void handle(TableColumn.CellEditEvent<settingAntrian, String> cellEditEvent) {
//                settingAntrian editedSettingAtrian = cellEditEvent.getRowValue();
//                String updateQuery = "UPDATE tr_antrian SET kode_antrian = ?, waktu_update = NOW() WHERE id_antrian = ?";
//
//                try(PreparedStatement preparedStatement = connection.connection().prepareStatement(updateQuery)) {
//                    preparedStatement.setString(1,cellEditEvent.getNewValue());
//                    preparedStatement.setString(2, editedSettingAtrian.getId_antrian());
//                    int rowsAffected = preparedStatement.executeUpdate();
//                    if(rowsAffected>0){
//                        System.out.println("Berhasil update dengan rows terupdate : " + rowsAffected);
//                    }else{
//                        System.out.println("Gagal update database");
//                    }
//                    settingAntrians.clear();
//                    loadData();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//
//            }
//        });

//        //untuk edit data uraian antrian langsung di table
//        uraian_antrian.setCellFactory(TextFieldTableCell.forTableColumn());
//        uraian_antrian.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<settingAntrian, String>>() {
//            @Override
//            public void handle(TableColumn.CellEditEvent<settingAntrian,String> cellEditEvent) {
//                settingAntrian editedSettingAntrian = cellEditEvent.getRowValue();
//                String updateQuery = "UPDATE tr_antrian SET uraian_antrian = ?, waktu_update = NOW() WHERE id_antrian = ?";
//                try(PreparedStatement preparedStatement = connection.connection().prepareStatement(updateQuery)) {
//                    preparedStatement.setString(1,cellEditEvent.getNewValue());
//                    preparedStatement.setString(2, editedSettingAntrian.getId_antrian());
//                    int rowsAffected = preparedStatement.executeUpdate();
//                    if(rowsAffected>0){
//                        System.out.println("Berhasil update dengan rows terupdate : " + rowsAffected);
//                    }else{
//                        System.out.println("Gagal update database");
//                    }
//                    settingAntrians.clear();
//                    loadData();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });


        loadData();
    }

    private void loadData() {
        tableView.setItems(settingUsers);

        try (Statement statement = connection.connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                String id_user = resultSet.getString("ID_USER");
                String user_name = resultSet.getString("USER_NAME");
                String password = resultSet.getString("PASSWORD");
                String nama = resultSet.getString("NAMA");
                String id_role = resultSet.getString("nama_role");
                LocalDateTime waktu_update = resultSet.getTimestamp("WAKTU_UPDATE").toLocalDateTime();
                settingUsers.add(new settingUser(id_user, user_name, password, nama, id_role, waktu_update));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void tambahPane() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainApp.class.getResource("tambah-user.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Tambah Data");
        stage.setScene(scene);
        stage.show();
        stage.setOnHidden(event -> {
            // Perbarui data di TableView utama
            settingUsers.clear();
            loadData();
        });
    }

    public void editPane(ActionEvent actionEvent) throws IOException {
        settingUser settingUser = tableView.getSelectionModel().getSelectedItem();
        System.out.println(settingUser.getId_role());
        if (settingUser != null) {
            FXMLLoader fxmlLoader = new FXMLLoader(mainApp.class.getResource("reset-password.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Edit Data");
            resetPasswordController resetPasswordController = fxmlLoader.getController();
            resetPasswordController.initData(settingUser);
            stage.setScene(scene);
            stage.show();
            stage.setOnHidden(event -> {
                // Perbarui data di TableView utama
                settingUsers.clear();
                loadData();
            });
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Peringatan");
            alert.setHeaderText(null);
            alert.setContentText("Pilih item untuk diedit.");
            alert.showAndWait();

        }

    }

    @FXML
    private void hapusData() {
        settingUser settingUser = tableView.getSelectionModel().getSelectedItem();
        if (settingUser != null) {
            String hapusSQL = "DELETE FROM `td_user` WHERE `td_user`.`id_user` = ?";
            try {
                PreparedStatement preparedStatement = connection.connection.prepareStatement(hapusSQL);
                preparedStatement.setString(1, settingUser.getId_user());
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Hapus Data !");
                alert.setHeaderText(null);
                alert.setContentText("Apakah anda yakin akan menghapus data ?");
                Optional<ButtonType> confirm = alert.showAndWait();
                if (confirm.isPresent() && confirm.get().equals(ButtonType.OK)) {
                    preparedStatement.execute();
                    settingUsers.clear();
                    loadData();
                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
