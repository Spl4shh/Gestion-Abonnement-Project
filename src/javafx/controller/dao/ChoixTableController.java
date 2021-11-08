package javafx.controller.dao;

import javafx.Application;
import connexion.Connexion;
import dao.Persistance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class ChoixTableController implements Initializable
{
    DAOHolder daoHolder = DAOHolder.getInstance();

    @FXML
    private Button boutonAbonnement;

    @FXML
    private Button boutonClient;

    @FXML
    private Button boutonPeriodicite;

    @FXML
    private Button boutonRevue;

    @FXML
    private ChoiceBox<Persistance> choiceBoxPersistance;

    @FXML
    void boutonAbonnementClick(ActionEvent event) throws IOException
    {
        if(verifPersistance(choiceBoxPersistance.getValue()))
        {
            setFactory();
            setScene("Abonnement");
        }
        else
        {
            errorMySql();
        }
    }

    @FXML
    void boutonClientClick(ActionEvent event) throws IOException
    {
        if(verifPersistance(choiceBoxPersistance.getValue()))
        {
            setFactory();
            setScene("Client");
        }
        else
        {
            errorMySql();
        }
    }

    @FXML
    void boutonPeriodiciteClick(ActionEvent event) throws IOException
    {
        if(verifPersistance(choiceBoxPersistance.getValue()))
        {
            setFactory();
            setScene("Periodicite");
        }
        else
        {
            errorMySql();
        }
    }

    @FXML
    void boutonRevueClick(ActionEvent event) throws IOException
    {
        if(verifPersistance(choiceBoxPersistance.getValue()))
        {
            setFactory();
            setScene("Revue");
        }
        else
        {
            errorMySql();
        }
    }

    public void setFactory()
    {
        DAOHolder daoHolder = DAOHolder.getInstance();
        daoHolder.setDaoFactory(choiceBoxPersistance.getValue());
    }

    public void setScene(String table) throws IOException
    {
        // On recupere la Scene actuelle afin d'avoir les dimensions et le Stage
        Scene actualScene = choiceBoxPersistance.getScene();

        //Charger la page que l'on veux afficher
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Vue/"+table+"/menuGeneral"+table+".fxml"));
        //Creer une Scene contenant cette page
        Scene scene = new Scene(fxmlLoader.load(), actualScene.getWidth(), actualScene.getHeight());
        //Recuperer la Stage de l'ancienne page
        Stage stage = (Stage) actualScene.getWindow();
        //Afficher la nouvelle Scene dans l'ancienne Stage
        stage.setTitle("Menu " + table);
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        for (Persistance persistance : Persistance.values())
        {
            choiceBoxPersistance.getItems().add(persistance);
        }

        if (daoHolder.getPersistance() != null)
        {
            choiceBoxPersistance.setValue(daoHolder.getPersistance());
        }
        else
        {
            choiceBoxPersistance.setValue(Persistance.values()[1]);
        }
    }

    public boolean verifPersistance(Persistance persistance)
    {
        Connexion maBD;
        Connection laConnexion;

        if (persistance == Persistance.MYSQL)
        {

            maBD = Connexion.getInstance();
            laConnexion = maBD.creeConnexion();

            return !(laConnexion == null);
        }
        else
        {
            return true;
        }
    }

    public void errorMySql()
    {
        String message = "Immpossible de se connecter à la base de données.\nMerci d'activer le VPN, de verifier votre connexion, ou de choisir un autre moyen de Persistance";

        Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
        alert.setHeaderText("Erreur");
        alert.showAndWait();
    }
}
