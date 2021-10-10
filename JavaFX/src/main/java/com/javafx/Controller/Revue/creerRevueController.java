package com.javafx.Controller.Revue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
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
        int idPeriodicite = (int)periodiciteChoiceBox.getValue();

        affichageLabel.setText(String.valueOf(idPeriodicite));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
/*
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        DAOFactory dao = DAOFactory.getDAOFactory(Persistance.ListeMemoire);
        this.cbxPeriodicite.setItems(FXCollections.observableArrayList(dao.getPeriodiciteDAO().findAll()));
    }
    */

}