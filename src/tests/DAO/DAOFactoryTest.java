package tests.DAO;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dao.DAOFactory;
import dao.ListeMemoireDAOFactory;
import dao.MySQLDAOFactory;
import dao.Persistance;

public class DAOFactoryTest 
{
    DAOFactory daoF;
    @Test
    public void testGetDAOFactory()
    {
        Persistance persistance = Persistance.ListeMemoire;

        daoF = DAOFactory.getDAOFactory(persistance);

        assertTrue(daoF instanceof ListeMemoireDAOFactory);

        persistance = Persistance.MYSQL;

        daoF = DAOFactory.getDAOFactory(persistance);

        assertTrue(daoF instanceof MySQLDAOFactory);
    }
}