package JavaFX.Controller.DAO;

import JavaFX.Controller.Revue.RevueHolder;
import dao.ClientDAO;
import dao.Persistance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class choixTable implements Initializable
{

    @FXML
    private Button BoutonClient;

    @FXML
    private Button boutonAbonnement;

    @FXML
    private Button boutonPeriodicite;

    @FXML
    private Button boutonRevue;

    @FXML
    void boutonAbonnementClick(ActionEvent event)
    {

    }

    @FXML
    void boutonClientClick(ActionEvent event)
    {

    }

    @FXML
    void boutonPeriodiciteClick(ActionEvent event)
    {

    }

    @FXML
    void boutonRevueClick(ActionEvent event)
    {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        //Test, a supprimer
        DAOHolder daoHolder = DAOHolder.getInstance();
        daoHolder.setDaoFactory(Persistance.ListeMemoire);
        daoHolder.setDao("Client");

        ClientDAO clientDAO = (ClientDAO) daoHolder.getDao();

        System.out.println(clientDAO.getClass().getName());
    }
}
