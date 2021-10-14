package JavaFX.Controller.Revue;

import dao.DAOFactory;
import dao.Persistance;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import metier.Revue;

public class menuGeneralRevueController implements Initializable, ChangeListener<Revue>
{
    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnSupprimer;

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

        this.tableViewRevue.getSelectionModel().selectedItemProperty().addListener(this);
        this.btnSupprimer.setDisable(true);
        this.btnModifier.setDisable(true);
    }

    @Override
    public void changed(ObservableValue<? extends Revue> observable, Revue oldValue, Revue newValue)
    {
        System.out.println("Hello");
        this.btnSupprimer.setDisable(newValue == null);
        this.btnModifier.setDisable(newValue == null);
    }
}

