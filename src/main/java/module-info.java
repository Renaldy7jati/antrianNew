module com.example.antriannew {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.antriannew to javafx.fxml;
    exports com.example.antriannew;
}