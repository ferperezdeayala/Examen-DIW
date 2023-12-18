module com.example.examendiw {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.examendiw to javafx.fxml;
    exports com.example.examendiw;
}