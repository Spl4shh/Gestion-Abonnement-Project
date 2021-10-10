module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires junit;


    opens com.javafx to javafx.fxml;
    exports com.javafx;
    exports com.javafx.Controller.Revue;
    opens com.javafx.Controller.Revue to javafx.fxml;
}