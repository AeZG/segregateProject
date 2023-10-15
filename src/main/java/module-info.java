module com.example.segregateproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.segregateproject to javafx.fxml;
    exports com.example.segregateproject;
}