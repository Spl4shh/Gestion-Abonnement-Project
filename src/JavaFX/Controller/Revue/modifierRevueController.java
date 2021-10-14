package JavaFX.Controller.Revue;

import JavaFX.Application;
import dao.DAOFactory;
import dao.PeriodiciteDAO;
import dao.Persistance;
import dao.RevueDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import metier.Periodicite;
import metier.Revue;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class modifierRevueController implements Initializable
{
    Revue revueAModifier;
    DAOFactory dao = DAOFactory.getDAOFactory(Persistance.ListeMemoire);
    RevueDAO revueDAO = dao.getRevueDAO();
    PeriodiciteDAO periodiciteDAO = dao.getPeriodiciteDAO();

    @FXML
    private Button annulerBouton;

    @FXML
    private TextField descriptionArea;

    @FXML
    private Label labelId;

    @FXML
    private Label affichage;

    @FXML
    private Button modifierBouton;

    @FXML
    private ComboBox<Periodicite> periodiciteChoiceBox;

    @FXML
    private TextField tarifField;

    @FXML
    private TextField titreField;

    @FXML
    void boutonAnnulerClick(ActionEvent event) throws IOException {
        returnToMenu();
    }

    @FXML
    void boutonModifierClick(ActionEvent event) throws IOException
    {
        String messageErreur = "";

        affichage.setText("");

        Revue revue = new Revue(0);
        //Try Titre
        try
        {
            revue.setTitre(titreField.getText());
        }
        catch(IllegalArgumentException e)
        {
            messageErreur = messageErreur + e.getMessage() + "\n";
        }

        //Try Description
        try
        {
            revue.setDescription(descriptionArea.getText());
        }
        catch(IllegalArgumentException e)
        {
            messageErreur = messageErreur + e.getMessage() + "\n";
        }

        //Try tarif
        try
        {
            revue.setTarifNumero(Double.parseDouble(tarifField.getText()));
        }
        catch(NumberFormatException e)
        {
            messageErreur = messageErreur + "Tarif incorrect" + "\n";
        }
        catch(IllegalArgumentException e)
        {
            messageErreur = messageErreur + e.getMessage() + "\n";
        }


        //Try Periodicite
        try
        {
            revue.setIdPeriodicite(periodiciteChoiceBox.getValue());
        }
        catch(IllegalArgumentException e)
        {
            messageErreur = messageErreur + e.getMessage() + "\n";
        }

        if (messageErreur.equals(""))
        {
            revue.setId(revueAModifier.getId());
            /*HERE :
                Code pour ajouter la revue a la DAO souhaité
             */

            affichage.setText(revue.toString());
            affichage.setTextFill(Color.BLACK);
            returnToMenu();
        }
        else
        {
            affichage.setText(messageErreur);
            affichage.setTextFill(Color.RED);
        }

        returnToMenu();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        //Initialisation de la ChoiceBox
        try
        {
            this.periodiciteChoiceBox.setItems(FXCollections.observableArrayList(periodiciteDAO.findAll()));
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        //Recuperation de la Revue a modifier
        revueAModifier = receiveData();

        //Application des champs
        labelId.setText(String.valueOf(revueAModifier.getId()));
        titreField.setText(revueAModifier.getTitre());
        descriptionArea.setText(revueAModifier.getDescription());
        tarifField.setText(String.valueOf(revueAModifier.getTarifNumero()));
        try {
            periodiciteChoiceBox.setValue(periodiciteDAO.getById(revueAModifier.getIdPeriodicite()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Revue receiveData()
    {
        RevueHolder revueHolder = RevueHolder.getInstance();
        return revueHolder.getRevue();
    }

    public void returnToMenu() throws IOException
    {
        //Charger la page que l'on veux afficher
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Vue/Revue/menuGeneralRevue.fxml"));
        //Creer une Scene contenant cette page
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        //Recuperer la Stage de l'ancienne page
        Stage stage = (Stage) titreField.getScene().getWindow();
        //Afficher la nouvelle Scene dans l'ancienne Stage
        stage.setScene(scene);
    }
}
