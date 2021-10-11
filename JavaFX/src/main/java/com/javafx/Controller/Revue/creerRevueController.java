package com.javafx.Controller.Revue;

import com.javafx.Modele.dao.DAOFactory;
import com.javafx.Modele.dao.Persistance;
import com.javafx.Modele.metier.Periodicite;
import com.javafx.Modele.metier.Revue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class creerRevueController implements Initializable
{
    @FXML
    private Label affichageLabel;

    @FXML
    private Button boutonCreer;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private TextField tarifField;

    @FXML
    private TextField titreField;

    @FXML
    private ChoiceBox periodiciteChoiceBox;

    @FXML
    void boutonCreerRevueClick(ActionEvent event)
    {
        String titre = null;
        double tarifDouble = 0;
        String description = null;
        String messageErreur = "";
        Periodicite itemPeriodicite = null;
        boolean erreur = false;

        affichageLabel.setText("");
        affichageLabel.setTextFill(Color.RED);

        Revue revue = null;

        /*
        try
        {
            if (titreField.getText() != null && !titreField.getText().equals(""))
            {
                titre = titreField.getText();
            }
            else
            {
                messageErreur = messageErreur + "Merci de saisir un titre\n";
                erreur = true;
            }

            if (descriptionArea.getText() != null && !descriptionArea.getText().equals(""))
            {
                description = descriptionArea.getText();
            }
            else
            {
                messageErreur = messageErreur + "Merci de saisir une description\n";
                erreur = true;
            }

            if (periodiciteChoiceBox.getValue() != null)
            {
                itemPeriodicite = (Periodicite) periodiciteChoiceBox.getValue();
            }
            else
            {
                messageErreur = messageErreur + "Merci de saisir une periodicité\n";
                erreur = true;
            }

            if (tarifField.getText() != null && !tarifField.getText().equals(""))
            {
                tarifDouble = Double.parseDouble(tarifField.getText());
            }
            else
            {
                messageErreur = messageErreur + "Merci de saisir un tarif\n";
                erreur = true;
            }
        }
        catch (IllegalArgumentException e)
        {
            messageErreur = messageErreur + "Merci de saisir un nombre en tant que tarif";
            erreur = true;
        }


        if (erreur)
        {
            affichageLabel.setText(messageErreur);
            affichageLabel.setTextFill(Color.RED);
        }
        else
        {
            Revue revue = new Revue(titre, description, tarifDouble, "", itemPeriodicite);

            affichageLabel.setText(revue.toString());
            affichageLabel.setTextFill(Color.BLACK);
        }

         */
        System.out.println(tarifField.getText());
        try
        {
            revue = new Revue(titreField.getText(), descriptionArea.getText(), Double.parseDouble(tarifField.getText()), "", (Periodicite)periodiciteChoiceBox.getValue());
            affichageLabel.setText(revue.toString());
            affichageLabel.setTextFill(Color.BLACK);
        }
        catch(IllegalArgumentException exception)
        {
            affichageLabel.setText(affichageLabel.getText() + exception.getMessage() + "\n");
            affichageLabel.setTextFill(Color.RED);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DAOFactory dao = DAOFactory.getDAOFactory(Persistance.ListeMemoire);

        try
        {
            this.periodiciteChoiceBox.setItems(FXCollections.observableArrayList(dao.getPeriodiciteDAO().findAll()));
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}