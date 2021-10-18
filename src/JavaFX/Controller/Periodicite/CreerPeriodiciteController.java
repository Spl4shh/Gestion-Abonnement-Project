package JavaFX.Controller.Periodicite;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
<<<<<<< HEAD
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import metier.Abonnement;
import metier.Periodicite;
import metier.Revue;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
=======
>>>>>>> parent of 9651865 (annuler ok)

public class CreerPeriodiciteController {

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
    void boutonAnnuler(ActionEvent event) {

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

<<<<<<< HEAD
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

=======
>>>>>>> parent of 9651865 (annuler ok)
}
