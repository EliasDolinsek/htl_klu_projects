module com.example.guidemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens com.example.guidemo to javafx.fxml;
    exports com.example.guidemo;
}