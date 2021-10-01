package tests.DAO;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dao.AbonnementDAO;
import dao.ClientDAO;
import dao.MySQLDAOFactory;
import dao.PeriodiciteDAO;
import dao.RevueDAO;

public class MySqlDAOFactoryTest 
{

    MySQLDAOFactory mySqlDAOFactory = new MySQLDAOFactory();

    @Test
    public void testGetAbonnement()
    {
        AbonnementDAO abo1 = mySqlDAOFactory.getAbonnementDAO();
        AbonnementDAO abo2 = mySqlDAOFactory.getAbonnementDAO();      

        assertTrue(abo1==abo2);
    }

    @Test
    public void testGetClient()
    {
        ClientDAO client1 = mySqlDAOFactory.getClientDAO();
        ClientDAO client2 = mySqlDAOFactory.getClientDAO();      

        assertTrue(client1==client2);
    }

    @Test
    public void testGetRevue()
    {
        RevueDAO revue1 = mySqlDAOFactory.getRevueDAO();
        RevueDAO revue2 = mySqlDAOFactory.getRevueDAO();      
        
        assertTrue(revue1==revue2);
    }

    @Test
    public void testGetPeriodicite()
    {
        PeriodiciteDAO periode1 = mySqlDAOFactory.getPeriodiciteDAO();
        PeriodiciteDAO periode2 = mySqlDAOFactory.getPeriodiciteDAO();      
        
        assertTrue(periode1==periode2);
    }
}
