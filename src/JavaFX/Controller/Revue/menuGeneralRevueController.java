package JavaFX.Controller.Revue;

import dao.DAOFactory;
import dao.Persistance;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import metier.Revue;
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
        colId.setCellValueFactory(new PropertyValueFactory<Revue, Integer>("id"));

        colTitre.setCellValueFactory(new PropertyValueFactory<Revue, String>("titre"));

        colDescription.setCellValueFactory(new PropertyValueFactory<Revue, String>("description"));

        colTarifUnit.setCellValueFactory(new PropertyValueFactory<Revue, Double>("tarifNumero"));

        colIdPeriodicite.setCellValueFactory(new PropertyValueFactory<Revue, Integer>("idPeriodicite"));

        try
        {
            this.tableViewRevue.getItems().addAll(DAOFactory.getDAOFactory(Persistance.ListeMemoire).getRevueDAO().findAll());
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    void listViewOnClick(MouseEvent event)
    {

    }
}

