package JavaFX.Controller.Periodicite;

import JavaFX.Controller.Client.ClientHolder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import metier.Client;
import metier.Periodicite;

import java.net.URL;
import java.util.ResourceBundle;

public class AfficherPeriodiciteController implements Initializable
{

    @FXML
    private Button boutonRetour;

    @FXML
    private Label labelId;

    @FXML
    private Label labelLibelle;

    @FXML
    void boutonRetourClick(ActionEvent event)
    {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    private Periodicite receiveData()
    {
        PeriodiciteHolder periodiciteHolder = PeriodiciteHolder.getInstance();

        return periodiciteHolder.getPeriodicite();
    }
}
