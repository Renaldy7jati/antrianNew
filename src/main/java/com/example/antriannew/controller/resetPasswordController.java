package com.example.antriannew.controller;

import com.example.antriannew.models.connection;
import com.example.antriannew.models.settingUser;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class resetPasswordController implements Initializable {

    @FXML
    Label username;
    @FXML
    PasswordField password;
    @FXML
    PasswordField repassword;
    @FXML
    Button btnReset;
    private com.example.antriannew.models.settingUser settingUser;

    com.example.antriannew.models.connection connection = new connection();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    public void initData(settingUser settingUser) {
        this.settingUser = settingUser;
        username.setText(settingUser.getUser_name());
    }


    public void resetPass(){
        String passwordText = password.getText();
        String repasswordText = repassword.getText();
        if(passwordText.equals(repasswordText)){
            String updateSQL = "UPDATE `td_user` SET `PASSWORD` = ? WHERE `td_user`.`user_name` = ?";
            try {
                PreparedStatement preparedStatement = connection.connection.prepareStatement(updateSQL);
                preparedStatement.setString(1,password.getText());
                preparedStatement.setString(2,username.getText());
                int resetPassword = preparedStatement.executeUpdate();
                if (resetPassword > 0) {
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
                Stage stage = (Stage) btnReset.getScene().getWindow();
                stage.close();
            } catch (SQLException e) {Alert alertError = new Alert(Alert.AlertType.ERROR);
                alertError.setTitle("Gagal!");
                alertError.setContentText("Data gagal diedit, detail :" + e.getMessage());
                alertError.setHeaderText(null);
                alertError.showAndWait();
                throw new RuntimeException(e);
            }
        }else{
            System.out.println(password.getText());
            System.out.println(repassword.getText());
            Alert alertError = new Alert(Alert.AlertType.ERROR);
            alertError.setTitle("Gagal !");
            alertError.setContentText("Password tidak sama !");
            alertError.setHeaderText(null);
            alertError.showAndWait();
        }

    }


}
