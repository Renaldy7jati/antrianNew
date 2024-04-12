package com.example.antriannew.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class connection {
    public Connection connection;

    private final String connectionURL = "jdbc:mysql://localhost:3306/antriannew";
    private final String user = "user001";
    private final String pass = "Makinbaik1!";

    public connection() {
        try {
            this.connection = DriverManager.getConnection(connectionURL,user,pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public Connection connection(){
//        try{
//            Connection connection = DriverManager.getConnection(connectionURL,user,pass);
//            return connection;
//        } catch (SQLException e) {
//            throw new RuntimeException("Koneksi gagal, silahkan periksa koneksi ke data base "  + e);
//        }
//
//    }


}
