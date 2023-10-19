module com.example.filosos {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.filosos to javafx.fxml;
    exports com.example.filosos;
}