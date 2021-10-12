package com.javafx.Controller.Revue;

import com.javafx.Modele.dao.DAOFactory;
import com.javafx.Modele.dao.Persistance;
import com.javafx.Modele.metier.Revue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.ListView;
import org.w3c.dom.events.MouseEvent;

public class menuGeneralRevueController implements Initializable
{
    @FXML
    private ListView<Revue> revueListView;

    @FXML
    private TableView<Revue> tableViewRevue = new TableView<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        TableColumn<Revue, Integer> colId =  new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Revue, String> colTitre =  new TableColumn<>("Titre");
        colTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));

        TableColumn<Revue, String> colDescription =  new TableColumn<>("Description");
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Revue, Double> colTarifUnit =  new TableColumn<>("Tarif Unitaire");
        colTarifUnit.setCellValueFactory(new PropertyValueFactory<>("tarifNumero"));

        TableColumn<Revue, Integer> colIdPeriodicite =  new TableColumn<>("ID Périodicité");
        colIdPeriodicite.setCellValueFactory(new PropertyValueFactory<>("idPeriodicite"));

        this.tableViewRevue.getColumns().addAll(colId, colTitre, colDescription, colTarifUnit, colIdPeriodicite);


        List<Revue> liste = null;
        try
        {
            liste = DAOFactory.getDAOFactory(Persistance.ListeMemoire).getRevueDAO().findAll();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        this.tableViewRevue.getItems().addAll(liste);
        for (Revue revue : liste)
        {
            System.out.println(revue);
        }

    }

    @FXML
    void listViewOnClick(MouseEvent event)
    {

    }
}

