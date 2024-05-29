module com.example.antriannew {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires layout;
    requires kernel;
    requires java.desktop;
    requires io;


    opens com.example.antriannew to javafx.fxml;
    exports com.example.antriannew;
    exports com.example.antriannew.models;
    opens com.example.antriannew.models to javafx.fxml;
    exports com.example.antriannew.controller;
    opens com.example.antriannew.controller to javafx.fxml;
}