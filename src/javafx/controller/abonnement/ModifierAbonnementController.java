package javafx.controller.abonnement;

import javafx.Application;
import javafx.controller.dao.DAOHolder;
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
import metier.Revue;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class ModifierAbonnementController implements Initializable
{
    Abonnement abonnementEnCours;
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

        Abonnement abonnementToUpdate = new Abonnement(0);

        //Try set dateDebut
        try
        {
            LocalDate dateDebut = datePickerDebut.getValue();
            abonnementToUpdate.setDateDebut(dateDebut);
        }
        catch(IllegalArgumentException e)
        {
            messageErreur = messageErreur + e.getMessage() + "\n";
        }

        //Try set dateFin
        try
        {
            LocalDate dateFin = datePickerFin.getValue();
            abonnementToUpdate.setDateFin(dateFin);
        }
        catch(IllegalArgumentException e)
        {
            messageErreur = messageErreur + e.getMessage() + "\n";
        }

        //Try set ID Client
        try
        {
            Client client = clientChoiceBox.getValue();
            abonnementToUpdate.setIdClient(client);

        }
        catch(IllegalArgumentException e)
        {
            messageErreur = messageErreur + e.getMessage() + "\n";
        }

        //Try set ID Revue
        try
        {
            Revue revue = revueChoiceBox.getValue();
            abonnementToUpdate.setIdRevue(revue);
        }
        catch(IllegalArgumentException e)
        {
            messageErreur = messageErreur + e.getMessage() + "\n";
        }


        if (messageErreur.equals(""))
        {
            List<Abonnement> listAbonnement = abonnementDAO.findAll();

            if(!isDoublon(listAbonnement, abonnementToUpdate))
            {
                abonnementDAO.update(abonnementToUpdate);
                returnToMenu();
            }
            else
            {
                Alert info = new Alert(Alert.AlertType.INFORMATION, "Cet abonnement existe deja");
                info.showAndWait();
            }
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
        abonnementEnCours = receiveData();


        //Application des champs
        labelId.setText(String.valueOf(abonnementEnCours.getId()));

        datePickerDebut.setValue(abonnementEnCours.getDateDebut());
        datePickerFin.setValue(abonnementEnCours.getDateFin());

        try {
            clientChoiceBox.setValue(clientDAO.getById(abonnementEnCours.getIdClient()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            revueChoiceBox.setValue(revueDAO.getById(abonnementEnCours.getIdRevue()));
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
        Scene actualScene = affichage.getScene();

        //Charger la page que l'on veux afficher
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Vue/Abonnement/menuGeneralAbonnement.fxml"));
        //Creer une Scene contenant cette page
        Scene scene = new Scene(fxmlLoader.load(), actualScene.getWidth(), actualScene.getHeight());
        //Recuperer la Stage de l'ancienne page
        Stage stage = (Stage) actualScene.getWindow();
        stage.setScene(scene);
        stage.setTitle("Menu Abonnement");
    }

    private boolean isDoublon(List<Abonnement> listItem, Abonnement itemToCheck)
    {
        Abonnement itemToCheckWNewId = itemToCheck;
        for (Abonnement item : listItem)
        {
            itemToCheckWNewId.setId(item.getId());
            if (itemToCheckWNewId.equals(item))
            {
                return true;
            }
        }
        return false;
    }
}
