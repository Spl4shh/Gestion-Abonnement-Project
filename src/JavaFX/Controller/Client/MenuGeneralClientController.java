package JavaFX.Controller.Client;

import JavaFX.Application;
import JavaFX.Controller.Abonnement.AbonnementHolder;
import JavaFX.Controller.DAO.DAOHolder;
import dao.AbonnementDAO;
import dao.ClientDAO;
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
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import metier.Abonnement;
import metier.Adresse;
import metier.Client;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MenuGeneralClientController implements Initializable, ChangeListener<Client>
{
    ClientDAO clientDAO = (ClientDAO) DAOHolder.getInstance().getDaoFactory().getClientDAO();

    @FXML
    private Button btnAjouter;

    @FXML
    private Button boutonRetour;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnSupprimer;

    @FXML
    private TableColumn<Client, Adresse> colAdresse;

    @FXML
    private TableColumn<Client, Integer> colId;

    @FXML
    private TableColumn<Client, Integer> colNom;

    @FXML
    private TableColumn<Client, String> colPrenom;

    @FXML
    private TableView<Client> tableViewClient;

    @FXML
    void boutonRetourClick(ActionEvent event) throws IOException
    {
        //Charger la page que l'on veux afficher
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Vue/DAO/choixTable.fxml"));
        //Creer une Scene contenant cette page
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        //Recuperer la Stage de l'ancienne page
        Stage stage = (Stage) tableViewClient.getScene().getWindow();
        //Afficher la nouvelle Scene dans l'ancienne Stage
        stage.setScene(scene);
    }

    @FXML
    void btnAjouterClick(ActionEvent event) throws IOException
    {
        //Charger la page que l'on veux afficher
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Vue/Client/creerClient.fxml"));
        //Creer une Scene contenant cette page
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        //Recuperer la Stage de l'ancienne page
        Stage stage = (Stage) tableViewClient.getScene().getWindow();
        //Afficher la nouvelle Scene dans l'ancienne Stage
        stage.setScene(scene);
    }

    @FXML
    void btnModifierClick(ActionEvent event) throws IOException
    {
        Client clientAModifier = this.tableViewClient.getSelectionModel().getSelectedItem();
        sendData(clientAModifier);

        //Charger la page que l'on veux afficher
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Vue/Client/modifierClient.fxml"));
        //Creer une Scene contenant cette page
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        //Recuperer la Stage de l'ancienne page
        Stage stage = (Stage) tableViewClient.getScene().getWindow();
        //Afficher la nouvelle Scene dans l'ancienne Stage
        stage.setScene(scene);
    }

    @FXML
    void btnSupprimerClick(ActionEvent event) throws SQLException {
        Client clientASupprimer = this.tableViewClient.getSelectionModel().getSelectedItem();
        /*
        Supprimer le Client de la DAO utilisé
        */

        //code test
        clientDAO.delete(clientASupprimer);

        //Reset la liste
        genererListeClient();
    }

    @Override
    public void changed(ObservableValue<? extends Client> observableValue, Client oldValue, Client newValue)
    {
        /*
        Si l'item selectionné n'est pas nul, ca veux dire qu'une ligne est select
         */
        this.btnSupprimer.setVisible(!(newValue == null));
        this.btnModifier.setVisible(!(newValue == null));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));

        genererListeClient();

        //Appliquer le listener sur la selection et desactiver les boutons
        this.tableViewClient.getSelectionModel().selectedItemProperty().addListener(this);
        this.btnSupprimer.setVisible(false);
        this.btnModifier.setVisible(false);

        tableViewClient.setRowFactory(tableRow ->
        {
            TableRow<Client> row = new TableRow<>();
            row.setOnMouseClicked(event ->
            {
                if (event.getClickCount() == 2 && (! row.isEmpty()) )
                {
                    sendData(row.getItem());

                    //Charger la page que l'on veux afficher
                    FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Vue/Client/afficherClient.fxml"));
                    //Creer une Scene contenant cette page
                    Scene scene = null;
                    try
                    {
                        scene = new Scene(fxmlLoader.load(), 600, 450);
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    //Recuperer la Stage de l'ancienne page
                    Stage stage = (Stage) tableViewClient.getScene().getWindow();
                    //Afficher la nouvelle Scene dans l'ancienne Stage
                    stage.setScene(scene);
                }
            });
            return row ;
        });
    }

    public void genererListeClient()
    {
        //Permet de supprimer tout les elements afficher dans le tableau
        //Pour ensuite re importer uniquement ceux dans la base
        this.tableViewClient.getItems().clear();
        try
        {
            //A modifier par une variable DAO
            this.tableViewClient.getItems().addAll(clientDAO.findAll());
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private void sendData(Client client)
    {
        ClientHolder clientHolder = ClientHolder.getInstance();
        clientHolder.setClient(client);
    }
}
