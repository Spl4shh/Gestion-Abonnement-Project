package javafx.controller.periodicite;

import javafx.Application;
import javafx.controller.dao.DAOHolder;
import dao.PeriodiciteDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import metier.Periodicite;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CreerPeriodiciteController
{

    PeriodiciteDAO periodiciteDAO = (PeriodiciteDAO) DAOHolder.getInstance().getDaoFactory().getPeriodiciteDAO();

    @FXML
    private Label affichageLabel;

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
    void boutonCreerPeriodicite(ActionEvent event) throws IOException, SQLException {
        String messageErreur = "";
        affichageLabel.setText("");

        Periodicite periodiciteACreer = new Periodicite(0);

        //Try Libelle
        try
        {
            periodiciteACreer.setLibelle(libelleField.getText());
        }
        catch(IllegalArgumentException e)
        {
            messageErreur = messageErreur + e.getMessage() + "\n";
        }

        if (messageErreur.equals(""))
        {
            List<Periodicite> listPeriodicite = periodiciteDAO.findAll();
            if(!isDoublon(listPeriodicite, periodiciteACreer))
            {
                periodiciteDAO.create(periodiciteACreer);
                returnToMenu();
            }
            else
            {
                Alert info = new Alert(Alert.AlertType.INFORMATION, "Cette périodicité existe deja");
                info.showAndWait();
            }
        }
        else
        {
            affichageLabel.setText(messageErreur);
            affichageLabel.setTextFill(Color.RED);
        }
    }

    public void returnToMenu() throws IOException
    {
        //Scene actuelle
        Scene actualScene = affichageLabel.getScene();

        //Charger la page que l'on veux afficher
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Vue/Periodicite/menuGeneralPeriodicite.fxml"));
        //Creer une Scene contenant cette page
        Scene scene = new Scene(fxmlLoader.load(), actualScene.getWidth(), actualScene.getHeight());
        //Recuperer la Stage de l'ancienne page
        Stage stage = (Stage) actualScene.getWindow();
        //Afficher la nouvelle Scene dans l'ancienne Stage
        stage.setScene(scene);
        stage.setTitle("Menu Périodicité");
    }

    private boolean isDoublon(List<Periodicite> listeItem, Periodicite itemToCheck)
    {
        for (Periodicite item : listeItem)
        {
            if (itemToCheck.equals(item))
            {
                return true;
            }
        }
        return false;
    }

}
