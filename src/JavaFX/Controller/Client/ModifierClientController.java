package JavaFX.Controller.Client;

import JavaFX.Application;
import dao.ClientDAO;
import dao.DAOFactory;
import dao.Persistance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import metier.Client;

import java.io.IOException;

public class ModifierClientController
{
    DAOFactory dao = DAOFactory.getDAOFactory(Persistance.ListeMemoire);
    ClientDAO clientDAO = dao.getClientDAO();

    @FXML
    private Label affichageLabel;

    @FXML
    private Button boutonAnnuler;

    @FXML
    private Button boutonModifier;

    @FXML
    private TextField codePostalField;

    @FXML
    private Label labelId;

    @FXML
    private TextField noRueField;

    @FXML
    private TextField nomField;

    @FXML
    private TextField paysField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField villeField;

    @FXML
    private TextField voieField;

    @FXML
    void boutonAnnulerClick(ActionEvent event) {

    }

    @FXML
    void boutonModifierClientClick(ActionEvent event) {

    }

    public void returnToMenu() throws IOException
    {
        //Charger la page que l'on veux afficher
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Vue/Client/menuGeneralClient.fxml"));
        //Creer une Scene contenant cette page
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        //Recuperer la Stage de l'ancienne page
        Stage stage = (Stage) affichageLabel.getScene().getWindow();
        //Afficher la nouvelle Scene dans l'ancienne Stage
        stage.setScene(scene);
    }

    private Client receiveData()
    {
        ClientHolder clientHolder = ClientHolder.getInstance();
        return clientHolder.getClient();
    }
}
