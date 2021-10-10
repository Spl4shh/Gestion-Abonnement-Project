package com.javafx.Controller.Revue;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class creerRevueController
{
    @FXML
    private Label affichageLabel;
    @FXML
    private TextField titreField = new TextField();
    @FXML
    private TextArea descriptionArea = new TextArea();
    @FXML
    private TextField tarifField = new TextField();
    @FXML
    private ComboBox periodiciteComboBox = new ComboBox();


    @FXML
    protected void boutonCreerRevueClick()
    {


        affichageLabel.setText(titreField.getText());
    }
}