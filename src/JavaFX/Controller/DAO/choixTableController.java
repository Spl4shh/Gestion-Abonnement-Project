package JavaFX.Controller.DAO;

import JavaFX.Controller.Revue.RevueHolder;
import dao.ClientDAO;
import dao.Persistance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class choixTableController implements Initializable
{
    DAOHolder daoHolder = DAOHolder.getInstance();

    @FXML
    private Button BoutonClient;

    @FXML
    private Button boutonAbonnement;

    @FXML
    private Button boutonPeriodicite;

    @FXML
    private Button boutonRevue;

    @FXML
    private ChoiceBox<Persistance> choiceBoxPersistance;

    @FXML
    void boutonAbonnementClick(ActionEvent event)
    {
        setFactory();
        daoHolder.setDao("Abonnement");
    }

    @FXML
    void boutonClientClick(ActionEvent event)
    {
        setFactory();
        daoHolder.setDao("Client");
    }

    @FXML
    void boutonPeriodiciteClick(ActionEvent event)
    {
        setFactory();
        daoHolder.setDao("Periodicite");
    }

    @FXML
    void boutonRevueClick(ActionEvent event)
    {
        setFactory();
        daoHolder.setDao("Revue");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        for (Persistance persistance : Persistance.values())
        {
            choiceBoxPersistance.getItems().add(persistance);
        }
        choiceBoxPersistance.setValue(Persistance.values()[0]);
    }

    public void setFactory()
    {
        DAOHolder daoHolder = DAOHolder.getInstance();
        daoHolder.setDaoFactory(Persistance.ListeMemoire);
    }
}
