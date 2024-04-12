package com.example.antriannew;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class connection {
    public Connection connection(){
        String connectionURL = "jdbc:mysql://localhost:3306/antriannew";
        String user = "user001";
        String pass = "Makinbaik1!";
        try{
            Connection connection = DriverManager.getConnection(connectionURL,user,pass);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Koneksi gagal, silahkan periksa koneksi ke data base "  + e);
        }

    }


}
