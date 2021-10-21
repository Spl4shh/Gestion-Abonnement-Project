package JavaFX.Controller.Periodicite;

import JavaFX.Application;
import JavaFX.Controller.DAO.DAOHolder;
import dao.DAOFactory;
import dao.PeriodiciteDAO;
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
import metier.Periodicite;

import java.io.IOException;
import java.sql.SQLException;

public class ModifierPeriodiciteController {

    Periodicite periodiciteAModifier;
    PeriodiciteDAO periodiciteDAO = (PeriodiciteDAO) DAOHolder.getInstance().getDaoFactory().getPeriodiciteDAO();


    @FXML
    private Label affichage;

    @FXML
    private Button annulerBouton;

    @FXML
    private Label idLabel;

    @FXML
    private TextField libelleField;

    @FXML
    private Button modifierBouton;

    @FXML
    void boutonAnnulerClick(ActionEvent event) throws IOException {
        returnToMenu();
    }

    @FXML
    void boutonModifierPeriodicite(ActionEvent event) throws SQLException, IOException {
        String messageErreur = "";

        affichage.setText("");

        Periodicite periodicite = new Periodicite(0);

        // On teste le libelle
        try {
            periodicite.setLibelle(libelleField.getText());
        } catch (Exception e) {
            messageErreur = messageErreur + e.getMessage() + "\n";
        }

        if (messageErreur.equals(""))
        {
            /*
                HERE :
                Code pour ajouter la revue a la DAO souhaité
             */
            periodicite.setId(periodiciteAModifier.getId());
            periodiciteDAO.update(periodicite);

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

    // Initialisation
    public void initialize() {
        //Recuperation de la Revue a modifier
        periodiciteAModifier = receiveData();

        //set id
        idLabel.setText(String.valueOf(periodiciteAModifier.getId()));
        //set libelle
        libelleField.setText(String.valueOf(periodiciteAModifier.getLibelle()));
    }

    private Periodicite receiveData() {
        PeriodiciteHolder periodiciteHolder = PeriodiciteHolder.getInstance();
        return periodiciteHolder.getPeriodicite();
    }

    // Retour au menu
    public void returnToMenu() throws IOException {
        //Charger la page que l'on veux afficher
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Vue/Periodicite/menuGeneralPeriodicite.fxml"));
        //Creer une Scene contenant cette page
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        //Recuperer la Stage de l'ancienne page
        Stage stage = (Stage) this.affichage.getScene().getWindow();
        System.out.println(stage);
        //Afficher la nouvelle Scene dans l'ancienne Stage
        if (stage != null) {
            stage.setScene(scene);
            stage.setTitle("Menu Périodicité");
        }
    }
}
