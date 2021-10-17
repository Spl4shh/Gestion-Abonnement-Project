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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import metier.Adresse;
import metier.Client;
import metier.ProcessAdress;

import java.io.IOException;
import java.sql.SQLException;

public class CreerClientController
{
    DAOFactory dao = DAOFactory.getDAOFactory(Persistance.ListeMemoire);
    ClientDAO clientDAO = dao.getClientDAO();

    @FXML
    private Label affichageLabel;

    @FXML
    private TextField codepostalField;

    @FXML
    private Button boutonCreer;

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
    void boutonCreerClientClick(ActionEvent event) throws SQLException, IOException
    {
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
            adresse.setCodePostal(codepostalField.getText());
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
            clientDAO.create(client);

            affichageLabel.setText("");
            affichageLabel.setTextFill(Color.BLACK);
            returnToMenu();
        }
        else
        {
            affichageLabel.setText(messageErreur);
            affichageLabel.setTextFill(Color.RED);
        }
    }

    @FXML
    void boutonAnnulerClick(ActionEvent event) throws IOException
    {
        returnToMenu();
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
}
