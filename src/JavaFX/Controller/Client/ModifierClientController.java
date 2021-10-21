package JavaFX.Controller.Client;

import JavaFX.Application;
import JavaFX.Controller.DAO.DAOHolder;
import dao.ClientDAO;
import dao.DAOFactory;
import dao.Persistance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import metier.Adresse;
import metier.Client;
import metier.ProcessAdress;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ModifierClientController implements Initializable
{
    ClientDAO clientDAO = (ClientDAO) DAOHolder.getInstance().getDaoFactory().getClientDAO();
    Client clientAModifier;

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
    void boutonAnnulerClick(ActionEvent event) throws IOException
    {
        returnToMenu();
    }

    @FXML
    void boutonModifierClick(ActionEvent event) throws IOException, SQLException {
        String messageErreur = "";
        affichageLabel.setText("");

        Client client = new Client(0);

        //Try set nom
        try
        {
            client.setNom(nomField.getText());
        }
        catch(IllegalArgumentException e)
        {
            messageErreur = messageErreur + e.getMessage() + "\n";
        }

        //Try set prenom
        try
        {
            client.setPrenom(prenomField.getText());
        }
        catch(IllegalArgumentException e)
        {
            messageErreur = messageErreur + e.getMessage() + "\n";
        }

        //Try set Adresse
        Adresse adresse = new Adresse("", "", "", "", "");

        //Try No Rue
        try
        {
            adresse.setNoRue(noRueField.getText());
        }
        catch(IllegalArgumentException e)
        {
            messageErreur = messageErreur + e.getMessage() + "\n";
        }

        //Try Voie
        try
        {
            adresse.setVoie(voieField.getText());
        }
        catch(IllegalArgumentException e)
        {
            messageErreur = messageErreur + e.getMessage() + "\n";
        }

        //Try Code Postal
        try
        {
            adresse.setCodePostal(codePostalField.getText());
        }
        catch(IllegalArgumentException e)
        {
            messageErreur = messageErreur + e.getMessage() + "\n";
        }

        //Try Ville
        try
        {
            adresse.setVille(villeField.getText());
        }
        catch(IllegalArgumentException e)
        {
            messageErreur = messageErreur + e.getMessage() + "\n";
        }

        //Try Pays
        try
        {
            adresse.setPays(paysField.getText());
        }
        catch(IllegalArgumentException e)
        {
            messageErreur = messageErreur + e.getMessage() + "\n";
        }



        if (messageErreur.equals(""))
        {
            /*
                HERE :
                Code pour ajouter la revue a la DAO souhaité
             */

            client.setAdresse(ProcessAdress.normalize(adresse));
            client.setId(clientAModifier.getId());

            clientDAO.update(client);
            returnToMenu();
        }
        else
        {
            affichageLabel.setText(messageErreur);
            affichageLabel.setTextFill(Color.RED);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        clientAModifier = receiveData();

        labelId.setText(String.valueOf(clientAModifier.getId()));
        nomField.setText(String.valueOf(clientAModifier.getNom()));
        prenomField.setText(String.valueOf(clientAModifier.getPrenom()));
        noRueField.setText(String.valueOf(clientAModifier.getAdresse().getNoRue()));
        voieField.setText(String.valueOf(clientAModifier.getAdresse().getVoie()));
        codePostalField.setText(String.valueOf(clientAModifier.getAdresse().getCodePostal()));
        villeField.setText(String.valueOf(clientAModifier.getAdresse().getVille()));
        paysField.setText(String.valueOf(clientAModifier.getAdresse().getPays()));
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
        //stage.setTitle("Modification d'un Client");
    }

    private Client receiveData()
    {
        ClientHolder clientHolder = ClientHolder.getInstance();
        return clientHolder.getClient();
    }
}
