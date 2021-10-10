package com.javafx.Modele.tests.DAO;

import static org.junit.Assert.assertTrue;

import com.javafx.Modele.dao.*;
import org.junit.Test;

public class ListeMemoireDAOFactoryTest 
{

    ListeMemoireDAOFactory listeMemoireDAOFactory = new ListeMemoireDAOFactory();

    @Test
    public void testGetAbonnement()
    {
        AbonnementDAO abo1 = listeMemoireDAOFactory.getAbonnementDAO();
        AbonnementDAO abo2 = listeMemoireDAOFactory.getAbonnementDAO();      
        
        assertTrue(abo1==abo2);
    }

    @Test
    public void testGetClient()
    {
        ClientDAO client1 = listeMemoireDAOFactory.getClientDAO();
        ClientDAO client2 = listeMemoireDAOFactory.getClientDAO();      
        
        assertTrue(client1==client2);
    }

    @Test
    public void testGetRevue()
    {
        RevueDAO revue1 = listeMemoireDAOFactory.getRevueDAO();
        RevueDAO revue2 = listeMemoireDAOFactory.getRevueDAO();      
        
        assertTrue(revue1==revue2);
    }

    @Test
    public void testGetPeriodicite()
    {
        PeriodiciteDAO periode1 = listeMemoireDAOFactory.getPeriodiciteDAO();
        PeriodiciteDAO periode2 = listeMemoireDAOFactory.getPeriodiciteDAO();      
        
        assertTrue(periode1==periode2);
    }
}
