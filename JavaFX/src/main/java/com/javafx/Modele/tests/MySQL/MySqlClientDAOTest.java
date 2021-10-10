package com.javafx.Modele.tests.MySQL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javafx.Modele.dao.ClientDAO;
import com.javafx.Modele.dao.DAOFactory;
import com.javafx.Modele.dao.Persistance;
import com.javafx.Modele.metier.Adresse;
import com.javafx.Modele.metier.Client;
import org.junit.Before;
import org.junit.Test;



public class MySqlClientDAOTest 
{
    private DAOFactory daof;
    private ClientDAO clientDAO;

    @Before
    public void setUp()
    {
        daof = DAOFactory.getDAOFactory(Persistance.MYSQL);
        clientDAO = daof.getClientDAO();
    }


    @Test
    public void testCreate() throws SQLException
    {
        Client client = new Client("Nom", "Prenom", new Adresse("1", "ma rue", "01234", "Ma ville", "France"));

        clientDAO.create(client);

        Client clientRead = clientDAO.getByNomPrenom(client.getNom(), client.getPrenom()).get(0);

        client.setId(clientRead.getId());

        assertTrue(client.equals(clientRead));

        clientDAO.delete(clientRead);
    }

    @Test
    public void testUpdate() throws SQLException
    {
        Client client = new Client("Nom", "Prenom", new Adresse("1", "ma rue", "01234", "Ma ville", "France"));

        clientDAO.create(client);

        Client clientUpdate = new Client("nouveau Nom", "nouveau Prenom", new Adresse("19", "ma nouvelle rue", "01234", "Ma nouvelle ville", "France"));

        Client clientRead = clientDAO.getByNomPrenom(client.getNom(), client.getPrenom()).get(0);

        clientUpdate.setId(clientRead.getId());

        clientDAO.update(clientUpdate);

        clientRead = clientDAO.getById(clientUpdate.getId());   

        assertTrue(clientUpdate.equals(clientRead));

        clientDAO.delete(clientRead);
    }

    @Test
    public void testDelete() throws SQLException
    {
        Client client = new Client("Code4589652", "Prenom", new Adresse("1", "ma rue", "12548", "Ma ville", "France"));

        clientDAO.create(client);

        Client clientRead = clientDAO.getByNomPrenom(client.getNom(), client.getPrenom()).get(0);

        client.setId(clientRead.getId());

        clientDAO.delete(clientRead);

        List<Client> liste = new ArrayList<>();

        liste = clientDAO.getByNomPrenom(client.getNom(), client.getPrenom());

        assertEquals(0, liste.size());
    }
}
