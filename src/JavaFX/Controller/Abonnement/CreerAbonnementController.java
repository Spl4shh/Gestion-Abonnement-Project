package JavaFX.Controller.Abonnement;

import JavaFX.Application;
import dao.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import metier.Abonnement;
import metier.Client;
import metier.Periodicite;
import metier.Revue;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CreerAbonnementController implements Initializable
{
    DAOFactory dao = DAOFactory.getDAOFactory(Persistance.ListeMemoire);
    RevueDAO revueDAO = dao.getRevueDAO();
    ClientDAO clientDAO = dao.getClientDAO();

    @FXML
    private Label affichage;

    @FXML
    private Button boutonAnnuler;

    @FXML
    private Button creerBouton;

    @FXML
    private DatePicker datePickerDebut;

    @FXML
    private DatePicker datePickerFin;

    @FXML
    private ChoiceBox<Client> clientChoiceBox;

    @FXML
    private ChoiceBox<Revue> revueChoiceBox;

    @FXML
    void boutonAnnulerClick(ActionEvent event) throws IOException
    {
        returnToMenu();
    }

    @FXML
    void boutonCreerAbonnementClick(ActionEvent event) throws IOException {
        String messageErreur = "";
        affichage.setText("");

        Abonnement abonnement = new Abonnement(0);

        //Try set dateDebut
        try
        {
            LocalDate dateDebut = datePickerDebut.getValue();
            abonnement.setDateDebut(dateDebut);
        }
        catch(IllegalArgumentException e)
        {
            messageErreur = messageErreur + e.getMessage() + "\n";
        }

        try
        {
            LocalDate dateFin = datePickerFin.getValue();
            abonnement.setDateFin(dateFin);
        }
        catch(IllegalArgumentException e)
        {
            messageErreur = messageErreur + e.getMessage() + "\n";
        }

        try
        {
            Client client = clientChoiceBox.getValue();
            abonnement.setIdClient(client);

        }
        catch(IllegalArgumentException e)
        {
            messageErreur = messageErreur + e.getMessage() + "\n";
        }

        try
        {
            Revue revue = revueChoiceBox.getValue();
            abonnement.setIdRevue(revue);
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

            affichage.setText("");
            affichage.setTextFill(Color.BLACK);
            returnToMenu();
        }
        else
        {
            affichage.setText(messageErreur);
            affichage.setTextFill(Color.RED);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        //Init ChoiceBox
        //Revue
        try
        {
            this.revueChoiceBox.setItems(FXCollections.observableArrayList(revueDAO.findAll()));
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        //Client
        try
        {
            this.clientChoiceBox.setItems(FXCollections.observableArrayList(clientDAO.findAll()));
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void returnToMenu() throws IOException
    {
        //Charger la page que l'on veux afficher
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Vue/Abonnement/menuGeneralAbonnement.fxml"));
        //Creer une Scene contenant cette page
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        //Recuperer la Stage de l'ancienne page
        Stage stage = (Stage) clientChoiceBox.getScene().getWindow();
        //Afficher la nouvelle Scene dans l'ancienne Stage
        stage.setScene(scene);
    }
}