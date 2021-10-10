module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.javafx to javafx.fxml;
    exports com.javafx;
    exports com.javafx.Controller.Revue;
    opens com.javafx.Controller.Revue to javafx.fxml;
}