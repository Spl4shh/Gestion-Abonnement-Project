module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx to javafx.fxml;
    exports com.example.javafx;
    exports com.example.javafx.Controller.Revue;
    opens com.example.javafx.Controller.Revue to javafx.fxml;
}