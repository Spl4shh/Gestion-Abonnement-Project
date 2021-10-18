package JavaFX.Controller.Abonnement;

import JavaFX.Application;
import JavaFX.Controller.DAO.DAOHolder;
import dao.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import metier.Abonnement;
import metier.Client;
import metier.Revue;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ModifierAbonnementController implements Initializable
{
    Abonnement abonnementAModifier;
    DAOFactory daoFactory = DAOHolder.getInstance().getDaoFactory();
    AbonnementDAO abonnementDAO = daoFactory.getAbonnementDAO();
    RevueDAO revueDAO = daoFactory.getRevueDAO();
    ClientDAO clientDAO = daoFactory.getClientDAO();

    @FXML
    private Label affichage;

    @FXML
    private Button annulerBouton;

    @FXML
    private DatePicker datePickerDebut;

    @FXML
    private DatePicker datePickerFin;

    @FXML
    private Label labelId;

    @FXML
    private Button modifierBouton;

    @FXML
    private ChoiceBox<Revue> revueChoiceBox;

    @FXML
    private ChoiceBox<Client> clientChoiceBox;

    @FXML
    void boutonModifierClick(ActionEvent event) throws IOException, SQLException
    {
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

        //Try set dateFin
        try
        {
            LocalDate dateFin = datePickerFin.getValue();
            abonnement.setDateFin(dateFin);
        }
        catch(IllegalArgumentException e)
        {
            messageErreur = messageErreur + e.getMessage() + "\n";
        }

        //Try set ID Client
        try
        {
            Client client = clientChoiceBox.getValue();
            abonnement.setIdClient(client);

        }
        catch(IllegalArgumentException e)
        {
            messageErreur = messageErreur + e.getMessage() + "\n";
        }

        //Try set ID Revue
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
            abonnement.setId(abonnementAModifier.getId());
            abonnementDAO.update(abonnement);

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

    @FXML
    void boutonAnnulerClick(ActionEvent event) throws IOException
    {
        returnToMenu();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        //Initialisation des ChoiceBox
        try
        {
            this.revueChoiceBox.setItems(FXCollections.observableArrayList(revueDAO.findAll()));
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        try
        {
            this.clientChoiceBox.setItems(FXCollections.observableArrayList(clientDAO.findAll()));
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        //Recuperation de la Revue a modifier
        abonnementAModifier = receiveData();


        //Application des champs
        labelId.setText(String.valueOf(abonnementAModifier.getId()));

        datePickerDebut.setValue(abonnementAModifier.getDateDebut());
        datePickerFin.setValue(abonnementAModifier.getDateFin());

        try {
            clientChoiceBox.setValue(clientDAO.getById(abonnementAModifier.getIdClient()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            revueChoiceBox.setValue(revueDAO.getById(abonnementAModifier.getIdRevue()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Abonnement receiveData()
    {
        AbonnementHolder abonnementHolder = AbonnementHolder.getInstance();
        return abonnementHolder.getAbonnement();
    }

    public void returnToMenu() throws IOException
    {
        //Charger la page que l'on veux afficher
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Vue/Abonnement/menuGeneralAbonnement.fxml"));
        //Creer une Scene contenant cette page
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        //Recuperer la Stage de l'ancienne page
        Stage stage = (Stage) this.labelId.getScene().getWindow();

        stage.setScene(scene);
    }
}
