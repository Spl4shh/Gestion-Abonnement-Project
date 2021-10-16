package JavaFX.Controller.Abonnement;

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
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import metier.Periodicite;
import metier.Revue;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CreerAbonnementController implements Initializable
{
    DAOFactory dao = DAOFactory.getDAOFactory(Persistance.ListeMemoire);


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
    private ComboBox<?> idClientChoiceBox;

    @FXML
    private ComboBox<?> idRevueComboBox;

    @FXML
    void boutonAnnulerClick(ActionEvent event) {

    }

    @FXML
    void boutonCreerAbonnementClick(ActionEvent event) {

    }

    @FXML
    void boutonCreerRevueClick(ActionEvent event) throws IOException, SQLException {
        String messageErreur = "";

        affichage.setText("");


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

    @FXML
    void btnAnnulerClick(ActionEvent event) throws IOException
    {
        returnToMenu();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        //Init des choice box

    }

    public void returnToMenu() throws IOException
    {
        //Charger la page que l'on veux afficher
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Vue/Revue/menuGeneralRevue.fxml"));
        //Creer une Scene contenant cette page
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        //Recuperer la Stage de l'ancienne page
        Stage stage = (Stage) idClientChoiceBox.getScene().getWindow();
        //Afficher la nouvelle Scene dans l'ancienne Stage
        stage.setScene(scene);
    }
}