package dao;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

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