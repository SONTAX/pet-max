module com.example.petmax {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.petmax to javafx.fxml;
    exports com.example.petmax;
}