module com.example.barberodormilon {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.barberodormilon to javafx.fxml;
    exports com.example.barberodormilon;
}