package JavaFX.Controller.Client;

import JavaFX.Application;
//import JavaFX.Controller.Abonnement.AbonnementHolder;
import JavaFX.Controller.DAO.DAOHolder;
import dao.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import metier.*;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class MenuGeneralClientController implements Initializable, ChangeListener<Client>
{
    private static final String DELIMITER = ";";

    ClientDAO clientDAO = (ClientDAO) DAOHolder.getInstance().getDaoFactory().getClientDAO();

    @FXML
    private Button btnAjouter;

    @FXML
    private Button boutonRetour;

    @FXML
    private Button boutonImport;

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
    void boutonImportClick(ActionEvent event) throws IOException
    {
        JFileChooser dialogue = new JFileChooser(new File("."));
        File fichier;

        if (dialogue.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            final boolean isAccepted = dialogue.getSelectedFile().getName().toLowerCase().endsWith(".csv");

            if (isAccepted)
            {
                fichier = dialogue.getSelectedFile();
                try {
                    int nbReussi = importCsv(fichier);
                    String messageImport = "";

                    if (nbReussi == 0)
                    {
                        messageImport = "Aucun import reussi, uniquement des doublons";
                    }
                    else
                    {
                        messageImport = nbReussi + " import(s) reussi";
                    }

                    Alert alert = new Alert(Alert.AlertType.INFORMATION, messageImport);
                    alert.setHeaderText("Importation");
                    alert.showAndWait();
                    genererListeClient();

                } catch (IOException | SQLException e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Merci de selectionner un fichier .CSV");
                alert.setHeaderText("Importation");
                alert.showAndWait();
            }
        }
    }

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
        stage.setTitle("Gestion d'un systeme d'abonnement à des revues");
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
        stage.setTitle("Ajouter Client");
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
        stage.setTitle("Modifier Client");
        stage.setScene(scene);
    }

    @FXML
    void btnSupprimerClick(ActionEvent event) throws SQLException {
        {
            Client clientASupprimer = this.tableViewClient.getSelectionModel().getSelectedItem();

            //Creer une boite de confirmation
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Voulez vous supprimer le client numero " + clientASupprimer.getId() + " ?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES)
            {
                AbonnementDAO abonnementDAO = DAOHolder.getInstance().getDaoFactory().getAbonnementDAO();
                List<Abonnement> listeAbonnement = abonnementDAO.findAll();
                boolean clientExiste = false;

                //Verifier que la periodicite n'est pas utilisée ailleurs
                for (Abonnement abonnement : listeAbonnement)
                {
                    if (abonnement.getIdClient() == clientASupprimer.getId())
                    {
                        clientExiste = true;
                        break;
                    }
                }
                if (!clientExiste)
                {
                    clientDAO.delete(clientASupprimer);

                    //Reset la liste
                    genererListeClient();
                }
                else
                {
                    Alert info = new Alert(Alert.AlertType.INFORMATION, "Il existe un abonnement avec ce client");
                    info.showAndWait();
                }
            }
        }
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

        //Gestion Double Click
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
                    stage.setTitle("Client n° " + row.getItem().getId());
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

    public void sendData(Client client)
    {
        ClientHolder clientHolder = ClientHolder.getInstance();
        clientHolder.setClient(client);
    }

    public int importCsv(File fichier) throws IOException, SQLException
    {
        int nbImport = 0;

        FileReader fr = new FileReader(fichier);
        BufferedReader bfr = new BufferedReader(fr);
        String ligne = null;

        //lire la ligne d'entete
        bfr.readLine();

        //read each line of text file
        while((ligne = bfr.readLine()) != null)
        {
            //Recuperer tout les client pour verifier les doublons
            List<Client> listClient = clientDAO.findAll();
            Client clientACreer = new Client(0);

            //Separer la ligne en mot avec chaque delimiteur
            StringTokenizer stk = new StringTokenizer(ligne,DELIMITER);

            //On affecte au client a ajouter les differents champs
            clientACreer.setNom((String)stk.nextElement());
            clientACreer.setPrenom((String) stk.nextElement());
            Adresse adresse = new Adresse((String)stk.nextElement(), (String)stk.nextElement(), (String)stk.nextElement(), (String)stk.nextElement(), (String)stk.nextElement());
            clientACreer.setAdresse(ProcessAdress.normalize(adresse));

            boolean doublon = false;

            //On va verifier si le client a creer ne correspond pas a un client existant
            for (Client client : listClient)
            {
                clientACreer.setId(client.getId());
                if (!doublon)
                {
                    doublon = clientACreer.equals(client);
                }
            }

            if(!doublon)
            {
                clientDAO.create(clientACreer);
                nbImport ++;
            }
        }
        //Fermer le fichier
        bfr.close();
        return nbImport;
    }
}
