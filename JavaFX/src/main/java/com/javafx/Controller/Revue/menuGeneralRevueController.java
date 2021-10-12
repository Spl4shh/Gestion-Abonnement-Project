package com.javafx.Controller.Revue;

import com.javafx.Modele.dao.DAOFactory;
import com.javafx.Modele.dao.Persistance;
import com.javafx.Modele.metier.Revue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.w3c.dom.events.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.control.ListView;

public class menuGeneralRevueController implements Initializable
{
        @FXML
        private ListView<Revue> revueListView;

        @FXML
        void listViewOnClick(MouseEvent event)
        {

        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle)
        {
            DAOFactory dao = DAOFactory.getDAOFactory(Persistance.ListeMemoire);

            try
            {
                ObservableList<Revue> observableList = FXCollections.observableArrayList(dao.getRevueDAO().findAll());

                this.revueListView.setItems(observableList);
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
}

