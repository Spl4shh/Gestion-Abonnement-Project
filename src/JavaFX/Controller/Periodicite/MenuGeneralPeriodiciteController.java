package JavaFX.Controller.Periodicite;

import JavaFX.Application;
import JavaFX.Controller.Revue.RevueHolder;
import dao.DAOFactory;
import dao.PeriodiciteDAO;
import dao.Persistance;
import dao.RevueDAO;
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
import javafx.stage.Stage;
import jdk.internal.jrtfs.JrtFileSystemProvider;
import metier.Periodicite;
import metier.Revue;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MenuGeneralPeriodiciteController implements Initializable, ChangeListener<Periodicite> {

    PeriodiciteDAO periodiciteDAO = DAOFactory.getDAOFactory(Persistance.ListeMemoire).getPeriodiciteDAO();

    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnSupprimer;

    @FXML
    private TableColumn<Periodicite, Integer> colId;

    @FXML
    private TableColumn<Periodicite, String> colLibelle;

    @FXML
    private TableView<Periodicite> tableViewPeriodicite;

    @FXML
    void btnAjouterClick(ActionEvent event) throws IOException {
        //Charger la page que l'on veux afficher
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Vue/Periodicite/creerPeriodicite.fxml"));
        //Creer une Scene contenant cette page
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        //Recuperer la Stage de l'ancienne page
        Stage stage = (Stage) tableViewPeriodicite.getScene().getWindow();
        //Afficher la nouvelle Scene dans l'ancienne Stage
        stage.setScene(scene);
    }

    @FXML
    void btnModifierClick(ActionEvent event) throws IOException {
        Periodicite periodiciteAModifier = this.tableViewPeriodicite.getSelectionModel().getSelectedItem();
        sendData(periodiciteAModifier);

        //Charger la page que l'on veux afficher
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Vue/Periodicite/modifierPeriodicite.fxml"));
        //Creer une Scene contenant cette page
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        //Recuperer la Stage de l'ancienne page
        Stage stage = (Stage) tableViewPeriodicite.getScene().getWindow();
        //Afficher la nouvelle Scene dans l'ancienne Stage
        stage.setScene(scene);
    }

    @FXML
    void btnSupprimerClick(ActionEvent event) throws SQLException {
        Periodicite periodiciteASupprimer = this.tableViewPeriodicite.getSelectionModel().getSelectedItem();

        //code test
        periodiciteDAO.delete(periodiciteASupprimer);

        //Reset la liste
        genererListePeriodicite();
    }

    public void genererListePeriodicite()
    {
        //Permet de supprimer tout les elements afficher dans le tableau
        //Pour ensuite re importer uniquement ceux dans la base
        this.tableViewPeriodicite.getItems().clear();
        try
        {
            //A modifier par une variable DAO
            this.tableViewPeriodicite.getItems().addAll(periodiciteDAO.findAll());
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //@Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        //Definir les propriétés des differentes colonnes
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));

        genererListePeriodicite();

        //Appliquer le listener sur la selection et desactiver les boutons
        this.tableViewPeriodicite.getSelectionModel().selectedItemProperty().addListener(this);
        this.btnSupprimer.setVisible(false);
        this.btnModifier.setVisible(false);
    }

    //@Override
    public void changed(ObservableValue<? extends Periodicite> observable, Periodicite oldValue, Periodicite newValue)
    {
        /*
        Si l'item selectionné n'est pas nul, ca veux dire qu'une ligne est select
         */
        this.btnSupprimer.setVisible(!(newValue == null));
        this.btnModifier.setVisible(!(newValue == null));
    }

    private void sendData(Periodicite periodicite) {
        PeriodiciteHolder periodiciteHolder = PeriodiciteHolder.getInstance();
        periodiciteHolder.setPeriodicite(periodicite);
    }
}
