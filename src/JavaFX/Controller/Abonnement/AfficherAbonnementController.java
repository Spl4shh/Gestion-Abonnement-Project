package JavaFX.Controller.Abonnement;

import JavaFX.Application;
import JavaFX.Controller.DAO.DAOHolder;
import JavaFX.Controller.Revue.RevueHolder;
import dao.PeriodiciteDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import metier.Revue;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AfficherAbonnementController implements Initializable
{
    Revue revueAAfficher;


    @FXML
    private Label affichage;

    @FXML
    private Label labelId;

    @FXML
    private Button boutonRetour;

    @FXML
    private Label labelDateDebut;

    @FXML
    private Label labelDateFin;

    @FXML
    private Label labelIdClient;

    @FXML
    private Label labelIdRevue;

    @FXML
    void boutonRetourClick(ActionEvent event) throws IOException
    {
        //Charger la page que l'on veux afficher
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Vue/Revue/menuGeneralRevue.fxml"));
        //Creer une Scene contenant cette page
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        //Recuperer la Stage de l'ancienne page
        Stage stage = (Stage) labelId.getScene().getWindow();
        //Afficher la nouvelle Scene dans l'ancienne Stage
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        revueAAfficher = receiveData();

        labelId.setText(String.valueOf(revueAAfficher.getId()));
        labelTitre.setText(revueAAfficher.getTitre());
        labelDescription.setText(revueAAfficher.getDescription());
        labelTarif.setText(String.valueOf(revueAAfficher.getTarifNumero()));
        labelIdPeriodicite.setText(String.valueOf(revueAAfficher.getIdPeriodicite()));
    }

    private Revue receiveData()
    {
        RevueHolder revueHolder = RevueHolder.getInstance();

        return revueHolder.getRevue();
    }
}
