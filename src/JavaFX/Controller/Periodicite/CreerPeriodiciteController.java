package JavaFX.Controller.Periodicite;

import JavaFX.Application;
import dao.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import metier.Abonnement;
import metier.Periodicite;
import metier.Revue;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class CreerPeriodiciteController {

    DAOFactory dao = DAOFactory.getDAOFactory(Persistance.ListeMemoire);
    PeriodiciteDAO periodiciteDAO = dao.getPeriodiciteDAO();

    @FXML
    private Label affichage;

    @FXML
    private Button boutonAnnuler;

    @FXML
    private Button boutonCreer;

    @FXML
    private Label idLabel;

    @FXML
    private TextField libelleField;

    @FXML
    void boutonAnnuler(ActionEvent event) throws IOException {
        returnToMenu();
    }

    @FXML
    void boutonCreerPeriodicite(ActionEvent event) throws SQLException, IOException {
        String messageErreur = "";
        idLabel.setText("");

        Periodicite periodicite = new Periodicite(0);
        periodicite.setLibelle("");
        //Try Titre
        try
        {
            periodicite.setLibelle(libelleField.getText());
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
            periodiciteDAO.create(periodicite);

            affichage.setText(periodicite.toString());
            affichage.setTextFill(Color.BLACK);
            returnToMenu();
        }
        else
        {
            affichage.setText(messageErreur);
            affichage.setTextFill(Color.RED);
        }

    }

    public void returnToMenu() throws IOException
    {
        //Charger la page que l'on veux afficher
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Vue/Periodicite/menuGeneralPeriodicite.fxml"));
        //Creer une Scene contenant cette page
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        //Recuperer la Stage de l'ancienne page
        Stage stage = (Stage) affichage.getScene().getWindow();
        //Afficher la nouvelle Scene dans l'ancienne Stage
        stage.setScene(scene);
    }

}
