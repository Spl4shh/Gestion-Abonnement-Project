package com.javafx.Controller.Revue;

import com.javafx.Modele.dao.DAOFactory;
import com.javafx.Modele.dao.Persistance;
import com.javafx.Modele.metier.Revue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.ListView;
import org.w3c.dom.events.MouseEvent;

public class menuGeneralRevueController implements Initializable
{

    @FXML
    private final TableView<Revue> tableViewRevue = new TableView<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        TableColumn<Revue, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<Revue, Integer>("id"));

        TableColumn<Revue, String> colTitre = new TableColumn<>("Titre");
        colTitre.setCellValueFactory(new PropertyValueFactory<Revue, String>("titre"));

        TableColumn<Revue, String> colDescription = new TableColumn<>("Description");
        colDescription.setCellValueFactory(new PropertyValueFactory<Revue, String>("description"));

        TableColumn<Revue, Double> colTarifUnit = new TableColumn<>("Tarif Unitaire");
        colTarifUnit.setCellValueFactory(new PropertyValueFactory<Revue, Double>("tarifNumero"));

        TableColumn<Revue, Integer> colIdPeriodicite = new TableColumn<>("ID Périodicité");
        colIdPeriodicite.setCellValueFactory(new PropertyValueFactory<Revue, Integer>("idPeriodicite"));

        this.tableViewRevue.getColumns().setAll(colId, colTitre, colDescription, colTarifUnit, colIdPeriodicite);

        try
        {
            this.tableViewRevue.getItems().addAll(DAOFactory.getDAOFactory(Persistance.ListeMemoire).getRevueDAO().findAll());
            /* Resultat debug :
            
                Pourquoi rien ne s'affiche


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

