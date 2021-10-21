package JavaFX.Controller.Client;

import JavaFX.Application;
import JavaFX.Controller.Abonnement.AbonnementHolder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import metier.Abonnement;
import metier.Client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AfficherClientController implements Initializable
{
    Client clientAAfficher;

    @FXML
    private Button boutonRetour;

    @FXML
    private Label labelCodePostal;

    @FXML
    private Label labelId;

    @FXML
    private Label labelNoRue;

    @FXML
    private Label labelNom;

    @FXML
    private Label labelPays;

    @FXML
    private Label labelPrenom;

    @FXML
    private Label labelVille;

    @FXML
    private Label labelVoie;

    @FXML
    void boutonRetourClick(ActionEvent event) throws IOException
    {
        //Charger la page que l'on veux afficher
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Vue/Client/menuGeneralClient.fxml"));
        //Creer une Scene contenant cette page
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        //Recuperer la Stage de l'ancienne page
        Stage stage = (Stage) labelId.getScene().getWindow();
        //Afficher la nouvelle Scene dans l'ancienne Stage
        stage.setScene(scene);
        stage.setTitle("Affichage d'un Client");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        clientAAfficher = receiveData();

        labelId.setText(String.valueOf(clientAAfficher.getId()));
        labelNom.setText(clientAAfficher.getNom());
        labelPrenom.setText(clientAAfficher.getPrenom());
        labelNoRue.setText(clientAAfficher.getAdresse().getNoRue());
        labelVoie.setText(clientAAfficher.getAdresse().getVoie());
        labelVille.setText(clientAAfficher.getAdresse().getVille());
        labelCodePostal.setText(clientAAfficher.getAdresse().getCodePostal());
        labelPays.setText(clientAAfficher.getAdresse().getPays());
    }

    private Client receiveData()
    {
        ClientHolder clientHolder = ClientHolder.getInstance();

        return clientHolder.getClient();
    }
}
