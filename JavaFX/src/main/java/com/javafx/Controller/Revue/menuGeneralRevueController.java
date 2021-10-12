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
import java.util.ResourceBundle;
import javafx.scene.control.ListView;

public class menuGeneralRevueController implements Initializable
{
        @FXML
        private ListView<Revue> revueListView;

        @FXML
        private TableView<Revue> tableViewRevue;

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle)
        {
            DAOFactory dao = DAOFactory.getDAOFactory(Persistance.ListeMemoire);

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

            this.tableViewRevue.getColumns().setAll(colId, colTitre, colDescription, colTarifUnit, colIdPeriodicite);

            try
            {
                this.tableViewRevue.getItems().addAll(dao.getRevueDAO().findAll());
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
}

