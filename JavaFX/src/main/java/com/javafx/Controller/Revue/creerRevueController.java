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
        String messageErreur = "";

        affichageLabel.setText("");

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
            revue.setIdPeriodicite((Periodicite) periodiciteChoiceBox.getValue());
        }
        catch(IllegalArgumentException e)
        {
            messageErreur = messageErreur + e.getMessage() + "\n";
        }

        if (messageErreur.equals(""))
        {
            affichageLabel.setText(revue.toString());
            affichageLabel.setTextFill(Color.BLACK);
        }
        else
        {
            affichageLabel.setText(messageErreur);
            affichageLabel.setTextFill(Color.RED);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
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