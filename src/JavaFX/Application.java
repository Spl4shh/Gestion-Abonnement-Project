package JavaFX;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Application extends javafx.application.Application
{

    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Vue/Periodicite/menuGeneralPeriodicite.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        stage.setTitle("Gestion de Revue");
        stage.setScene(scene);
        stage.show();

        /*FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Vue/DAO/choixTable.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        stage.setTitle("Gestion de Revue");
        stage.setScene(scene);
        stage.show();*/
    }

    public static void main(String[] args)
    {
        launch();
    }
}