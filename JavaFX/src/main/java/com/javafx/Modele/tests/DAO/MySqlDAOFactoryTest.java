package com.javafx.Modele.tests.DAO;

import static org.junit.Assert.assertTrue;

import com.javafx.Modele.dao.*;
import org.junit.Test;

public class MySqlDAOFactoryTest 
{

    MySQLDAOFactory mySqlDAOFactory = new MySQLDAOFactory();

    @Test
    public void testGetAbonnement()
    {
        AbonnementDAO abo1 = mySqlDAOFactory.getAbonnementDAO();
        AbonnementDAO abo2 = mySqlDAOFactory.getAbonnementDAO();      
        //Verification de la meme adresse
        assertTrue(abo1==abo2);
    }

    @Test
    public void testGetClient()
    {
        ClientDAO client1 = mySqlDAOFactory.getClientDAO();
        ClientDAO client2 = mySqlDAOFactory.getClientDAO();
        //Verification de la meme adresse
        assertTrue(client1==client2);
    }

    @Test
    public void testGetRevue()
    {
        RevueDAO revue1 = mySqlDAOFactory.getRevueDAO();
        RevueDAO revue2 = mySqlDAOFactory.getRevueDAO();
        //Verification de la meme adresse
        assertTrue(revue1==revue2);
    }

    @Test
    public void testGetPeriodicite()
    {
        PeriodiciteDAO periode1 = mySqlDAOFactory.getPeriodiciteDAO();
        PeriodiciteDAO periode2 = mySqlDAOFactory.getPeriodiciteDAO();
        //Verification de la meme adresse
        assertTrue(periode1==periode2);
    }
}
