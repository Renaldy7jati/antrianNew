package com.example.antriannew.controller;

import com.example.antriannew.models.settingAntrian;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ResourceBundle;



public class settingAntrianController extends Application implements Initializable {
    public static void main(String[] args) {
        Application.launch(args);
    }

    com.example.antriannew.controller.connection connection = new connection();
    String query = "SELECT * FROM tr_antrian";

    @FXML
    Button btnTambah = new Button();

    @FXML
    TableView<settingAntrian> tableView = new TableView<>();

    private final ObservableList<settingAntrian> settingAntrians = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tableView.setMinWidth(tableView.getMinWidth());

        TableColumn id_antrian = new TableColumn<>("ID Antrian");
        TableColumn kode_antrian = new TableColumn<>("Kode Antrian");
        TableColumn uraian_antrian = new TableColumn<>("Uraian Antrian");
        TableColumn waktu_update = new TableColumn<>("Waktu Update");

        tableView.getColumns().addAll(id_antrian,kode_antrian,uraian_antrian,waktu_update);

        id_antrian.setCellValueFactory(new PropertyValueFactory<settingAntrian,String>("id_antrian"));
        kode_antrian.setCellValueFactory(new PropertyValueFactory<settingAntrian,String>("kode_antrian"));
        uraian_antrian.setCellValueFactory(new PropertyValueFactory<settingAntrian,String>("uraian_antrian"));
        waktu_update.setCellValueFactory(new PropertyValueFactory<settingAntrian, LocalDateTime>("waktu_update"));




//        id_antrian.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<settingAntrian, String>>() {
//            @Override
//            public void handle(TableColumn.CellEditEvent<settingAntrian, String> cellEditEvent) {
//                ((settingAntrian) cellEditEvent.getTableView().getItems().get(
//                        cellEditEvent.getTablePosition().getRow())
//                ).setId_antrian(cellEditEvent.getNewValue());
//            }
//        });


        //untuk edit data kode antrian langsung di table
        kode_antrian.setCellFactory(TextFieldTableCell.forTableColumn());
        kode_antrian.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<settingAntrian,String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<settingAntrian, String> cellEditEvent) {
                settingAntrian editedSettingAtrian = cellEditEvent.getRowValue();
                String updateQuery = "UPDATE tr_antrian SET kode_antrian = ?, waktu_update = NOW() WHERE id_antrian = ?";

                try(PreparedStatement preparedStatement = connection.connection().prepareStatement(updateQuery)) {
                    preparedStatement.setString(1,cellEditEvent.getNewValue());
                    preparedStatement.setString(2, editedSettingAtrian.getId_antrian());
                    int rowsAffected = preparedStatement.executeUpdate();
                    if(rowsAffected>0){
                        System.out.println("Berhasil update dengan rows terupdate : " + rowsAffected);
                    }else{
                        System.out.println("Gagal update database");
                    }
                    settingAntrians.clear();
                    loadData();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        //untuk edit data uraian antrian langsung di table
        uraian_antrian.setCellFactory(TextFieldTableCell.forTableColumn());
        uraian_antrian.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<settingAntrian, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<settingAntrian,String> cellEditEvent) {
                settingAntrian editedSettingAntrian = cellEditEvent.getRowValue();
                String updateQuery = "UPDATE tr_antrian SET uraian_antrian = ?, waktu_update = NOW() WHERE id_antrian = ?";
                try(PreparedStatement preparedStatement = connection.connection().prepareStatement(updateQuery)) {
                    preparedStatement.setString(1,cellEditEvent.getNewValue());
                    preparedStatement.setString(2, editedSettingAntrian.getId_antrian());
                    int rowsAffected = preparedStatement.executeUpdate();
                    if(rowsAffected>0){
                        System.out.println("Berhasil update dengan rows terupdate : " + rowsAffected);
                    }else{
                        System.out.println("Gagal update database");
                    }
                    settingAntrians.clear();
                    loadData();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        loadData();
    }

    public void editPane(ActionEvent actionEvent) throws IOException{
        settingAntrian settingAntrian = tableView.getSelectionModel().getSelectedItem();
        if(settingAntrian!=null){
            FXMLLoader fxmlLoader = new FXMLLoader(settingAntrianController.class.getResource("edit-antrian.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Edit Data");
            editDataController editDataController = fxmlLoader.getController();
            editDataController.initData(settingAntrian);
            stage.setScene(scene);
            stage.show();
            stage.setOnHidden(event -> {
                // Perbarui data di TableView utama
                settingAntrians.clear();
                loadData();
            });
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Peringatan");
            alert.setHeaderText(null);
            alert.setContentText("Pilih item untuk diedit.");
            alert.showAndWait();

        }

    }


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("setting-antrian.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Setting Antrian");
        stage.setScene(scene);
        stage.show();
    }

    public void tambahPane() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(settingAntrianController.class.getResource("tambah-antrian.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Tambah Data");
        stage.setScene(scene);
        stage.show();
        stage.setOnHidden(event -> {
            // Perbarui data di TableView utama
            settingAntrians.clear();
            loadData();
        });
    }



    private void loadData(){
        tableView.setItems(settingAntrians);

        try (Statement statement = connection.connection().createStatement();
             ResultSet resultSet = statement.executeQuery(query)){
            while (resultSet.next()){
                String idAntrian = resultSet.getString("id_antrian");
                String kodeAntrian = resultSet.getString("kode_antrian");
                String uraianAntrian = resultSet.getString("uraian_antrian");
                LocalDateTime waktuUpdate = resultSet.getTimestamp("waktu_update").toLocalDateTime();
                settingAntrians.add(new settingAntrian(idAntrian,kodeAntrian,uraianAntrian,waktuUpdate));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

