package JavaFX.Controller.Revue;

import JavaFX.Controller.DAO.DAOHolder;
import dao.PeriodiciteDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import metier.Revue;

import java.net.URL;
import java.util.ResourceBundle;

public class AfficherRevueController implements Initializable
{
    RevueHolder revueHolder;
    Revue revueAAfficher;
    DAOHolder daoHolder = DAOHolder.getInstance();
    PeriodiciteDAO periodiciteDAO = daoHolder.getDaoFactory().getPeriodiciteDAO();

    @FXML
    private Label labelDescription;

    @FXML
    private Label affichageLabel;

    @FXML
    private Button boutonRetour;

    @FXML
    private Label labelId;

    @FXML
    private Label labelIdPeriodicite;

    @FXML
    private Label labelTarif;

    @FXML
    private Label labelTitre;

    @FXML
    void boutonRetourClick(ActionEvent event)
    {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        revueHolder = RevueHolder.getInstance();
        revueAAfficher = revueHolder.getRevue();

        labelId.setText(String.valueOf(revueAAfficher.getId()));
        labelTitre.setText(revueAAfficher.getTitre());
        labelDescription.setText(revueAAfficher.getDescription());
        labelTarif.setText(String.valueOf(revueAAfficher.getTarifNumero()));
        labelIdPeriodicite.setText(String.valueOf(revueAAfficher.getIdPeriodicite()));
    }
}
