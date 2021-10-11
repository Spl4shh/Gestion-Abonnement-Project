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
        String titre = titreField.getText();
        String tarif = tarifField.getText();
        String description = descriptionArea.getText();
        periodiciteChoiceBox.getValue();

        try
        {
            if (titre != null && !titre.equals(""))
            {
                if (description != null && !description.equals(""))
                {
                    if (tarif != null && !tarif.equals(""))
                    {
                        float tarifFloat = Float.parseFloat(tarif);
                        if (periodiciteChoiceBox.getValue() != null)
                        {
                            Periodicite itemPeriodicite = (Periodicite) periodiciteChoiceBox.getValue();
                            int idPeriodicite = itemPeriodicite.getId();

                            Revue revue = new Revue(titre, description, tarifFloat, "", idPeriodicite);

                            affichageLabel.setText(revue.toString());
                        }
                        else{affichageLabel.setText("Merci de saisir une periodicité");}
                    }
                    else{affichageLabel.setText("Merci de saisir un tarif");}
                }
                else {affichageLabel.setText("Merci de saisir une description");}
            }
            else {affichageLabel.setText("Merci de saisir un titre");}
        }
        catch (IllegalArgumentException e)
        {
            affichageLabel.setText("Merci de saisir un nombre en tant que tarif");
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