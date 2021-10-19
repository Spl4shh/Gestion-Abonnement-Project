package JavaFX.Controller.DAO;

import JavaFX.Application;
import dao.Persistance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class choixTableController implements Initializable
{
    DAOHolder daoHolder = DAOHolder.getInstance();

    @FXML
    private Button boutonAbonnement;

    @FXML
    private Button boutonClient;

    @FXML
    private Button boutonPeriodicite;

    @FXML
    private Button boutonRevue;

    @FXML
    private ChoiceBox<Persistance> choiceBoxPersistance;

    @FXML
    void boutonAbonnementClick(ActionEvent event) throws IOException
    {
        setFactory();
        setScene("Abonnement");
    }

    @FXML
    void boutonClientClick(ActionEvent event) throws IOException
    {
        setFactory();
        setScene("Client");
    }

    @FXML
    void boutonPeriodiciteClick(ActionEvent event) throws IOException
    {
        setFactory();
        setScene("Periodicite");
    }

    @FXML
    void boutonRevueClick(ActionEvent event) throws IOException
    {
        setFactory();
        setScene("Revue");
    }

    public void setFactory()
    {
        DAOHolder daoHolder = DAOHolder.getInstance();
        daoHolder.setDaoFactory(choiceBoxPersistance.getValue());
    }

    public void setScene(String table) throws IOException
    {
        //Charger la page que l'on veux afficher
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Vue/"+table+"/menuGeneral"+table+".fxml"));
        //Creer une Scene contenant cette page
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        //Recuperer la Stage de l'ancienne page
        Stage stage = (Stage) choiceBoxPersistance.getScene().getWindow();
        //Afficher la nouvelle Scene dans l'ancienne Stage
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        for (Persistance persistance : Persistance.values())
        {
            choiceBoxPersistance.getItems().add(persistance);
        }
        choiceBoxPersistance.setValue(Persistance.values()[1]);
    }
}
