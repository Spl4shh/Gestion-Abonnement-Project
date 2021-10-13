package com.javafx.Controller.Revue;

import com.javafx.Modele.dao.DAOFactory;
import com.javafx.Modele.dao.Persistance;
import com.javafx.Modele.metier.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import org.w3c.dom.events.MouseEvent;

public class menuGeneralRevueController implements Initializable
{

    @FXML
    private TableColumn<Revue, String> colDescription;

    @FXML
    private TableColumn<Revue, Integer> colId;

    @FXML
    private TableColumn<Revue, Integer> colIdPeriodicite;

    @FXML
    private TableColumn<Revue, Double> colTarifUnit;

    @FXML
    private TableColumn<Revue, String> colTitre;

    @FXML
    private TableView<Revue> tableViewRevue;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        colId.setCellValueFactory(new PropertyValueFactory<Revue, Integer>(""));

        colTitre.setCellValueFactory(new PropertyValueFactory<Revue, String>("titre"));

        colDescription.setCellValueFactory(new PropertyValueFactory<Revue, String>("description"));

        colTarifUnit.setCellValueFactory(new PropertyValueFactory<Revue, Double>("tarifNumero"));

        colIdPeriodicite.setCellValueFactory(new PropertyValueFactory<Revue, Integer>("idPeriodicite"));

        try
        {
            this.tableViewRevue.getItems().addAll(DAOFactory.getDAOFactory(Persistance.ListeMemoire).getRevueDAO().findAll());
            /*Resultat debug :
                Pourquoi rien ne s'affiche
                Les differentes revues existent bien en tant qu'item dans tableViewRevue
                Les colonnes ont le bon nom et chaque propertyValueFactory aussi
                Impossible de voir via le debugger s'il y a un element dans une colonne

             */
        } catch (SQLException e)
        {
            e.printStackTrace();
        }



        List<Revue> revue = this.tableViewRevue.getItems();
        for (Revue revueItem: revue)
        {
            System.out.println(revueItem.toString()); // OK les items existent bien
        }
    }

    @FXML
    void listViewOnClick(MouseEvent event)
    {

    }
}

