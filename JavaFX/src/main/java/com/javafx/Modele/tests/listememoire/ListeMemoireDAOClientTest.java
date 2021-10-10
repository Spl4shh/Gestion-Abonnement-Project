package com.javafx.Modele.tests.listememoire;

import com.javafx.Modele.dao.ClientDAO;
import com.javafx.Modele.dao.DAOFactory;
import com.javafx.Modele.dao.Persistance;
import com.javafx.Modele.metier.Adresse;
import com.javafx.Modele.metier.Client;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.sql.SQLException;


public class ListeMemoireDAOClientTest
{

    private DAOFactory daof;
    private ClientDAO clientDAO;

    @Before
    public void setUp() 
    {
        daof = DAOFactory.getDAOFactory(Persistance.ListeMemoire);
        clientDAO = daof.getClientDAO();
    }

    @Test
    public void testCreate() throws SQLException
    {
        Client clientAVerif = new Client(3, "Name", "Surname", new Adresse("8", "Ma rue", "Mon code poste", "Marange", "France"));

        clientDAO.create(clientAVerif);

        Client clientRead = clientDAO.getById(clientAVerif.getId());

        assertEquals(clientAVerif, clientRead);
    }

    @Test
    public void testUpdate() throws SQLException
    {
        Client clientAVerif = new Client(3, "Name", "Surname",  new Adresse("8", "Ma rue", "Mon code poste", "Marange", "France"));

        clientDAO.create(clientAVerif);

        Client clientRead = clientDAO.getById(clientAVerif.getId());

        Client clientUpdate = new Client(3, "New Name", "New Surname",  new Adresse("8897", "Ma rue nouvelle", "Mon nouveau code poste", "Marange", "France"));

        clientDAO.update(clientUpdate);

        clientRead = clientDAO.getById(clientUpdate.getId());

        assertEquals(clientUpdate, clientRead);
    }

    @Test
    public void testDelete() throws SQLException
    {
        Client clientAVerif = new Client(3, "Name", "Surname",  new Adresse("8", "Ma rue", "Mon code poste", "Marange", "France"));

        clientDAO.create(clientAVerif);

        clientDAO.delete(clientAVerif);

        assertFalse(clientDAO.findAll().contains(clientAVerif));
    }
}
