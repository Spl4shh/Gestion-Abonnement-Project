package JavaFX.Controller.Periodicite;

import JavaFX.Application;
import JavaFX.Controller.Revue.RevueHolder;
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
import javafx.stage.Stage;
import metier.Periodicite;
import metier.Revue;

import java.io.IOException;

public class modifierPeriodiciteController
{

    Periodicite periodiciteAModifier;
    DAOFactory dao = DAOFactory.getDAOFactory(Persistance.ListeMemoire);
    PeriodiciteDAO periodiciteDAO = dao.getPeriodiciteDAO();


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
    void boutonAnnuler(ActionEvent event) throws IOException {
        returnToMenu();
    }

    @FXML
    void boutonModifierPeriodicite(ActionEvent event)
    {
        String messageErreur = "";

        affichage.setText("");

        Periodicite periodicite = new Periodicite(0);

        // On teste le libelle
        try
        {
            periodicite.setLibelle(libelleField.getText());
        }
        catch (Exception e)
        {
            messageErreur= messageErreur + e.getMessage() + "\n";
        }

    }

    // Initialisation
    public  void initialize()
    {
        //set id
        idLabel.setText(String.valueOf(periodiciteAModifier.getId()));
        //set libelle
        libelleField.setText(String.valueOf(periodiciteAModifier.getLibelle()));
    }

    private Periodicite receiveData()
    {
        PeriodiciteHolder periodiciteHolder = PeriodiciteHolder.getInstance();
        return periodiciteHolder.getPeriodicite();
    }

    // Retour au menu
    public void returnToMenu() throws IOException
    {
        //Charger la page que l'on veux afficher
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Vue/Periodicite/menuGeneralPeriodicite.fxml"));
        //Creer une Scene contenant cette page
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        //Recuperer la Stage de l'ancienne page
        Stage stage = (Stage) this.affichage.getScene().getWindow();
        System.out.println(stage);
        //Afficher la nouvelle Scene dans l'ancienne Stage
        if (stage != null)
        {
            stage.setScene(scene);
        }
    }
}
