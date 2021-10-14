package JavaFX.Controller.Revue;

import JavaFX.Application;
import dao.DAOFactory;
import dao.Persistance;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.stage.Stage;
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

    @FXML
    void btnAjouterClick(ActionEvent event) throws IOException
    {
        //Charger la page que l'on veux afficher
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Vue/Revue/creerRevue.fxml"));
        //Creer une Scene contenant cette page
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        //Recuperer la Stage de l'ancienne page
        Stage stage = (Stage) tableViewRevue.getScene().getWindow();
        //Afficher la nouvelle Scene dans l'ancienne Stage
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        colTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));

        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        colTarifUnit.setCellValueFactory(new PropertyValueFactory<>("tarifNumero"));

        colIdPeriodicite.setCellValueFactory(new PropertyValueFactory<>("idPeriodicite"));

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
        this.btnSupprimer.setDisable(newValue == null);
        this.btnModifier.setDisable(newValue == null);
    }
}

